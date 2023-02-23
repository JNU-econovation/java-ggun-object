package baseball.model;

public class Ball {
    private int number;
    private int idx;

    public Ball(int number, int idx) {
        this.number = number;
        this.idx = idx;
    }

    public int getNumber() {
        return number;
    }

    public int getIdx() {
        return idx;
    }

    public boolean isSameNum(Ball ball) {
        return number == ball.getNumber();
    }

    public CompareBallResult isSameIdx(Ball ball) {
        if (idx == ball.getIdx()) {
            return CompareBallResult.STRIKE;
        }
        return CompareBallResult.BALL;
    }
}
