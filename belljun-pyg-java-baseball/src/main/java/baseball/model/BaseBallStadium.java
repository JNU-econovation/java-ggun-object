package baseball.model;

import baseball.utils.Referee;

public class BaseBallStadium {

    public GameResult play(Balls computerBalls,Balls balls) {
        return Referee.compareBalls(computerBalls, balls);
    }
}
