package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

public class Day4_1 extends Challenge {
    public Day4_1(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        Passport passport = new Passport();
        List<Passport> passportList = new ArrayList<>();
        int validPassports = 0;
        passportList.add(passport);

        for (String line : super.getLines()) {

            if (line.isBlank()) {
                passport = new Passport();
                passportList.add(passport);
                continue;
            }

            String[] lineData = line.split(" ");

            for (String lineD : lineData) {
                String[] data = lineD.split(":");
                passport.addPassportData(data[0], data[1]);
            }
        }

        for (Passport pass : passportList) {
            if (pass.isValid()) validPassports++;
        }

        AdventOfCode.LOGGER.log(Level.INFO, "{0}", validPassports);
    }

    private class Passport {
        private HashMap<String, String> passportData = new HashMap<>();

        public void addPassportData(String key, String value) {
            this.passportData.put(key, value);
        }

        public boolean isValid() {
            if ((passportData.keySet().size() != 7 || passportData.containsKey("cid")) && passportData.keySet().size() != 8) return false;

            if (!passportData.get("byr").matches("^(200[0-2]|19[2-9][0-9])$")) return false;
            if (!passportData.get("iyr").matches("^(2020|201[0-9])$")) return false;
            if (!passportData.get("eyr").matches("^(2030|202[0-9])$")) return false;
            if (!passportData.get("hgt").matches("^((1([5-8][0-9]|9[0-3])cm)|((59|6[0-9]|7[0-6])in))$")) return false;
            if (!passportData.get("hcl").matches("^(#[0-9a-f]{6})$")) return false;
            if (!passportData.get("ecl").matches("^(amb|blu|brn|gry|grn|hzl|oth)$")) return false;
            if (!passportData.get("pid").matches("^[0-9]{9}$")) return false;

            return true;
        }
    }
}