package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Day9_0 extends Challenge {
    List<Long> numberList = new ArrayList<>();

    public Day9_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        super.getLines().forEach(s -> numberList.add(Long.parseLong(s)));

        for (int i = 25; i < numberList.size(); i++) {
            long number = numberList.get(i);
            boolean foundMatch = false;
            for (int j = 25; j > 0; j--) {
                long numberJ = numberList.get(i - j);
                for (int x = 25; x > j; x--) {
                    long numberX = numberList.get(i - x);
                    if (numberJ + numberX == number) foundMatch = true;
                }
            }
            if (!foundMatch) {
                AdventOfCode.LOGGER.log(Level.INFO, "{0}", number);
                break;
            }
        }
    }
}
