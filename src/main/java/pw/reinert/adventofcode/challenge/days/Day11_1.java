package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class Day11_1 extends Challenge {

    String[][] seats;
    Integer[][] directions = {{-1, -1}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}, {1, 1}, {1, 0}, {0, 1}};

    public Day11_1(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        seats = super.getLines().stream().map(s -> s.split("")).toArray(String[][]::new);


        /*
                          X:Y

                        Y (Row)
               #---------------------->
               | [-1:-1] [-1:0] [-1:1]
      X (Col)  | [0:-1]  [0:0]  [0:1]
               | [1:-1]  [1:0]  [1:1]
               V
         */

        AdventOfCode.LOGGER.log(Level.INFO, "{0}", getSeats());
    }

    private int getSeats() {
        boolean changes = false;
        String[][] tempSeats = deepCopy(seats);
        for (int x = 0; x < seats.length; x++) {
            String[] seatRow = seats[x];
            for (int y = 0; y < seatRow.length; y++) {
                String seat = seatRow[y];
                if (seat.equals(".")) continue;
                int occupiedSeats = 0;

                for (Integer[] direction : directions) {
                    Integer[] position = deepCopy(direction);
                    while ((position[0] + x) >= 0
                            && (position[0] + x) < tempSeats.length
                            && (position[1] + y) >= 0
                            && (position[1] + y) < seatRow.length) {
                        if (seats[position[0] + x][position[1] + y].equals("#")) {
                            occupiedSeats++;
                            break;
                        }
                        if (seats[position[0] + x][position[1] + y].equals("L")) break;
                        position[0] += direction[0];
                        position[1] += direction[1];
                    }
                }

                if (occupiedSeats == 0 && seats[x][y].equals("L")) {
                    tempSeats[x][y] = "#";
                    changes = true;
                } else if (occupiedSeats >= 5 && seats[x][y].equals("#")) {
                    tempSeats[x][y] = "L";
                    changes = true;
                }
            }
        }
        seats = tempSeats;
        if(!changes) return (int) Arrays.stream(Arrays.stream(seats).flatMap(Arrays::stream).toArray()).filter(o -> o.equals("#")).count();
        return getSeats();
    }

    <T> T[][] deepCopy(T[][] matrix) {
        return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
    }
    <T> T[] deepCopy(T[] matrix) {
        return java.util.Arrays.stream(matrix).toArray($ -> matrix.clone());
    }
}
