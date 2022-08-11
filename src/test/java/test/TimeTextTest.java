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
import production.TimeText;

import static org.assertj.core.api.Assertions.assertThat;


public class TimeTextTest {

    @Test
    public void shouldUseSingular() {
        assertThat(new TimeText(1, "cat").text()).isEqualTo("(1 cat ago)");
    }

    @Test
    public void shouldPluralize() {
        assertThat(new TimeText(2, "dog").text()).isEqualTo("(2 dogs ago)");
    }

    @Test
    public void shouldRecognizeZeroAmount() {
        assertThat(new TimeText(0, "any").isNotZero()).isFalse();
        assertThat(new TimeText(1, "any").isNotZero()).isTrue();
    }
}
