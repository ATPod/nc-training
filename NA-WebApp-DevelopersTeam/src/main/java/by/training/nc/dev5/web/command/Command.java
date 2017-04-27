package by.training.nc.dev5.web.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nikita on 18.04.2017.
 */
public interface Command {
    String execute(HttpServletRequest request);
}
