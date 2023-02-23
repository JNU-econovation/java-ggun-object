package baseball.model;

import java.util.Map;
import java.util.Optional;

public class GameResult {
    private Map<CompareBallResult, Long>  compareBallResultList;
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public GameResult(Map<CompareBallResult, Long> compareBallResultList) {
        this.compareBallResultList = compareBallResultList;
    }

    public String getGameResult(){
        Optional<Long> strikeCount = Optional.ofNullable(compareBallResultList.get(CompareBallResult.STRIKE));
        Optional<Long> ballCount = Optional.ofNullable(compareBallResultList.get(CompareBallResult.BALL));
        Optional<Long> missCount = Optional.ofNullable(compareBallResultList.get(CompareBallResult.MISS));

        if (missCount.isPresent()) {
            Long miss = missCount.get();
            if (miss.equals(3L)) {
                return NOTHING;
            }
        }

        if (strikeCount.isEmpty()) {
            return compareBallResultList.get(CompareBallResult.BALL) + BALL;
        }

        if (ballCount.isEmpty()) {
            return compareBallResultList.get(CompareBallResult.STRIKE) + STRIKE;
        }

        Long strike = strikeCount.get();
        Long ball = ballCount.get();

        return ball + BALL + " " + strike + STRIKE;
    }

    public boolean isStrikeOut() {
        Optional<Long> strikeCnt = Optional.ofNullable(compareBallResultList.get(CompareBallResult.STRIKE));
        if(strikeCnt.isEmpty()){
            return false;
        }

        if(strikeCnt.get().equals(3L)){
            return true;
        }
        return false;
    }
}
