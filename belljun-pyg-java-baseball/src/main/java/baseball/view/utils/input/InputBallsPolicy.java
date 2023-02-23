package baseball.view.utils.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputBallsPolicy implements InputPolicy{

    private static final String WARM_NOT_THREE_INPUT = "3개의 숫자를 입력해주세요!";
    private static final String WARM_NOT_NUMBER_FORMAT = "숫자를 입력해주세요!";
    private static final String WARM_NOT_ALLOW_DUPLICATE_NUMBERS = "중복된 숫자를 입력하였습니다!";
    private static final Integer BALL_SIZE = 3;

    @Override
    public void validateInput(String target) {
        validateInputLength(target);
        List<Integer> inputBallsNums = validateInputFormat(target);
        validateDuplicate(inputBallsNums);
    }

    private void validateInputLength(String target) {
        if (target.length() != BALL_SIZE) {
            throw new IllegalArgumentException(WARM_NOT_THREE_INPUT);
        }
    }

    private List<Integer> validateInputFormat(String target) {
        String[] split = target.split("");
        try {
            return Arrays.stream(split).map(Integer::valueOf).collect(Collectors.toList());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(WARM_NOT_NUMBER_FORMAT);
        }
    }

    private void validateDuplicate(List<Integer> inputBallsNums) {
        List<Integer> notDuplicatedNums = extractNotDuplicatedNums(inputBallsNums);
        isSameSize(inputBallsNums, notDuplicatedNums);
    }

    private List<Integer> extractNotDuplicatedNums(List<Integer> inputBallsNums) {
        List<Integer> notDuplicatedNums = new ArrayList<>();
        for (Integer ball : inputBallsNums) {
            if (!notDuplicatedNums.contains(ball)) {
                notDuplicatedNums.add(ball);
            }
        }
        return notDuplicatedNums;
    }

    private void isSameSize(List<Integer> inputBallsNums, List<Integer> notDuplicatedNums) {
        if (notDuplicatedNums.size() != inputBallsNums.size()) {
            throw new IllegalArgumentException(WARM_NOT_ALLOW_DUPLICATE_NUMBERS);
        }
    }
}
