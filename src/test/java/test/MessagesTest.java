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

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MessagesTest {

    @Test
    public void shouldGiveMessageOfSpecifiedUsers() {
        Messages messages = new Messages();
        messages.add(new Message("Gigi", "foo", TimeAgo.now()));
        messages.add(new Message("Pino", "bar", TimeAgo.now()));
        messages.add(new Message("Ale", "baz", TimeAgo.now()));

        List<String> users = Arrays.asList("Gigi", "Ale");

        messages.of(users).forEach(message -> assertThat(message.isPostedByOneOfThisUsers(users)).isTrue());
    }
}
