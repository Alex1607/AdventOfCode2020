package pw.reinert.adventofcode.challenge;

import java.util.ArrayList;
import java.util.List;

public class ChallengeManager {

    private List<Challenge> challengeList;

    public ChallengeManager() {
        this.challengeList = new ArrayList<>();
    }

    public void addChallenge(Challenge challenge) {
        this.challengeList.add(challenge);
    }

    public void runChallenge(String id) {
        this.challengeList.stream().filter(challenge -> challenge.getId().equals(id)).forEach(Challenge::run);
    }
}
