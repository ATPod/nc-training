package by.training.nc.dev5.exception;

/**
 * Created by ASUS on 31.05.2017.
 */
public class DbException extends Exception {
    public DbException() {
        super();
    }

    public DbException(String message) {
        super(message);
    }

    public DbException(String message, Throwable cause) {
        super(message, cause);
    }


}