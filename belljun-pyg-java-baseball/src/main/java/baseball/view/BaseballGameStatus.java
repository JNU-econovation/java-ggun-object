package baseball.view;

public enum BaseballGameStatus {
    END(true), AGAIN(false);

    private final boolean end;

    BaseballGameStatus(boolean end) {
        this.end = end;
    }

    public boolean isEnd() {
        return end;
    }

    public static BaseballGameStatus choiceOf(String validatedInputEndNum) {
        if (validatedInputEndNum.equals("1")) {
            return AGAIN;
        }
        return END;
    }
}
