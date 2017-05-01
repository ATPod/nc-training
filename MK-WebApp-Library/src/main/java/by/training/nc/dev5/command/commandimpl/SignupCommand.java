package by.training.nc.dev5.command.commandimpl;

import by.training.nc.dev5.command.Command;
import by.training.nc.dev5.entity.jpa.User;
import by.training.nc.dev5.jpaservice.UserServiceJPA;
import by.training.nc.dev5.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 01.05.2017.
 */
public class SignupCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        UserServiceJPA us = new UserServiceJPA();


        String name = request.getParameter("user-name");
        String password = request.getParameter("user-password");
        String role = request.getParameter("user-role");

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setRole(role);
        us.insertUser(user);


        return ConstantsUtil.LOGIN_PAGE;
    }
}
