package baseball.view;

import baseball.model.Ball;
import baseball.model.Balls;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static Balls toBalls(List<Integer> inputNum) {
        List<Ball> makeBalls = new ArrayList<>();
        for (int i = 0; i < inputNum.size(); i++) {
            makeBalls.add(new Ball(inputNum.get(i), i));
        }
        return new Balls(makeBalls);
    }
}
