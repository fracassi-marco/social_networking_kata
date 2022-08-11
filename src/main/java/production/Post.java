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

public class Post implements Command {
    private final String SEPARATOR = " -> ";
    private final String _command;

    public Post(String command) {
        _command = command;
    }

    public boolean canBeExecuted() {
        return _command.contains(SEPARATOR);
    }

    public List<String> execute(Messages messages, Time executionTime) {
        String[] tokens = _command.split(SEPARATOR);
        String user = tokens[0];
        String content = tokens[1];
        messages.add(new Message(user, content, executionTime));
        return emptyList();
    }
}
