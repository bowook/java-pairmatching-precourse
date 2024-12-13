package pairmatching.domain.constant;

import java.util.Arrays;
import pairmatching.exception.CustomException;
import pairmatching.exception.ErrorMessage;

public enum Command {
    PAIR_MATCHING("1"),
    PAIR_SELECT("2"),
    PAIR_INIT("3"),
    QUIT("Q");

    private final String name;

    Command(final String name) {
        this.name = name;
    }

    public static Command from(final String input) {
        return Arrays.stream(Command.values())
                .filter(command -> command.name.equals(input))
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.INPUT_FUNC_ERROR));
    }
}
