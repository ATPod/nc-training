package by.training.nc.dev5.web.command;

import by.training.nc.dev5.web.command.customer.*;
import by.training.nc.dev5.web.command.manager.AssignDevelopersCommand;
import by.training.nc.dev5.web.command.manager.CreateProjectCommand;
import by.training.nc.dev5.web.command.manager.ShowDevelopersCommand;

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
        commands.put("logout", new LogoutCommand());
        commands.put("go", new GoCommand());

        commands.put("goShowTerms", new GoShowTermsCommand());
        commands.put("goCreateTerms", new GoCreateTermsCommand());
        commands.put("addTask", new AddTaskCommand());
        commands.put("createTerms", new CreateTermsCommand());
        commands.put("removeTask", new RemoveTaskCommand());
        commands.put("cancelTerms", new CancelTermsCommand());

        commands.put("createProject", new CreateProjectCommand());
        commands.put("showDevelopers", new ShowDevelopersCommand());
        commands.put("assignDevelopers", new AssignDevelopersCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");

        if (commands.containsKey(action)) {
            return commands.get(action);
        }

        return new EmptyCommand();
    }
}
