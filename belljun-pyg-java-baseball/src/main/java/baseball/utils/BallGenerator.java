package baseball.utils;

import baseball.model.Ball;
import baseball.model.Balls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BallGenerator {
    private static final Integer BALL_SIZE = 3;

    public static Balls randomBalls(){
        List<Integer> randomNumbers = generateRandomNumbers();

        List<Ball> ballList = new ArrayList<>();
        for (int i = 0; i < randomNumbers.size(); i++) {
            ballList.add(new Ball(randomNumbers.get(i), i));
        }

        return new Balls(ballList);
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < BALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
