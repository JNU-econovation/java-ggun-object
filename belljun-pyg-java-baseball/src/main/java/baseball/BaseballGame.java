package baseball;

import baseball.model.Balls;
import baseball.model.BaseBallStadium;
import baseball.model.GameResult;
import baseball.utils.Computer;
import baseball.view.BaseballGameConsole;
import baseball.view.BaseballGameStatus;
import baseball.view.Converter;

import java.util.List;

public class BaseballGame {

    private BaseBallStadium baseBallStadium;
    private BaseballGameConsole baseballGameConsole;
    private BaseballGameStatus baseballGameStatus;

    private BaseballGame(BaseBallStadium baseBallStadium, BaseballGameConsole baseballGameConsole, BaseballGameStatus baseballGameStatus) {
        this.baseBallStadium = baseBallStadium;
        this.baseballGameConsole = baseballGameConsole;
        this.baseballGameStatus = baseballGameStatus;
    }

    public BaseballGame(){
        this(new BaseBallStadium(), new BaseballGameConsole(), BaseballGameStatus.AGAIN);
    }

    public void start() {
        introduce();
        gameStart();
    }

    private void gameStart() {
        while (!baseballGameStatus.isEnd()) {
            Balls computerBalls = Computer.getBalls();
            gamePlay(computerBalls);
        }
    }

    private void gamePlay(Balls computerBalls) {
        boolean isEnd = false;
        while (!isEnd) {
            GameResult play = play(computerBalls);
            isEnd = isResult(play);
        }
    }

    private boolean isResult(GameResult play) {
        boolean isStrikeThree = result(play);
        if (isStrikeThree) {
            BaseballGameStatus end = end();
            baseballGameStatus = end;
        }
        return isStrikeThree;
    }

    public void introduce() {
        baseballGameConsole.start();
    }

    public BaseballGameStatus end() {
        return baseballGameConsole.inputEndNum();
    }

    public GameResult play(Balls computerBalls) {
        List<Integer> inputBallsNums = baseballGameConsole.inputBallsNums();
        return baseBallStadium.play(computerBalls,Converter.toBalls(inputBallsNums));
    }

    public boolean result(GameResult gameResult) {
        String result = gameResult.getGameResult();
        baseballGameConsole.result(result);
        return gameResult.isStrikeOut();
    }

}
