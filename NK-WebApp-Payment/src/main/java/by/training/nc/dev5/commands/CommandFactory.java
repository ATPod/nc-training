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
        commands.put(REGISTER_CLIENT,  new RegisterClientCommand());
        commands.put(LOGIN, new LoginUserCommand());
        commands.put(CLIENT_MENU,  new RegisterClientCommand());
        commands.put(LOGOUT_USER, new LogoutUserCommand());

    }

    public static Command defineCommand(HttpServletRequest req) {
        Command resultCommand = null;
        String commandName = req.getParameter(Parameters.COMMAND);
        resultCommand = commands.get(commandName);
        return resultCommand;
    }


}
