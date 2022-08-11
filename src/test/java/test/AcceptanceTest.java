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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import production.SocialNetworking;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTest {

    private SocialNetworking _app;

    @BeforeEach
    public void before() {
        _app = new SocialNetworking();
    }

    @Test
    public void shouldSupportDescibedScenario() {
        _app.execute("Alice -> I love the weather today", TimeAgo.minutes(5));
        _app.execute("Bob -> Damn! We lost!", TimeAgo.minutes(2));
        _app.execute("Bob -> Good game though.", TimeAgo.minutes(1));
        assertOutputFor("Alice", "I love the weather today (5 minutes ago)");
        assertOutputFor("Bob",
                "Good game though. (1 minute ago)",
                        "Damn! We lost! (2 minutes ago)");
        _app.execute("Charlie -> I'm in New York today! Anyone wants to have a coffee?", TimeAgo.seconds(2));
        _app.execute("Charlie follows Alice", TimeAgo.now());
        assertOutputFor("Charlie wall",
                "Charlie - I'm in New York today! Anyone wants to have a coffee? (2 seconds ago)",
                        "Alice - I love the weather today (5 minutes ago)");
        _app.execute("Charlie follows Bob", TimeAgo.seconds(2));
        assertOutputFor("Charlie wall",
                "Charlie - I'm in New York today! Anyone wants to have a coffee? (2 seconds ago)",
                        "Bob - Good game though. (1 minute ago)",
                        "Bob - Damn! We lost! (2 minutes ago)",
                        "Alice - I love the weather today (5 minutes ago)");
    }

    private void assertOutputFor(String command, String... expected) {
        assertThat(_app.execute(command, TimeAgo.now())).isEqualTo(String.join("\n", expected));
    }
}
