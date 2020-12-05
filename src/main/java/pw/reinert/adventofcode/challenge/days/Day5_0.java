package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.logging.Level;

public class Day5_0 extends Challenge {

    private int highestNumber = 0;

    public Day5_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        super.getLines().forEach(s -> {
            int row = binarySearch(s.substring(0, 7), 127);
            int col = binarySearch(s.substring(7, 10), 7);
            int seatID = row * 8 + col;
            if (seatID > highestNumber) highestNumber = seatID;
        });

        AdventOfCode.LOGGER.log(Level.INFO, "{0}", highestNumber);
    }

    private int binarySearch(String data, int maxRange) {
        int minRange = 0;
        for (String s : data.split("")) {
            int diff = maxRange - minRange;
            if (s.equals("F") || s.equals("L")) maxRange -= Math.ceil(diff / 2.0);
            if (s.equals("B") || s.equals("R")) minRange += diff / 2;
        }
        return maxRange;
    }
}
