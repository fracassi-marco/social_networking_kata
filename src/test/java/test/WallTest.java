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
import production.Subscriptions;
import production.Wall;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WallTest {

    @Test
    public void shouldBeExecuted() {
        assertThat(new Wall("Gigi wall", null).canBeExecuted()).isTrue();
        assertThat(new Wall("wall", null).canBeExecuted()).isFalse();
        assertThat(new Wall("wall Gigi", null).canBeExecuted()).isFalse();
    }

    @Test
    public void shouldGiveSubscriptionsMessages() {
        Subscriptions subscriptions = new Subscriptions();
        subscriptions.add("Gigi", "Bill");
        subscriptions.add("Gigi", "Luca");

        Messages messages = new Messages();
        messages.add(new Message("Bill", "beta", TimeAgo.now()));
        messages.add(new Message("Luca", "gamma", TimeAgo.now()));
        messages.add(new Message("Fabio", "delta", TimeAgo.now()));

        List<String> results = new Wall("Gigi wall", subscriptions).execute(messages, TimeAgo.now());

        assertThat(results).hasSize(2);
        assertThat(results.get(0)).contains("Luca - gamma");
        assertThat(results.get(1)).contains("Bill - beta");
    }

    @Test
    public void shouldGiveHisOwnMessages() {
        Subscriptions subscriptions = new Subscriptions();

        Messages messages = new Messages();
        messages.add(new Message("Gigi", "alfa", TimeAgo.now()));

        List<String> results = new Wall("Gigi wall", subscriptions).execute(messages, TimeAgo.now());

        assertThat(results).hasSize(1);
        assertThat(results.get(0)).contains("Gigi - alfa");
    }
}
