package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Day8_1 extends Challenge {

    public Day8_1(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {

        for (int i = 0; i < super.getLines().size(); i++) {
            String line = super.getLines().get(i);
            List<String> lines = super.getLines();
            String instruction = line.substring(0, 3);
            String number = line.substring(4);

            if (instruction.equals("nop") || instruction.equals("jmp")) {
                instruction = instruction.equals("nop") ? "jmp" : "nop";
                lines.set(i, instruction + " " + number);

                int num = acc(lines);
                if(num == Integer.MIN_VALUE) continue;
                AdventOfCode.LOGGER.log(Level.INFO, "{0}", num);
            }
        }

    }

    private int acc(List<String> lines) {
        int accumulator = 0;
        List<Integer> ranInstructions = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {

            if (ranInstructions.contains(i)) {
                return Integer.MIN_VALUE;
            }

            ranInstructions.add(i);

            String s = lines.get(i);
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
        return accumulator;
    }
}
