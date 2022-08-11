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

import static java.util.Collections.emptyList;

public class Follow implements Command {
    private final String SEPARATOR = " follows ";
    private final String _command;
    private final Subscriptions _subscriptions;

    public Follow(String command, Subscriptions subscriptions) {
        _command = command;
        _subscriptions = subscriptions;
    }

    @Override
    public boolean canBeExecuted() {
        return _command.contains(SEPARATOR);
    }

    @Override
    public List<String> execute(Messages messages, Time executionTime) {
        String user = user();
        _subscriptions.add(user, subscription());
        return emptyList();
    }

    private String subscription() {
        return tokens()[1];
    }

    private String user() {
        return tokens()[0];
    }

    private String[] tokens() {
        return _command.split(SEPARATOR);
    }
}
