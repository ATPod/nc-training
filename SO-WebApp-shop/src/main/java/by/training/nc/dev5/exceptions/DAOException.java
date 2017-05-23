package by.training.nc.dev5.exceptions;

public class DaoException extends Exception {
    public DaoException() {}

    public DaoException(String msg) {
        super(msg);
    }

    public DaoException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
