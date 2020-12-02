package pw.reinert.adventofcode.days;

import pw.reinert.adventofcode.Challenge;

import java.io.File;

public class Day1_0 extends Challenge {

    public Day1_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        for(int x = 0; x < getLines().size(); x++) {
            int valueX = Integer.parseInt(getLines().get(x));
            for(int y = x; y < getLines().size(); y++) {
                int valueY = Integer.parseInt(getLines().get(y));

                if(valueX + valueY == 2020) System.out.println(valueX * valueY);
            }
        }
    }
}
