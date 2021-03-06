package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

public class Day7_0 extends Challenge {

    private List<Bag> allBags = new ArrayList<>();

    public Day7_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        for (String line : getLines()) {
            String[] lineData = line.split(" bags contain ");

            if (lineData[1].equals("no other bags.")) continue;

            Bag bag = getBag(lineData[0]);

            String[] bagNames = lineData[1].replaceAll("(( ?)[0-9] | bag(s?)|\\.)", "").split(",");
            for (String bagName : bagNames) {
                bag.addNewBag(getBag(bagName));
            }
        }

        AdventOfCode.LOGGER.log(Level.INFO, "{0}", allBags.stream().filter(this::allowesGoldBag).count());
    }

    private boolean allowesGoldBag(Bag bag) {
        return bag.getCanContain().stream().anyMatch(bag1 -> bag1.getName().equals("shiny gold") || allowesGoldBag(bag1));
    }

    private Bag getBag(String name) {
        Optional<Bag> optionalBag = allBags.stream().filter(bag -> bag.getName().equals(name)).findFirst();
        if (optionalBag.isEmpty()) return new Bag(name);
        return optionalBag.get();
    }

    public class Bag {
        String name;
        List<Bag> canContain = new ArrayList<>();

        public Bag(String name) {
            this.name = name;
            allBags.add(this);
        }

        public String getName() {
            return name;
        }

        public List<Bag> getCanContain() {
            return canContain;
        }

        public void addNewBag(Bag bag) {
            this.canContain.add(bag);
        }
    }
}
