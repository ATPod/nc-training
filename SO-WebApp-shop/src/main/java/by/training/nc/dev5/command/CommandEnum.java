package by.training.nc.dev5.command;

import by.training.nc.dev5.command.administrator.*;
import by.training.nc.dev5.command.administrator.goTo.*;
import by.training.nc.dev5.command.client.*;
import by.training.nc.dev5.command.client.UpdatePasswordCommand;
import by.training.nc.dev5.command.client.goTo.*;
import by.training.nc.dev5.command.common.GoToRegistrationCommand;
import by.training.nc.dev5.command.common.LoginCommand;
import by.training.nc.dev5.command.common.LogoutCommand;
import by.training.nc.dev5.command.common.RegisterCommand;

public enum CommandEnum {

    //common commands
    LOGIN { {this.command = new LoginCommand();} },
    LOGOUT { {this.command = new LogoutCommand();} },
    GO_TO_REGISTRATION { {this.command = new GoToRegistrationCommand();} },
    REGISTER { {this.command = new RegisterCommand();} },

    //client commands
    CLIENT_ADD_TO_BAG { {this.command = new AddToBagCommand();} },
    CLIENT_REMOVE_FROM_BAG { {this.command = new RemoveFromBagCommand();} },
    CLIENT_GO_TO_BAG { {this.command = new GoToBagCommand();} },
    CLIENT_GO_TO_SETTINGS { {this.command = new by.training.nc.dev5.command.client.goTo.GoToSettingsCommand();} },
    CLIENT_GO_TO_MAIN { {this.command = new GoToMainCommand();} },
    CLIENT_GO_TO_ORDERINGS { {this.command = new by.training.nc.dev5.command.client.goTo.GoToOrderingsCommand();} },
    CLIENT_MAKE_ORDERING { {this.command = new MakeOrderingCommand();} },
    CLIENT_UPDATE_EMAIL { {this.command = new UpdateEmailCommand();} },
    CLIENT_UPDATE_FIRST_NAME { {this.command = new UpdateFirstNameCommand();} },
    CLIENT_UPDATE_LAST_NAME { {this.command = new UpdateLastNameCommand();} },
    CLIENT_UPDATE_PASSWORD  { {this.command = new UpdatePasswordCommand();} },
    CLIENT_GO_TO_PRODUCTS { {this.command = new by.training.nc.dev5.command.client.goTo.GoToProductsCommand();} },
    CLIENT_PAY_FOR_ORDERING { {this.command = new PayForOrderingCommand();} },

    //administrator commands
    ADMIN_CHANGE_BLACK_LIST { {this.command = new ChangeBlackListCommand();} },
    ADMIN_GO_TO_ORDERINGS { {this.command = new by.training.nc.dev5.command.administrator.goTo.GoToOrderingsCommand();} },
    ADMIN_GO_TO_PRODUCTS_ORDERING {{this.command = new GoToProductsOrderingCommand();}},
    ADMIN_GO_TO_CLIENTS {{this.command = new GoToClientsCommand();}},
    ADMIN_GO_TO_SETTINGS {{this.command = new by.training.nc.dev5.command.administrator.goTo.GoToSettingsCommand();}},
    ADMIN_GO_TO_PRODUCTS {{this.command = new by.training.nc.dev5.command.administrator.goTo.GoToProductsCommand();}},
    ADMIN_ADD_PRODUCT {{this.command = new AddProductCommand();}},
    ADMIN_UPDATE_PRODUCT_TITLE {{this.command = new UpdateProductTitleCommand();}},
    ADMIN_UPDATE_PRODUCT_PRICE {{this.command = new UpdateProductPriceCommand();}},
    ADMIN_REMOVE_PRODUCT {{this.command = new RemoveProductCommand();}},
    ADMIN_UPDATE_PASSWORD {{this.command = new by.training.nc.dev5.command.administrator.UpdatePasswordCommand();}};

    ActionCommand command;

    public ActionCommand getCurrentCommand() {return command;}
}