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
import production.SocialNetworking;

import static org.assertj.core.api.Assertions.assertThat;


public class SocialNetworkingTest {

    @Test
    public void shouldPostMessage() {
        String output = new SocialNetworking().execute("Gigi -> che freddo!", null);

        assertThat(output).isEqualTo("");
    }

    @Test
    public void shouldReadEmptyTimeline() {
        String output = new SocialNetworking().execute("Gigi", null);

        assertThat(output).isEqualTo("");
    }

    @Test
    public void shouldReadTimeline() {
        SocialNetworking socialNetworking = new SocialNetworking();
        socialNetworking.execute("Gigi -> che freddo!", TimeAgo.seconds(45));

        String output = socialNetworking.execute("Gigi", TimeAgo.now());

        assertThat(output).isEqualTo("che freddo! (45 seconds ago)");
    }

    @Test
    public void shouldFollowUsers() {
        SocialNetworking socialNetworking = new SocialNetworking();
        socialNetworking.execute("Gigi -> che freddo!", TimeAgo.seconds(45));
        socialNetworking.execute("Mario -> oggi che fate?", TimeAgo.seconds(30));
        socialNetworking.execute("Gigi follows Mario", TimeAgo.seconds(1));

        String output = socialNetworking.execute("Gigi wall", TimeAgo.now());

        assertThat(output).isEqualTo(
                "Mario - oggi che fate? (30 seconds ago)\n"+
                "Gigi - che freddo! (45 seconds ago)");
    }
}