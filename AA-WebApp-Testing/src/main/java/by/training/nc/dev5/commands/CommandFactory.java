package by.training.nc.dev5.commands;

import by.training.nc.dev5.commands.user.*;
import by.training.nc.dev5.constants.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("GoToLogin", new GoToLoginCommand());
        commands.put("GoToRegistration", new GoToRegistration());
        commands.put("GoToStudentRegistration", new GoToStudentRegistrationForm());
        commands.put("GoToTutorRegistration", new GoToTutorRegistrationForm());
        commands.put("RegisterStudent", new RegisterStudentCommand());
        commands.put("RegisterTutor", new RegisterTutorCommand());
        commands.put("Login", new LoginUserCommand());
        commands.put("StudentMenu", new RegisterStudentCommand());
        commands.put("TutorMenu", new RegisterStudentCommand());
        commands.put("LogoutUser", new LogoutUserCommand());

    }

    public static Command defineCommand(HttpServletRequest req) {
        Command resultCommand = null;
        String commandName = req.getParameter(Parameters.COMMAND);
        resultCommand = commands.get(commandName);
        return resultCommand;
    }


}