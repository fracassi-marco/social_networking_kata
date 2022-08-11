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
package production;

import java.util.List;
import java.util.stream.Collectors;

public class Wall implements Command {

    private final String _command;
    private final Subscriptions _subscriptions;
    private final String SEPARATOR = " wall";

    public Wall(String command, Subscriptions subscriptions) {
        _command = command;
        _subscriptions = subscriptions;
    }

    @Override
    public boolean canBeExecuted() {
        return _command.endsWith(SEPARATOR);
    }

    @Override
    public List<String> execute(Messages messages, Time executionTime) {
        List<String> users = _subscriptions.of(user());
        users.add(user());
        return messages.of(users)
                .map(message -> message.fullText(executionTime))
                .collect(Collectors.toList());
    }

    private String user() {
        return _command.split(SEPARATOR)[0];
    }
}
