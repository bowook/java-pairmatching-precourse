package pairmatching.exception;

public enum ErrorMessage {

    INPUT_FUNC_ERROR("1,2,3,Q 중 하나의 기능을 입력하세요."),
    INPUT_COURSE_ERROR("해당되는 과정이 없습니다."),
    INPUT_LEVEL_ERROR("해당되는 레벨이 없습니다."),
    INPUT_MISSION_ERROR("해당되는 미션이 없습니다."),
    NO_MATCHING_ERROR("매칭 이력이 없습니다."),
    CANT_START_MATCHING("매칭을 진행할 수 없습니다."),
    FILE_ERROR("파일이 존재하지 않습니다."),
    YES_OR_NO("네 또는 아니오로 대답하셔야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}