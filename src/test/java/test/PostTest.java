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
import production.Messages;
import production.Post;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PostTest {

    @Test
    public void shouldBeExecuted() {
        assertThat(new Post("Gigi -> dog").canBeExecuted()).isTrue();
        assertThat(new Post("Gigi dog").canBeExecuted()).isFalse();
        assertThat(new Post("Gigi ->").canBeExecuted()).isFalse();
        assertThat(new Post("-> dog").canBeExecuted()).isFalse();
    }

    @Test
    public void shouldHasNoOutput() {
        Messages messages = new Messages();

        assertThat(new Post("Gigi -> dog").execute(messages, TimeAgo.now())).isEmpty();
    }

    @Test
    public void shouldAddToMessages() {
        Messages messages = new Messages();

        new Post("Gigi -> dog").execute(messages, TimeAgo.now());

        assertThat(messages.of(List.of("Gigi")).count()).isEqualTo(1L);
    }

    @Test
    public void shouldRecognizeContent() {
        Messages messages = new Messages();

        new Post("Gigi -> black dog").execute(messages, TimeAgo.seconds(1));

        assertThat(firstText(messages)).contains("black dog");
        assertThat(firstText(messages)).doesNotContain("->");
    }

    private String firstText(Messages messages) {
        return messages.of(List.of("Gigi")).findFirst().get().shortText(TimeAgo.now());
    }
}
