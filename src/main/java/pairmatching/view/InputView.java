package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.domain.constant.Answer;
import pairmatching.domain.constant.Command;
import pairmatching.utils.Parser;

public class InputView {
    private final static String CHOOSE_COMMAND = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";
    private final static String COURSE_LEVEL_MISSION = "과정, 레벨, 미션을 선택하세요.\nex) 백엔드, 레벨1, 자동차경주";
    private final static String RETRY_MATCHING = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";

    public Answer readAnswer() {
        System.out.println(RETRY_MATCHING);
        return Answer.from(readConsole());
    }

    public List<String> readInfo() {
        System.out.println(COURSE_LEVEL_MISSION);
        return Parser.nameToInfo(readConsole());
    }

    public Command readCommand() {
        System.out.println(CHOOSE_COMMAND);
        return Command.from(readConsole());
    }

    private String readConsole() {
        return Console.readLine();
    }
}
