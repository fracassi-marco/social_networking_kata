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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageTest {

    @Test
    public void shouldFindOwner() {
        Message message = new Message("Paolo", "any", null);

        assertThat(message.isPostedByOneOfThisUsers(List.of("Luca", "Paolo"))).isTrue();
        assertThat(message.isPostedByOneOfThisUsers(List.of("Luca"))).isFalse();
    }

    @Test
    public void shouldFormatShortText() {
        Message message = new Message("Paolo", "my message", TimeAgo.seconds(32));

        assertThat(message.shortText(TimeAgo.now())).isEqualTo("my message (32 seconds ago)");
    }

    @Test
    public void shouldFormatFullText() {
        Message message = new Message("Paolo", "my message", TimeAgo.seconds(41));

        assertThat(message.fullText(TimeAgo.now())).isEqualTo("Paolo - my message (41 seconds ago)");
    }
}
