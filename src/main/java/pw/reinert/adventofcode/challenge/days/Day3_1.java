package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;

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

        Sloap sloap = new Sloap(1, 1);
        Sloap sloap1 = new Sloap(1, 3);
        Sloap sloap2 = new Sloap(1, 5);
        Sloap sloap3 = new Sloap(1, 7);
        Sloap sloap4 = new Sloap(2, 1);

        System.out.println(sloap.checkHits() * sloap1.checkHits() * sloap2.checkHits() * sloap3.checkHits() * sloap4.checkHits());
    }

    private class Sloap {
        private int x;
        private int z;
        private long hits;

        public Sloap(int z, int x) {
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