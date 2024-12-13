package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Crews {
    private final List<Crew> crews = new ArrayList<>();

    public void addCrew(Crew crew) {
        this.crews.add(crew);
    }

    public Crew findCrew(String crewName) {
        for (Crew crew : crews) {
            if (crew.getName().equals(crewName)) {
                return crew;
            }
        }
        return null;
    }
}
