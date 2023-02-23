package baseball.view;


import baseball.view.utils.line.Lines;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameConsole {
    private Speaker speaker;
    private Validator validator;

    private BaseballGameConsole(Speaker speaker, Validator validator) {
        this.speaker = speaker;
        this.validator = validator;
    }
    public BaseballGameConsole(){
        this(new Speaker(), new Validator());
    }

    public void start(){
        speaker.speak(Lines.START_LINE);
    }

    public List<Integer> inputBallsNums() {
        speaker.speak(Lines.PROGRESS_LINE);
        String validatedInputBallsNums = validator.validateInputBallsNums(Console.readLine());
        return Arrays.stream(validatedInputBallsNums.split(""))
            .map(Integer::valueOf)
            .collect(Collectors.toList());
    }

    public void result(String result){
        speaker.speak(Lines.RESULT_LINE(result));
    }

    public BaseballGameStatus inputEndNum(){
        speaker.speak(Lines.END_LINE);
        String validatedInputEndNum = validator.validateInputEndNum(Console.readLine());
        return BaseballGameStatus.choiceOf(validatedInputEndNum);
    }
}
