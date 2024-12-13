package pairmatching.controller;

import java.util.List;
import pairmatching.domain.constant.Answer;
import pairmatching.domain.constant.Command;
import pairmatching.exception.CustomException;
import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PairService pairService;

    public PairController(final InputView inputView, final OutputView outputView, final PairService pairService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairService = pairService;
    }

    public void start() {
        while (true) {
            Command command = readCommand();
            if (command.equals(Command.QUIT)) {
                break;
            }
            sendCase(command);
        }
    }

    private void sendCase(Command command) {
        if (command.equals(Command.PAIR_MATCHING)) {
            commandOne();
        }
        if (command.equals(Command.PAIR_SELECT)) {
            commandTwo();
        }
        if (command.equals(Command.PAIR_INIT)) {
            pairService.initializePairs();
            outputView.writeInitialize();
        }
    }

    private void commandTwo() {
        outputView.writeInfo();
        List<String> infos = readInfos();
        outputView.writeMatchingResult(pairService.findConditionPairs(infos));
    }

    private void commandOne() {
        outputView.writeInfo();
        List<String> infos = readInfos();
        boolean flagHistory = pairService.matchingPair(infos);
        retry(infos, flagHistory);
    }

    private void retry(List<String> infos, boolean flagHistory) {
        while (!flagHistory) {
            if (retryMatching().equals(Answer.YES)) {
                flagHistory = pairService.matchingPair(infos);
                continue;
            }
            infos = readInfos();
            flagHistory = pairService.matchingPair(infos);
        }
        outputView.writeMatchingResult(pairService.findPairs());
    }

    private Answer retryMatching() {
        while (true) {
            try {
                return inputView.readAnswer();
            } catch (CustomException customException) {
                outputView.writeErrorMessage(customException.getMessage());
            }
        }
    }

    private List<String> readInfos() {
        while (true) {
            try {
                return inputView.readInfo();
            } catch (CustomException customException) {
                outputView.writeErrorMessage(customException.getMessage());
            }
        }
    }

    private Command readCommand() {
        while (true) {
            try {
                return inputView.readCommand();
            } catch (CustomException customException) {
                outputView.writeErrorMessage(customException.getMessage());
            }
        }
    }
}
