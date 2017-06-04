package by.training.nc.dev5.commands;

import javax.servlet.http.HttpServletRequest;
public interface Command {
    String execute(HttpServletRequest request);
}
