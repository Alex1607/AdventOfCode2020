package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class Day6_1 extends Challenge {

    private int sum = 0;
    private StringBuilder fullData = new StringBuilder();

    public Day6_1(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        super.getLines().forEach(s -> fullData.append(s).append(System.lineSeparator()));

        Arrays.stream(fullData.toString().split(System.lineSeparator() + System.lineSeparator())).forEach(s -> {
            String[] data = s.split(System.lineSeparator());
            List<String> checkedChars = new ArrayList<>();
            for (String d : data) {
                for(String dsplit : d.split("")) {
                    if(checkedChars.contains(dsplit)) continue;
                    checkedChars.add(dsplit);
                    if(s.chars().filter(ch -> ch == dsplit.charAt(0)).count() == data.length) sum++;
                }
            }
        });

        AdventOfCode.LOGGER.log(Level.INFO, "{0}", sum);
    }
}
