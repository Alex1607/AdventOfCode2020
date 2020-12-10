package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class Day10_0 extends Challenge {

    public Day10_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        List<Integer> lines = super.getLines().stream().map(Integer::parseInt).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        lines.add(0, 0);
        int one = 0, three = 0;
        for (int i = 0; i < lines.size() - 1; i++) {
            if(lines.get(i + 1) - lines.get(i) == 1) one++;
            if(lines.get(i + 1) - lines.get(i) == 3) three++;
        }
        AdventOfCode.LOGGER.log(Level.INFO, "{0}", one * three);
    }
}
