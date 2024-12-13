package pairmatching.domain.constant;

import java.util.Arrays;
import pairmatching.exception.CustomException;
import pairmatching.exception.ErrorMessage;

public enum Answer {
    YES("네"),
    NO("아니오");
    private final String name;

    Answer(final String name) {
        this.name = name;
    }

    public static Answer from(String input) {
        return Arrays.stream(Answer.values())
                .filter(answer -> answer.name.equals(input))
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.YES_OR_NO));
    }
}
