package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2_1 extends Challenge {

    private int matches = 0;
    private Pattern pattern = Pattern.compile("(\\d+)-(\\d+) ([a-z]): ([a-z]+)");

    public Day2_1(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        super.getLines().forEach(line -> {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                int pos1 = Integer.parseInt(matcher.group(1));
                int pos2 = Integer.parseInt(matcher.group(2));
                String cha = matcher.group(3);
                String password = matcher.group(4);

                if (password.split("")[pos1 - 1].equals(cha) ^ password.split("")[pos2 - 1].equals(cha)) matches++;
            }
        });

        AdventOfCode.LOGGER.log(Level.INFO, String.valueOf(matches));
    }
}
