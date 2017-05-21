package by.training.nc.dev5.command.commandimpl;

import by.training.nc.dev5.command.Command;
import by.training.nc.dev5.jpaservice.UserServiceJPA;
import by.training.nc.dev5.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 02.05.2017.
 */
public class UsersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        UserServiceJPA us = new UserServiceJPA();

        request.getSession().setAttribute("users",us.selectUsers());

        us.selectUsers().forEach(System.out::println);

        return ConstantsUtil.USERS_PAGE;
    }
}
