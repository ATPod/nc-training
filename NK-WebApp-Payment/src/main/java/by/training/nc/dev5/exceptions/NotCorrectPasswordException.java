package by.training.nc.dev5.exceptions;

/**
 * Created by AsusPC on 26.03.17.
 */
public class NotCorrectPasswordException extends Exception{
    public NotCorrectPasswordException (){

    }
    public NotCorrectPasswordException (String message){
        super(message);
    }
    public NotCorrectPasswordException(String message, Throwable cause){
        super(message,cause);
    }
    public NotCorrectPasswordException (Throwable cause){
        super(cause);
    }
}
