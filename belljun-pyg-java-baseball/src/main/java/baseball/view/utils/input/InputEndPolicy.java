package baseball.view.utils.input;


import java.util.List;

public class InputEndPolicy implements InputPolicy {
    private static final String WARM_NOT_SINGLE_INPUT = "1개의 숫자를 입력해주세요!";
    private static final String WARM_NOT_NUMBER_FORMAT = "숫자를 입력해주세요!";
    private static final String WARM_NOT_IN_CHOICES = "선택 보기에 있는 숫자를 입력해주세요";
    private static final Integer INPUT_SIZE = 1;

    private static final List<Integer> choices = List.of(1, 2);

    @Override
    public void validateInput(String target) {
        validateInputLength(target);
        Integer inputEndNum = validateInputFormat(target);
        isInChoices(inputEndNum);
    }

    private void isInChoices(Integer inputEndNum) {
        if (!choices.contains(inputEndNum)) {
            throw new IllegalArgumentException(WARM_NOT_IN_CHOICES);
        }
    }

    private void validateInputLength(String target) {
        if (target.length() != INPUT_SIZE) {
            throw new IllegalArgumentException(WARM_NOT_SINGLE_INPUT);
        }
    }

    private Integer validateInputFormat(String target) {
        try {
            return Integer.valueOf(target);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(WARM_NOT_NUMBER_FORMAT);
        }
    }
}
