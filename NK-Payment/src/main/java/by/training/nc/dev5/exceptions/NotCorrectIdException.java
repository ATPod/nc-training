package by.training.nc.dev5.exceptions;

/**
 * Created by AsusPC on 26.03.17.
 */
public class NotCorrectIdException extends Exception {
    public NotCorrectIdException (){

    }
    public NotCorrectIdException (String message){
        super(message);
    }
    public NotCorrectIdException(String message, Throwable cause){
        super(message,cause);
    }
    public NotCorrectIdException (Throwable cause){
        super(cause);
    }
}
