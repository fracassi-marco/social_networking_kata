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

public class TimeTestDouble implements Time {

    private final Calendar _calendar;
    private final long _millisecondsAgo;

    public TimeTestDouble(Calendar calendar, int millisecondsAgo) {
        _millisecondsAgo = millisecondsAgo;
        _calendar = calendar;
    }

    @Override
    public long millis() {
        return _calendar.getTimeInMillis() - _millisecondsAgo;
    }
}
