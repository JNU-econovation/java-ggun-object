package baseball.view.utils.input;

@FunctionalInterface
public interface InputPolicy {
    void validateInput(String target);
}
