package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.Arrays;
import java.util.logging.Level;

public class Day6_0 extends Challenge {

    private int sum = 0;
    private StringBuilder fullData = new StringBuilder();

    public Day6_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        super.getLines().forEach(s -> fullData.append(s).append(System.lineSeparator()));

        Arrays.stream(fullData.toString().split(System.lineSeparator() + System.lineSeparator())).forEach(s -> sum += s.replace(System.lineSeparator(), "").chars().distinct().count());

        AdventOfCode.LOGGER.log(Level.INFO, "{0}", sum);
    }
}
