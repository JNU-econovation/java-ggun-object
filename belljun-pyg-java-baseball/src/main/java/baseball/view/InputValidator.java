package baseball.view;

import baseball.view.utils.input.InputPolicy;

public class InputValidator {
    public String validateInput(String target, InputPolicy inputPolicy) {
        inputPolicy.validateInput(target);
        return target;
    }
}
