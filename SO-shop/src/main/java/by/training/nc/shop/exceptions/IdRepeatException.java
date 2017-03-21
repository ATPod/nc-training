package by.training.nc.shop.exceptions;

public class IdRepeatException extends Exception{

    public IdRepeatException() {}

    public IdRepeatException(String msg) {
        super(msg);
    }

    public IdRepeatException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
