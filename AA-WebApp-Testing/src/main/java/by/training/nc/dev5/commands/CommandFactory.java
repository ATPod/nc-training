package by.training.nc.dev5.commands;

import by.training.nc.dev5.commands.user.*;
import by.training.nc.dev5.constants.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static by.training.nc.dev5.constants.Commands.*;

public class CommandFactory {
    private static Map<String, Command> commands = new HashMap<>();

    static {
        commands.put(GO_TO_LOGIN, new GoToLoginCommand());
        commands.put(GO_TO_REGISTRATION, new GoToRegistration());
        commands.put(GO_TO_STUDENT_REGISTRATION, new GoToStudentRegistrationForm());
        commands.put(GO_TO_TUTOR_REGISTRATION, new GoToTutorRegistrationForm());
        commands.put(REGISTER_STUDENT, new RegisterStudentCommand());
        commands.put(REGISTER_TUTOR, new RegisterTutorCommand());
        commands.put(LOGIN, new LoginUserCommand());
        commands.put(STUDENT_MENU, new RegisterStudentCommand());
        commands.put(TUTOR_MENU, new RegisterStudentCommand());
        commands.put(LOGOUT_USER, new LogoutUserCommand());

    }

    public static Command defineCommand(HttpServletRequest req) {
        Command resultCommand = null;
        String commandName = req.getParameter(Parameters.COMMAND);
        resultCommand = commands.get(commandName);
        return resultCommand;
    }


}