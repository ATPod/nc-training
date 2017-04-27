package by.training.nc.dev5.web.command;

import by.training.nc.dev5.web.command.customer.*;
import by.training.nc.dev5.web.command.manager.ShowPendingTorsCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikita on 18.04.2017.
 */
public class CommandFactory {
    private static final Map<String, Command> commands;

    static {
        commands = new HashMap<String, Command>();

        commands.put("login", new LoginCommand());
        commands.put("goLogin", new GoLoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("goHome", new GoHomeCommand());

        commands.put("addTask", new AddTaskCommand());
        commands.put("createTor", new CreateTorCommand());
        commands.put("goCreateTor", new GoCreateTorCommand());
        commands.put("removeTask", new RemoveTaskCommand());
        commands.put("showMyTors", new ShowMyTorsCommand());

        commands.put("showPendingTors", new ShowPendingTorsCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");

        if (commands.containsKey(action)) {
            return commands.get(action);
        }

        return new EmptyCommand();
    }
}
