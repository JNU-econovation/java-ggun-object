package baseball.view.utils.line;

public class Lines {
    private static final String THREE_STRIKE = "3스트라이크";

    private static final String THREE_STRIKE_PLUS_LINE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";


    public static final Line START_LINE = () -> "숫자 야구 게임을 시작합니다.";

    public static final Line PROGRESS_LINE = () -> "숫자를 입력해 주세요 : ";

    public static final Line END_LINE = () -> "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    public static Line RESULT_LINE(String result) {
        if (result.equals(THREE_STRIKE)) {
            return () -> THREE_STRIKE + "\n" + THREE_STRIKE_PLUS_LINE;
        }
        return () -> result;
    }
}
