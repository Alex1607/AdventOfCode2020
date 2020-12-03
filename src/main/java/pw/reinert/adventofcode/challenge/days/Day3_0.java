package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;

public class Day3_0 extends Challenge {

    private int hits = 0;
    private String[][] map;

    public Day3_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        map = new String[super.getLines().size()][super.getLines().get(0).split("").length];
        for(int i = 0; i < super.getLines().size(); i++) {
            map[i] = super.getLines().get(i).split("");

            int z = ((i * 3) % map[i].length);

            if(map[i][z].equals("#")) hits++;
        }

        System.out.println(hits);
    }
}


