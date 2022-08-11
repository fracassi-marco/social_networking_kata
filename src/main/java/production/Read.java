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

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Read implements Command {
    private final String _command;

    public Read(String command) {
        _command = command;
    }

    @Override
    public boolean canBeExecuted() {
        return true;
    }

    @Override
    public List<String> execute(Messages messages, Time executionTime) {
        return messages.of(user())
                .map(message -> message.shortText(executionTime))
                .collect(Collectors.toList());
    }

    private List<String> user() {
        return Collections.singletonList(_command);
    }
}
