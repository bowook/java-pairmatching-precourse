package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.History;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;
import pairmatching.domain.constant.Course;
import pairmatching.domain.constant.Level;
import pairmatching.domain.constant.Mission;
import pairmatching.exception.ErrorMessage;
import pairmatching.utils.FileLoader;

public class PairService {
    private final List<String> backendCrews;
    private final List<String> frontendCrews;
    private final Crews crews;
    private final History history;

    public PairService() {
        this.backendCrews = loadFile("backend-crew.md");
        this.frontendCrews = loadFile("frontend-crew.md");
        this.history = new History();
        this.crews = new Crews();
        initCrews();
    }

    public void initializePairs() {
        history.initialize();
    }

    private void initCrews() {
        for (String crew : backendCrews) {
            crews.addCrew(new Crew(crew));
        }
        for (String crew : frontendCrews) {
            crews.addCrew(new Crew(crew));
        }
    }

    public Pairs findConditionPairs(List<String> infos) {
        Course course = Course.from(infos.get(0));
        Level level = Level.from(infos.get(1));
        Mission mission = Mission.from(infos.get(2));
        return history.findPairs(course, level, mission);
    }

    public boolean matchingPair(List<String> infos) {
        Course course = Course.from(infos.get(0));
        Level level = Level.from(infos.get(1));
        Mission mission = Mission.from(infos.get(2));
        Pairs pairs = shuffle(course, level, mission);
        return history.addPairsToHistory(pairs);
    }

    public Pairs findPairs() {
        return history.findLastPairs();
    }

    private Pairs shuffle(Course course, Level level, Mission mission) {
        if (course.equals(Course.BACKEND)) {
            List<String> shuffledCrews = Randoms.shuffle(backendCrews);
            return matching(course, level, mission, shuffledCrews);

        }
        List<String> shuffledCrews = Randoms.shuffle(frontendCrews);
        return matching(course, level, mission, shuffledCrews);
    }

    private Pairs matching(Course course, Level level, Mission mission, List<String> shuffledCrews) {
        Pairs pairs = new Pairs(course, level, mission);
        List<Crew> crews = new ArrayList<>();
        String lastCrewName = shuffledCrews.get(shuffledCrews.size() - 1);
        for (String crew : shuffledCrews) {
            if (crews.size() >= 2 && !crew.equals(lastCrewName)) {
                pairs.addPair(new Pair(crews));
                crews = new ArrayList<>();
            }
            crews.add(this.crews.findCrew(crew));
        }
        pairs.addPair(new Pair(crews));
        return pairs;
    }

    private List<String> loadFile(String fileName) {
        try {
            return FileLoader.fileReadLine(fileName);
        } catch (IOException e) {
            throw new IllegalArgumentException(ErrorMessage.FILE_ERROR.getMessage());
        }
    }

}
