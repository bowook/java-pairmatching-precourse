package pairmatching.domain;

import java.util.List;
import java.util.StringJoiner;

public class Pair {
    private final List<Crew> onePair;

    public Pair(final List<Crew> onePair) {
        this.onePair = onePair;
    }

    public List<Crew> getOnePair() {
        return onePair;
    }

    public boolean checkDuplicatePair(Pair pair) {
        List<Crew> newPair = pair.getOnePair();
        int count = 0;
        for (Crew crew : newPair) {
            if (onePair.contains(crew)) {
                count += 1;
            }
        }
        return count >= 2;
    }

    public void initialize() {
        onePair.clear();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringJoiner stringJoiner = new StringJoiner(" : ");
        for (Crew crew : onePair) {
            stringJoiner.add(crew.getName());
        }
        stringBuilder.append(stringJoiner).append(System.lineSeparator());
        return stringBuilder.toString();
    }
}
