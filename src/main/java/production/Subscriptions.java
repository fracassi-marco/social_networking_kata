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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Subscriptions {

    private HashMap<String, List<String>> _subscriptions = new HashMap<>();

    public void add(String user, String subscription) {
        if(!hasSubscriptions(user)) {
            _subscriptions.put(user, new ArrayList<>());
        }
        _subscriptions.get(user).add(subscription);
    }

    public List<String> of(String user) {
        if(!hasSubscriptions(user)) {
            return new ArrayList<>();
        }
        return _subscriptions.get(user);
    }

    private boolean hasSubscriptions(String user) {
        return _subscriptions.containsKey(user);
    }
}
