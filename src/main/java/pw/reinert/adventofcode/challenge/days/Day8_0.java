package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Day8_0 extends Challenge {
    int accumulator = 0;
    List<Integer> ranInstructions = new ArrayList<>();

    public Day8_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        for (int i = 0; i < super.getLines().size(); i++) {

            if(ranInstructions.contains(i)) {
                break;
            }

            ranInstructions.add(i);

            String s = super.getLines().get(i);
            String instruction = s.substring(0, 3);
            int number = Integer.parseInt(s.substring(4));
            switch (instruction) {
                case "nop":
                    break;
                case "acc":
                    accumulator += number;
                    break;
                case "jmp":
                    i += (number - 1);
                    break;
            }
        }

        AdventOfCode.LOGGER.log(Level.INFO, "{0}", accumulator);
    }
}
