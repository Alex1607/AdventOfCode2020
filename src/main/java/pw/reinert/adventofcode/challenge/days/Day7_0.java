package pw.reinert.adventofcode.challenge.days;

import pw.reinert.adventofcode.challenge.Challenge;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Day7_0 extends Challenge {

    private List<Bag> allBags = new ArrayList<>();

    public Day7_0(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        for (String line : getLines()) {
            String[] lineData = line.split(" bags contain ");
            Bag bag;
            if (getBag(lineData[0]) == null) {
                bag = new Bag(lineData[0]);
                allBags.add(bag);
            } else {
                bag = getBag(lineData[0]);
            }

            if(lineData[1].equals("no other bags.")) {
                continue;
            }

            String[] bagNames = lineData[1].replaceAll("(( ?)[0-9] | bag(s?)|\\.)", "").split(",");
            for (String bagName : bagNames) {
                Bag b = getBag(bagName);
                if (b == null) {
                    b = new Bag(bagName);
                    allBags.add(b);
                }

                bag.addNewBag(b);
            }
        }

        System.out.println(allBags.stream().filter(this::allowesGoldBag).count());
    }

    private boolean allowesGoldBag(Bag bag) {
        for (Bag bag1 : bag.getCanContain()) {
            if (bag1.getName().equals("shiny gold") || allowesGoldBag(bag1)) return true;
        }
        return false;
    }

    private Bag getBag(String name) {
        Optional<Bag> optionalBag = allBags.stream().filter(bag -> bag.getName().equals(name)).findFirst();
        return optionalBag.orElse(null);
    }

    public class Bag {
        String name;
        List<Bag> canContain = new ArrayList<>();

        public Bag(String name) {
            this.name = name;
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
