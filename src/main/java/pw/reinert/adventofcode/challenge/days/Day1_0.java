package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.logging.Level;

public class Day1_0 extends Challenge {

    public Day1_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        for (int x = 0; x < getLines().size(); x++) {
            int valueX = Integer.parseInt(getLines().get(x));
            for (int y = x; y < getLines().size(); y++) {
                int valueY = Integer.parseInt(getLines().get(y));

                if (valueX + valueY == 2020) AdventOfCode.LOGGER.log(Level.INFO, "{0}", (valueX * valueY));
            }
        }
    }
}
