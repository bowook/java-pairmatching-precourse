package pairmatching.domain.constant;

import java.util.Arrays;
import pairmatching.exception.CustomException;
import pairmatching.exception.ErrorMessage;

public enum Mission {
    RACING_CAR(Level.ONE, "자동차경주"),
    LOTTO(Level.ONE, "로또"),
    NUMBER_BASEBALL(Level.ONE, "숫자야구게임"),
    SHOP_BASKET(Level.TWO, "장바구니"),
    PAYMENT(Level.TWO, "결제"),
    SUBWAY_MAP(Level.TWO, "지하철노선도"),
    PERFORMANCE_UPGRADE(Level.FOUR, "성능개선"),
    DISTRIBUTION(Level.FOUR, "배포");

    private final Level level;
    private final String name;

    Mission(final Level level, final String name) {
        this.level = level;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }

    public static Mission from(String input) {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.name.equals(input.trim()))
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.INPUT_MISSION_ERROR));
    }

    public static String info() {
        return "미션:" + System.lineSeparator()
                + "  - " + Level.ONE.getName() + ": " + Mission.RACING_CAR.getName() + " | " + Mission.LOTTO.getName()
                + " | " + NUMBER_BASEBALL.getName() + System.lineSeparator()
                + "  - " + Level.TWO.getName() + ": " + Mission.SHOP_BASKET.getName() + " | "
                + Mission.PAYMENT.getName() + " | " + Mission.SUBWAY_MAP.getName() + System.lineSeparator()
                + "  - " + Level.THREE.getName() + System.lineSeparator()
                + "  - " + Level.FOUR.getName() + ": " + Mission.PERFORMANCE_UPGRADE.getName() + " | "
                + Mission.DISTRIBUTION.getName() + System.lineSeparator()
                + "  - " + Level.FIVE.getName();
    }
}
