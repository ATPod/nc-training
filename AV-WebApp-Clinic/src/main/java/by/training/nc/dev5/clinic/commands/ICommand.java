package by.training.nc.dev5.clinic.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 04.04.2017.
 */
public interface ICommand {
    String execute(HttpServletRequest request);
}
