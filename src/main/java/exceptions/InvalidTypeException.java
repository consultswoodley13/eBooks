package exceptions;

public class InvalidTypeException extends RuntimeException {

    public InvalidTypeException(String typeValue) {
        super("The type provided is an invalid type for this method: " + typeValue);
    }

}
