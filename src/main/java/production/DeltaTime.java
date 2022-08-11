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

import java.util.stream.Stream;

public class DeltaTime {
    private final Time _end;
    private final Time _start;

    public DeltaTime(Time end, Time start) {
        _end = end;
        _start = start;
    }

    public String text() {
        long delta = _end.millis() - _start.millis();

        return Stream.of(
                new TimeText(minutes(delta), "minute"),
                new TimeText(seconds(delta), "second"))
                .filter(TimeText::isNotZero)
                .findFirst()
                .orElse(new TimeText(0, "second"))
                .text();
    }

    private int minutes(long delta) {
        return seconds(delta) / 60;
    }

    private int seconds(long delta) {
        return (int) (delta / 1000);
    }
}
