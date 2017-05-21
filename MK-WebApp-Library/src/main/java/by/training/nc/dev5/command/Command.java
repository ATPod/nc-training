package by.training.nc.dev5.command;
import javax.servlet.http.HttpServletRequest;


public interface Command {

    String execute(HttpServletRequest request);
}
