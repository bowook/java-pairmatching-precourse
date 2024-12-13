package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.constant.Course;
import pairmatching.domain.constant.Level;
import pairmatching.domain.constant.Mission;

public class Pairs {
    private final Course course;
    private final Level level;
    private final Mission mission;
    private final List<Pair> pairs;

    public Pairs(final Course course, final Level level, final Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.pairs = new ArrayList<>();
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    public void addPair(Pair pair) {
        this.pairs.add(pair);
    }

    public boolean checkDuplicatePairs(Pairs pairs) {
        for (Pair historyPair : this.pairs) {
            if (checkDuplicateCrew(historyPair, pairs)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDuplicateCrew(Pair historyPair, Pairs pairs) {
        for (Pair pair : pairs.getPairs()) {
            if (historyPair.checkDuplicatePair(pair)) {
                return true;
            }
        }
        return false;
    }

    public void initialize() {
        for (Pair pair : pairs) {
            pair.initialize();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pair pair : pairs) {
            stringBuilder.append(pair.toString());
        }
        return stringBuilder.toString();
    }
}
