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
import production.CurrentTime;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrentTimeTest {

    @Test
    public void shouldGiveMilliseconds() {
        Calendar calendar = new GregorianCalendar();

        CurrentTime currentTime = new CurrentTime(calendar);

        assertThat(currentTime.millis()).isEqualTo(calendar.getTimeInMillis());
    }
}
