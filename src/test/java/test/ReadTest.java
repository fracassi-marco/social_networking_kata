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
import production.Message;
import production.Messages;
import production.Read;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadTest {

    @Test
    public void shouldAlwaysBeExecuted() {
        assertThat(new Read("Gigi").canBeExecuted()).isTrue();
        assertThat(new Read("Gigi -> a").canBeExecuted()).isTrue();
        assertThat(new Read("Gigi wall").canBeExecuted()).isTrue();
        assertThat(new Read("Gigi follows Bibi").canBeExecuted()).isTrue();
    }

    @Test
    public void shouldReadMessagesOfSpecifiedUser() {
        Messages messages = new Messages();
        messages.add(new Message("Gigi", "cat", TimeAgo.now()));
        messages.add(new Message("Luca", "rabbit", TimeAgo.now()));
        messages.add(new Message("Gigi", "dog", TimeAgo.now()));

        List<String> results = new Read("Gigi").execute(messages, TimeAgo.now());

        assertThat(results).hasSize(2);
        assertThat(results.get(0)).contains("dog");
        assertThat(results.get(1)).contains("cat");
    }
}
