/* Copyright 2018 Marco Fracassi
 *
 * This file is part of social-networking-kata.
 *
 * social-networking-kata is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * social-networking-kata is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with social-networking-kata.  If not, see <http://www.gnu.org/licenses/>.
*/
package test;

import org.junit.jupiter.api.Test;
import production.DeltaTime;

import static org.assertj.core.api.Assertions.assertThat;

public class DeltaTimeTest {

    @Test
    public void shouldCalculateSeconds() {
        DeltaTime deltaTime = new DeltaTime(TimeAgo.now(), TimeAgo.seconds(8));

        assertThat(deltaTime.text()).isEqualTo("(8 seconds ago)");
    }

    @Test
    public void shouldCalculateMinutes() {
        DeltaTime deltaTime = new DeltaTime(TimeAgo.seconds(1), TimeAgo.seconds(121));

        assertThat(deltaTime.text()).isEqualTo("(2 minutes ago)");
    }

    @Test
    public void shouldTolerateSameTime() {
        DeltaTime deltaTime = new DeltaTime(TimeAgo.now(), TimeAgo.now());

        assertThat(deltaTime.text()).isEqualTo("(0 second ago)");
    }

    @Test
    public void shouldTolerateNegativeDelta() {
        DeltaTime deltaTime = new DeltaTime(TimeAgo.seconds(1), TimeAgo.now());

        assertThat(deltaTime.text()).isEqualTo("(0 second ago)");
    }
}
