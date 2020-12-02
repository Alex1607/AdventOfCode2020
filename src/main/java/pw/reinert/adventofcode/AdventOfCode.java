package pw.reinert.adventofcode;

import pw.reinert.adventofcode.days.Day1_0;
import pw.reinert.adventofcode.days.Day1_1;
import pw.reinert.adventofcode.days.Day2_0;
import pw.reinert.adventofcode.days.Day2_1;

import java.io.File;

public class AdventOfCode {

    private static ChallengeManager challengeManager;

    public static void main(String[] args) {
        ClassLoader cl = AdventOfCode.class.getClassLoader();

        challengeManager = new ChallengeManager();
        challengeManager.addChallenge(new Day1_0("1.0", new File(cl.getResource("./data/1_0.txt").getFile())));
        challengeManager.addChallenge(new Day1_1("1.1", new File(cl.getResource("./data/1_0.txt").getFile())));
        challengeManager.addChallenge(new Day2_0("2.0", new File(cl.getResource("./data/2_0.txt").getFile())));
        challengeManager.addChallenge(new Day2_1("2.1", new File(cl.getResource("./data/2_0.txt").getFile())));

        if(args.length != 1) {
            System.out.println("Keine ID wurde als Argument mitgegeben.");
            System.exit(0);
        }

        challengeManager.runChallenge(args[0]);
    }
}
