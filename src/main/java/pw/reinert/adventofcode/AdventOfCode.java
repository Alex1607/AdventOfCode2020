package pw.reinert.adventofcode;

import pw.reinert.adventofcode.challenge.ChallengeManager;
import pw.reinert.adventofcode.challenge.days.*;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdventOfCode {

    public static final Logger LOGGER = Logger.getLogger(AdventOfCode.class.getName());

    public static void main(String[] args) {
        LOGGER.setLevel(Level.INFO);

        ClassLoader cl = AdventOfCode.class.getClassLoader();

        ChallengeManager challengeManager = new ChallengeManager();
        challengeManager.addChallenge(new Day1_0("1.0", new File(cl.getResource("./data/1_0.txt").getFile())));
        challengeManager.addChallenge(new Day1_1("1.1", new File(cl.getResource("./data/1_0.txt").getFile())));
        challengeManager.addChallenge(new Day2_0("2.0", new File(cl.getResource("./data/2_0.txt").getFile())));
        challengeManager.addChallenge(new Day2_1("2.1", new File(cl.getResource("./data/2_0.txt").getFile())));
        challengeManager.addChallenge(new Day3_0("3.0", new File(cl.getResource("./data/3_0.txt").getFile())));
        challengeManager.addChallenge(new Day3_1("3.1", new File(cl.getResource("./data/3_0.txt").getFile())));
        challengeManager.addChallenge(new Day4_0("4.0", new File(cl.getResource("./data/4_0.txt").getFile())));
        challengeManager.addChallenge(new Day4_1("4.1", new File(cl.getResource("./data/4_0.txt").getFile())));
        challengeManager.addChallenge(new Day5_0("5.0", new File(cl.getResource("./data/5_0.txt").getFile())));
        challengeManager.addChallenge(new Day5_1("5.1", new File(cl.getResource("./data/5_0.txt").getFile())));
        challengeManager.addChallenge(new Day6_0("6.0", new File(cl.getResource("./data/6_0.txt").getFile())));
        challengeManager.addChallenge(new Day6_1("6.1", new File(cl.getResource("./data/6_0.txt").getFile())));
        challengeManager.addChallenge(new Day7_0("7.0", new File(cl.getResource("./data/7_0.txt").getFile())));
        challengeManager.addChallenge(new Day7_1("7.1", new File(cl.getResource("./data/7_0.txt").getFile())));
        challengeManager.addChallenge(new Day8_0("8.0", new File(cl.getResource("./data/8_0.txt").getFile())));
        challengeManager.addChallenge(new Day8_1("8.1", new File(cl.getResource("./data/8_0.txt").getFile())));
        challengeManager.addChallenge(new Day9_0("9.0", new File(cl.getResource("./data/9_0.txt").getFile())));
        challengeManager.addChallenge(new Day9_1("9.1", new File(cl.getResource("./data/9_0.txt").getFile())));
        challengeManager.addChallenge(new Day10_0("10.0", new File(cl.getResource("./data/10_0.txt").getFile())));
        challengeManager.addChallenge(new Day10_1("10.1", new File(cl.getResource("./data/10_0.txt").getFile())));
        challengeManager.addChallenge(new Day11_0("11.0", new File(cl.getResource("./data/11_0.txt").getFile())));
        challengeManager.addChallenge(new Day11_1("11.1", new File(cl.getResource("./data/11_0.txt").getFile())));
        challengeManager.addChallenge(new Day12_0("12.0", new File(cl.getResource("./data/12_0.txt").getFile())));
//        challengeManager.addChallenge(new Day12_1("12.1", new File(cl.getResource("./data/12_0.txt").getFile())));

        if(args.length != 1) {
            LOGGER.log(Level.SEVERE, "Keine ID wurde als Argument mitgegeben.");
            System.exit(0);
        }

        challengeManager.runChallenge(args[0]);
    }
}
