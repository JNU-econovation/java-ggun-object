package baseball.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Balls {

    private List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public Map<CompareBallResult, Long> compareBallResults(Balls compareBalls) {
        Map<CompareBallResult, Long> result = new HashMap<>();
        for (Ball b : balls) {
            CompareBallResult compareBallResult = compareBalls.calcResult(b);
            result.merge(compareBallResult, 1L, Long::sum);
        }
        return result;
    }

    private CompareBallResult calcResult(Ball ball) {
        Optional<CompareBallResult> compareBallResult = balls.stream()
            .filter(b -> b.isSameNum(ball))
            .findFirst()
            .map(b -> b.isSameIdx(ball));

        if (compareBallResult.isEmpty()) {
            return CompareBallResult.MISS;
        }
        return compareBallResult.get();
    }

}
