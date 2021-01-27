package exceptions;

public class InvalidStepValueException extends RuntimeException {

    public InvalidStepValueException(String stepValue) {
        super("Value in feature file step is incorrect: " + stepValue);
    }
}
