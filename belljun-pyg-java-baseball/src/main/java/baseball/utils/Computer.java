package baseball.utils;

import baseball.model.Balls;

public class Computer {
    public static Balls getBalls() {
        return BallGenerator.randomBalls();
    }
}
