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

public class Message {
    private final String _user;
    private final String _content;
    private final Time _executionTime;

    public Message(String user, String content, Time executionTime) {
        _user = user;
        _content = content;
        _executionTime = executionTime;
    }

    public boolean isPostedByOneOfThisUsers(List<String> users) {
        return users.contains(_user);
    }

    public String shortText(Time readTime) {
        return _content + " " + new DeltaTime(readTime, _executionTime).text();
    }

    public String fullText(Time readTime) {
        return _user + " - " + shortText(readTime);
    }
}
