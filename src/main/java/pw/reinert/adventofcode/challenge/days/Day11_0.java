package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class Day11_0 extends Challenge {

    String[][] seats;

    public Day11_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        seats = super.getLines().stream().map(s -> s.split("")).toArray(String[][]::new);

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
                for (int dx = (x > 0 ? -1 : 0); dx <= (x < seats.length - 1 ? 1 : 0); ++dx) {
                    for (int dy = (y > 0 ? -1 : 0); dy <= (y < seatRow.length - 1 ? 1 : 0); ++dy) {
                        if (dx == 0 && dy == 0) {
                            continue;
                        }
                        if (seats[x + dx][y + dy].equals("#")) {
                            occupiedSeats++;
                        }
                    }
                }

                if (occupiedSeats == 0 && seats[x][y].equals("L")) {
                    tempSeats[x][y] = "#";
                    changes = true;
                } else if (occupiedSeats >= 4 && seats[x][y].equals("#")) {
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
}
