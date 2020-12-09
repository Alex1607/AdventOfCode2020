package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Day9_1 extends Challenge {
    List<Long> numberList = new ArrayList<>();

    public Day9_1(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        super.getLines().forEach(s -> numberList.add(Long.parseLong(s)));

        long number = getInvalidNumber();

        for (int i = 0; i < numberList.size(); i++) {
            for (int j = i; j < numberList.size(); j++) {
                List<Long> subList = numberList.subList(i, j);
                if(subList.size() <= 1) continue;
                long sum = subList.stream().mapToLong(Long::longValue).sum();
                if(sum > number) break;
                if(sum == number) AdventOfCode.LOGGER.log(Level.INFO, "{0}", subList.stream().mapToLong(Long::longValue).min().getAsLong() + subList.stream().mapToLong(Long::longValue).max().getAsLong());
            }    
        }
    }

    private long getInvalidNumber() {
        for (int i = 25; i < numberList.size(); i++) {
            long number = numberList.get(i);
            boolean foundMatch = false;
            for (int j = 25; j > 0; j--) {
                long numberJ = numberList.get(i - j);
                for (int x = 25; x > j; x--) {
                    long numberX = numberList.get(i - x);
                    if (numberJ + numberX == number) {
                        foundMatch = true;
                        break;
                    }
                }
            }
            if (!foundMatch) {
                return number;
            }
        }
        return 0;
    }
}
