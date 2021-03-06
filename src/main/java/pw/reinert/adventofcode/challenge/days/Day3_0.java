package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.logging.Level;

public class Day3_0 extends Challenge {

    private int hits = 0;

    public Day3_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        String[][] map = new String[super.getLines().size()][super.getLines().get(0).split("").length];
        for(int i = 0; i < super.getLines().size(); i++) {
            map[i] = super.getLines().get(i).split("");

            int z = ((i * 3) % map[i].length);

            if(map[i][z].equals("#")) hits++;
        }

        AdventOfCode.LOGGER.log(Level.INFO, "{0}", hits);
    }
}


