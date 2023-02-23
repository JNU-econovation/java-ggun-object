package baseball.view;

import baseball.view.utils.input.InputBallsPolicy;
import baseball.view.utils.input.InputEndPolicy;
import baseball.view.utils.input.InputPolicy;

public class Validator {
    private static InputPolicy inputPolicy = new InputBallsPolicy();
    private static InputPolicy inputEndPolicy = new InputEndPolicy();
    private InputValidator inputValidator;


    private Validator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }
    public Validator(){
        this(new InputValidator());
    }


    public String validateInputBallsNums(String ballsNums) {
        return inputValidator.validateInput(ballsNums, inputPolicy);
    }

    public String validateInputEndNum(String endNum) {
        return inputValidator.validateInput(endNum, inputEndPolicy);
    }
}
