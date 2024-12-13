package pairmatching.view;

import pairmatching.domain.Pairs;
import pairmatching.domain.constant.Course;
import pairmatching.domain.constant.Mission;

public class OutputView {
    private final static String DIVIDE_LINE = "#############################################";
    private final static String PAIR_MATCHING_RESULT = "페어 매칭 결과입니다.";
    private final static String INITIALIZE = "초기화 되었습니다.";

    public void writeInitialize() {
        System.out.println(INITIALIZE);
    }

    public void writeMatchingResult(Pairs pairs) {
        System.out.println(PAIR_MATCHING_RESULT);
        System.out.println(pairs.toString());
    }

    public void writeErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void writeInfo() {
        System.out.println(DIVIDE_LINE);
        System.out.println(Course.info());
        System.out.println(Mission.info());
        System.out.println(DIVIDE_LINE);
    }
}
