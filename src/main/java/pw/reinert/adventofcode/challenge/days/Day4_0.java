package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class Day4_0 extends Challenge {
    public Day4_0(String id, File data) {
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

        for(Passport pass : passportList) {
            if(pass.isValid()) validPassports++;
        }

        AdventOfCode.LOGGER.log(Level.INFO, "{0}", validPassports);
    }

    private class Passport {
        private final HashMap<String, String> passportData = new HashMap<>();

        public void addPassportData(String key, String value) {
            this.passportData.put(key, value);
        }

        public boolean isValid() {
            if(passportData.keySet().size() == 7 && !passportData.containsKey("cid")) return true;
            if(passportData.keySet().size() == 8) return true;

            return false;
        }
    }
}