package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class Day4_1 extends Challenge {

    private int validPassports = 0;
    StringBuilder fullData = new StringBuilder();

    public Day4_1(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        super.getStream().forEach(s -> fullData.append(s).append(System.lineSeparator()));

        Arrays.stream(fullData.toString().split(System.lineSeparator() + System.lineSeparator())).forEach(s -> {
            s = s.replace(System.lineSeparator(), " ");
            Map<String, String> passData = Arrays.stream(s.split(" ")).map(s1 -> s1.split(":")).collect(Collectors.toMap(strings -> strings[0], o -> o[1]));
            if (isValid(passData)) validPassports++;
        });

        AdventOfCode.LOGGER.log(Level.INFO, "{0}", validPassports);
    }

    public boolean isValid(Map<String, String> data) {
        if ((data.keySet().size() != 7 || data.containsKey("cid")) && data.keySet().size() != 8) return false;

        if (!data.get("byr").matches("^(200[0-2]|19[2-9][0-9])$")) return false;
        if (!data.get("iyr").matches("^(2020|201[0-9])$")) return false;
        if (!data.get("eyr").matches("^(2030|202[0-9])$")) return false;
        if (!data.get("hgt").matches("^((1([5-8][0-9]|9[0-3])cm)|((59|6[0-9]|7[0-6])in))$")) return false;
        if (!data.get("hcl").matches("^(#[0-9a-f]{6})$")) return false;
        if (!data.get("ecl").matches("^(amb|blu|brn|gry|grn|hzl|oth)$")) return false;
        if (!data.get("pid").matches("^[0-9]{9}$")) return false;

        return true;
    }
}