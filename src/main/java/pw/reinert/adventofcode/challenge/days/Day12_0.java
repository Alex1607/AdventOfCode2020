package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.logging.Level;

public class Day12_0 extends Challenge {

    //TODO: Still wip
    int x = 0, y = 0;
    int facing = 0;

    /*               270 (3)
                        ^
                        | + y
                        |
        180 (2) <-------+-------> 0 (0)
                 - x    |       + x
                        | - y
                        v
                      90 (1)
     */

    public Day12_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        super.getLines().forEach(s -> {
            String instruction = s.substring(0, 1);
            int amount = Integer.parseInt(s.substring(1));
            if (instruction.equals("F")) {
                goForward(facingDirection(), amount);
            } else if (instruction.equals("N") || instruction.equals("S") || instruction.equals("E") || instruction.equals("W")) {
                goForward(instruction, amount);
            } else if (instruction.equals("R") || instruction.equals("L")) {
                changeDirection(instruction, amount);
            }
        });
        AdventOfCode.LOGGER.log(Level.INFO, "{0}", Math.abs(x) + Math.abs(y));
    }

    private void changeDirection(String rotation, int amount) {
        amount = amount / 90;
        if (rotation.equals("R")) {
            facing = (amount + facing) % 4;
        } else {
            facing = Math.abs(amount - facing) % 4;
        }
    }

    private String facingDirection() {
        return switch (facing) {
            case 0 -> "E";
            case 1 -> "S";
            case 2 -> "W";
            case 3 -> "N";
            default -> null;
        };
    }

    private void goForward(String direction, int amount) {
        switch (direction) {
            case "N":
                y += amount;
                break;
            case "S":
                y -= amount;
                break;
            case "W":
                x -= amount;
                break;
            case "E":
                x += amount;
                break;
        }
    }
}
