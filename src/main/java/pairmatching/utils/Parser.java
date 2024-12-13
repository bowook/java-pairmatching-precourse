package pairmatching.utils;

import java.util.Arrays;
import java.util.List;
import pairmatching.domain.constant.Course;
import pairmatching.domain.constant.Level;
import pairmatching.domain.constant.Mission;

public class Parser {
    private final static String COMMA = ",";

    public static List<String> nameToInfo(String infos) {
        List<String> info = Arrays.asList(infos.split(COMMA));
        Course course = Course.from(info.get(0));
        Level level = Level.from(info.get(1));
        Mission mission = Mission.from(info.get(2));

        return info;
    }
}
