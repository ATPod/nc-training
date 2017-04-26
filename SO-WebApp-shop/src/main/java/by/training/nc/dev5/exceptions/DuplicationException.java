package by.training.nc.dev5.exceptions;

public class DuplicationException extends Exception {

    public DuplicationException() {}

    public DuplicationException(String msg) {
        super(msg);
    }

    public DuplicationException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
