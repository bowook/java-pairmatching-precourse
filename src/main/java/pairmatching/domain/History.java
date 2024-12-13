package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.constant.Course;
import pairmatching.domain.constant.Level;
import pairmatching.domain.constant.Mission;

public class History {
    private final List<Pairs> history = new ArrayList<>();

    public Pairs findLastPairs() {
        return history.get(history.size() - 1);
    }

    public boolean addPairsToHistory(Pairs pairs) {
        if (checkDuplicateCourse(pairs)) {
            history.add(pairs);
            return true;
        }
        return false;
    }

    private boolean checkDuplicateCourse(Pairs pairs) {
        for (Pairs historyPairs : history) {
            if (historyPairs.getCourse().equals(pairs.getCourse()) && checkDuplicateLevel(historyPairs, pairs)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDuplicateLevel(Pairs historyPairs, Pairs pairs) {
        if (historyPairs.getLevel().equals(pairs.getLevel())) {
            return checkDuplicateMission(historyPairs, pairs);
        }
        return false;
    }

    private boolean checkDuplicateMission(Pairs historyPairs, Pairs pairs) {
        if (historyPairs.getMission().equals(pairs.getMission())) {
            return historyPairs.checkDuplicatePairs(pairs);
        }
        return false;
    }

    public Pairs findPairs(Course course, Level level, Mission mission) {
        List<Pairs> resultPairs = new ArrayList<>();
        for (Pairs pairs : history) {
            if (pairs.getCourse().equals(course) && pairs.getLevel().equals(level) && pairs.getMission()
                    .equals(mission)) {
                resultPairs.add(pairs);
            }
        }
        return resultPairs.get(resultPairs.size() - 1);
    }

    public void initialize() {
        for (Pairs pairs : history) {
            pairs.initialize();
        }
    }
}
