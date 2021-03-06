package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class Day4_0 extends Challenge {

    private static final List<String> validKeys = Arrays.asList("hcl", "iyr", "hgt", "pid", "byr", "eyr", "ecl");
    private int validPassports = 0;
    StringBuilder fullData = new StringBuilder();

    public Day4_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        super.getLines().forEach(s -> fullData.append(s).append(System.lineSeparator()));

        Arrays.stream(fullData.toString().split(System.lineSeparator() + System.lineSeparator())).forEach(s -> {
            s = s.replace(System.lineSeparator(), " ");
            Map<String, String> passData = Arrays.stream(s.split(" ")).map(s1 -> s1.split(":")).collect(Collectors.toMap(strings -> strings[0], o -> o[1]));
            if(isValid(passData)) validPassports++;
        });

        AdventOfCode.LOGGER.log(Level.INFO, "{0}", validPassports);
    }

    public boolean isValid(Map<String, String> data) {
        return data.keySet().containsAll(validKeys);
    }
}