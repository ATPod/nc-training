package by.training.nc.shop.exceptions;

public class NotFoundException extends Exception {

    public NotFoundException() {}

    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
