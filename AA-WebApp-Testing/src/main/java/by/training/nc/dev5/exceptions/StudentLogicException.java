package by.training.nc.dev5.exceptions;

public class StudentLogicException extends Exception {
    public StudentLogicException() {
    }

    public StudentLogicException(String message) {
        super(message);
    }

    public StudentLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentLogicException(Throwable cause) {
        super(cause);
    }
}
