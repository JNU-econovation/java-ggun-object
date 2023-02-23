package baseball.view;

import baseball.view.utils.line.Line;

public class Speaker {
    public void speak(Line line) {
        System.out.println(line.value());
    }
}
