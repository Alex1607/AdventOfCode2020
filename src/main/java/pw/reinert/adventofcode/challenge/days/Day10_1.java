package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class Day10_1 extends Challenge {

    List<Integer> lines;
    Map<Integer, Long> counter = new HashMap<>();

    public Day10_1(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        lines = super.getLines().stream().map(Integer::parseInt).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        lines.add(0, 0);
        AdventOfCode.LOGGER.log(Level.INFO, "{0}", checkBrance(0));
    }

    private long checkBrance(int i) {
        if (i == (lines.size() - 1)) return 1;
        if (counter.containsKey(i)) return counter.get(i);
        long ans = 0;
        for (int j = i + 1; j < lines.size(); j++) {
            if (lines.get(j) - lines.get(i) > 3) break;
            ans += checkBrance(j);
        }
        counter.put(i, ans);
        return ans;
    }
}
