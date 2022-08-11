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

import production.Time;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeAgo {

    private static final Calendar _now = new GregorianCalendar();

    public static Time seconds(int amount) {
        return milliseconds(1000 * amount);
    }

    public static Time now() {
        return milliseconds(0);
    }

    private static Time milliseconds(int amount) {
        return new TimeTestDouble(_now, amount);
    }

    public static Time minutes(int amount) {
        return seconds(60 * amount);
    }
}
