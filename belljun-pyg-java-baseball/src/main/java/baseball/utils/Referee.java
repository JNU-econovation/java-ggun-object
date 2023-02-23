package baseball.utils;


import baseball.model.Balls;
import baseball.model.GameResult;

public class Referee {
    public static GameResult compareBalls(Balls computerBalls, Balls balls) {
        return new GameResult(computerBalls.compareBallResults(balls));
    }
}
