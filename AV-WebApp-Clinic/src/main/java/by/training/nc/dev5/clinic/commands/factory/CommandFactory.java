package by.training.nc.dev5.clinic.commands.factory;


import by.training.nc.dev5.clinic.commands.Command;
import by.training.nc.dev5.clinic.commands.user.LoginUserCommand;
import by.training.nc.dev5.clinic.constants.Parameters;

import javax.servlet.http.HttpServletRequest;

public enum CommandFactory {
    INSTANCE;

    public Command defineCommand(HttpServletRequest request){
        Command current = null;
        String commandName = request.getParameter(Parameters.COMMAND);
        try{
            CommandType type = CommandType.valueOf(commandName.toUpperCase());
            current = type.getCurrentCommand();
        }
        catch(NullPointerException e){
            current = new LoginUserCommand();
        }
        catch(IllegalArgumentException e){
            current = new LoginUserCommand();
        }
        return current;
    }
}
