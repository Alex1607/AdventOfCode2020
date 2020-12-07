package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.AdventOfCode;
import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

public class Day7_1 extends Challenge {

    private List<Bag> allBags = new ArrayList<>();

    public Day7_1(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        for (String line : getLines()) {
            String[] lineData = line.split(" bags contain ");

            if (lineData[1].equals("no other bags.")) continue;

            Bag bag = getBag(lineData[0]);

            String[] bagNames = lineData[1].replaceAll("( bag(s?)|\\.)", "").split(", ");
            for (String bagName : bagNames) {

                int bagAmount = Integer.parseInt(bagName.substring(0, 1));
                Bag bag1 = getBag(bagName.substring(2));

                for (int i = 0; i < bagAmount; i++) {
                    bag.addNewBag(bag1);
                }
            }
        }

        AdventOfCode.LOGGER.log(Level.INFO, "{0}", bagsInside(getBag("shiny gold"), 0));
    }

    private long bagsInside(Bag bag, long amount) {
        amount += bag.getCanContain().size();
        for (Bag bag1 : bag.getCanContain()) amount = bagsInside(bag1, amount);
        return amount;
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
