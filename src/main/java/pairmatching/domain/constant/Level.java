package pairmatching.domain.constant;

import java.util.Arrays;
import pairmatching.exception.CustomException;
import pairmatching.exception.ErrorMessage;

public enum Level {
    ONE("레벨1"),
    TWO("레벨2"),
    THREE("레벨3"),
    FOUR("레벨4"),
    FIVE("레벨5");

    private final String name;

    Level(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Level from(String input) {
        return Arrays.stream(Level.values())
                .filter(level -> level.name.equals(input.trim()))
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.INPUT_LEVEL_ERROR));
    }
}
