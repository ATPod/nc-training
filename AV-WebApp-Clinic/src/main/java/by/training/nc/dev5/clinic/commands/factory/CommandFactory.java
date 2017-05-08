package by.training.nc.dev5.clinic.commands.factory;


import by.training.nc.dev5.clinic.commands.ICommand;
import by.training.nc.dev5.clinic.commands.impl.user.LoginUserCommand;
import by.training.nc.dev5.clinic.constants.Parameters;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    private static CommandFactory instance;

    public static synchronized CommandFactory getInstance(){
        if(instance == null){
            instance = new CommandFactory();
        }
        return instance;
    }

    public ICommand defineCommand(HttpServletRequest request){
        ICommand current;
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
