package pw.reinert.adventofcode.days;

import pw.reinert.adventofcode.Challenge;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2_0 extends Challenge {

    private int matches = 0;
    private Pattern pattern = Pattern.compile("(\\d+)-(\\d+) ([a-z]): ([a-z]+)");

    public Day2_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        super.getLines().forEach(line -> {
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                int min = Integer.parseInt(matcher.group(1));
                int max = Integer.parseInt(matcher.group(2));
                String cha = matcher.group(3);
                String password = matcher.group(4);

                long occ = Arrays.stream(password.split("")).filter(s -> s.equals(cha)).count();

                if(min <= occ && occ <= max) matches++;
            }
        });

        System.out.println(matches);
    }
}
