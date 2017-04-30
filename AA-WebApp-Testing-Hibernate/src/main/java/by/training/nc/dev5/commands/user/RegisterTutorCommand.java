package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.services.TutorService;

import javax.servlet.http.HttpServletRequest;

public class RegisterTutorCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        TutorService tutorService=TutorService.getInstance();
        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String subject=request.getParameter("subject");
        Tutor tutor = new Tutor();
        tutor.setName(name);
        tutor.setSurname(surname);
        tutor.setLogin(login);
        tutor.setPassword(password);
        tutor.setSubject(subject);
        tutorService.addEntity(tutor);
        return JspPaths.LOGIN_PAGE_PATH;
    }
}
