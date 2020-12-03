package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.logging.Level;

public class Day3_1 extends Challenge {

    private String[][] map;

    public Day3_1(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        map = new String[super.getLines().size()][super.getLines().get(0).split("").length];
        for (int i = 0; i < super.getLines().size(); i++) {
            map[i] = super.getLines().get(i).split("");
        }

        Slope Slope = new Slope(1, 1);
        Slope Slope1 = new Slope(1, 3);
        Slope Slope2 = new Slope(1, 5);
        Slope Slope3 = new Slope(1, 7);
        Slope Slope4 = new Slope(2, 1);

        AdventOfCode.LOGGER.log(Level.INFO, "{0}", (Slope.checkHits() * Slope1.checkHits() * Slope2.checkHits() * Slope3.checkHits() * Slope4.checkHits()));
    }

    private class Slope {
        private int x;
        private int z;
        private long hits;

        public Slope(int z, int x) {
            this.x = x;
            this.z = z;
        }

        public long checkHits() {
            for (int i = 0; i < map.length; i += this.z) {
                int rightX = (((i / this.z) * this.x) % map[i].length);
                if (map[i][rightX].equals("#")) this.hits++;
            }
            return this.hits;
        }
    }
}