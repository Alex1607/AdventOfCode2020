package pw.reinert.adventofcode.days;

import pw.reinert.adventofcode.Challenge;

import java.io.File;

public class Day1_1 extends Challenge {
    public Day1_1(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        for (int x = 0; x < getLines().size(); x++) {
            int valueX = Integer.parseInt(getLines().get(x));
            for (int y = x; y < getLines().size(); y++) {
                int valueY = Integer.parseInt(getLines().get(y));
                for (int z = y; z < getLines().size(); z++) {
                    int valueZ = Integer.parseInt(getLines().get(z));

                    if (valueX + valueY + valueZ == 2020) System.out.println(valueX * valueY * valueZ);
                }
            }
        }
    }
}
