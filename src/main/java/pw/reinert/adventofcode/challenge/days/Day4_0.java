package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class Day4_0 extends Challenge {

    private int validPassports = 0;
    StringBuilder fullData = new StringBuilder();

    public Day4_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        super.getStream().forEach(s -> fullData.append(s).append(System.lineSeparator()));

        Arrays.stream(fullData.toString().split(System.lineSeparator() + System.lineSeparator())).forEach(s -> {
            s = s.replace(System.lineSeparator(), " ");
            Map<String, String> passData = Arrays.stream(s.split(" ")).map(s1 -> s1.split(":")).collect(Collectors.toMap(strings -> strings[0], o -> o[1]));
            if(isValid(passData)) validPassports++;
        });

        AdventOfCode.LOGGER.log(Level.INFO, "{0}", validPassports);
    }

    public boolean isValid(Map<String, String> data) {
        if (data.keySet().size() == 7 && !data.containsKey("cid")) return true;
        if (data.keySet().size() == 8) return true;

        return false;
    }
}