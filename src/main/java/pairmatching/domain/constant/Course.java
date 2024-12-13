package pairmatching.domain.constant;

import java.util.Arrays;
import pairmatching.exception.CustomException;
import pairmatching.exception.ErrorMessage;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");
    private final String name;

    Course(final String name) {
        this.name = name;
    }

    public static Course from(String input) {
        return Arrays.stream(Course.values())
                .filter(course -> course.name.equals(input.trim()))
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.INPUT_COURSE_ERROR));
    }

    public String getName() {
        return name;
    }

    public static String info() {
        return "과정: " + Course.BACKEND.getName() + " | " + Course.FRONTEND.getName();
    }
}
