package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.beans.users.User;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUserCommand extends AbstractCommand {
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserService userService = UserService.getInstance();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (userService.checkUserAuthorization(login, password)) {
            User user = userService.getAuthorizedUser(login, password);
            session.setAttribute("user", user);
            if (user instanceof Student) {
                session.setAttribute("type", 1);
                return JspPaths.STUDENT_MENU;
            } else {
                if (user instanceof Tutor) {
                    session.setAttribute("type", 2);
                    return JspPaths.TUTOR_MENU;
                }
            }
        }
        request.setAttribute("error_message", "Пользователь с данным логином и паролем отсутствует!");
        return JspPaths.LOGIN_PAGE_PATH;
    }
}
