package by.training.nc.dev5.command;

import by.training.nc.dev5.command.client.AddToBagCommand;
import by.training.nc.dev5.command.client.GoToBagCommand;
import by.training.nc.dev5.command.client.MakeOrderingCommand;
import by.training.nc.dev5.command.user.GoToRegistrationCommand;
import by.training.nc.dev5.command.user.LoginCommand;
import by.training.nc.dev5.command.user.LogoutCommand;
import by.training.nc.dev5.command.user.RegisterCommand;

public enum CommandEnum {
    LOGIN { {this.command = new LoginCommand();} },
    LOGOUT { {this.command = new LogoutCommand();} },
    GO_TO_REGISTRATION { {this.command = new GoToRegistrationCommand();} },
    REGISTER { {this.command = new RegisterCommand();} },
    ADDTOBAG { {this.command = new AddToBagCommand();} },
    GOTOBAG { {this.command = new GoToBagCommand();} },
    MAKEORDERING { {this.command = new MakeOrderingCommand();} };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {return command;}
}