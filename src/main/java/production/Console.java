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

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.GregorianCalendar;

public class Console {

    private final SocialNetworking _socialNetworking;

    public Console() {
        _socialNetworking = new SocialNetworking();
    }

    public void run(Reader input, PrintStream output) {
        try {
            BufferedReader bufferedReader = new BufferedReader(input);

            printShell(output);
            String command;
            while ((command = bufferedReader.readLine()) != null) {
                printResult(output, execute(command));
                printShell(output);
            }
            input.close();
            bufferedReader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void printResult(PrintStream output, String result) {
        if(!result.isEmpty()) {
            output.println(result);
        }
    }

    private void printShell(PrintStream output) {
        output.print("> ");
    }

    private String execute(String command) {
        return _socialNetworking.execute(command, new CurrentTime(new GregorianCalendar()));
    }
}
