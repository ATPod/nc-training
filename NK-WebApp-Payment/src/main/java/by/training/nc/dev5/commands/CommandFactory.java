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
        commands.put(SHOW_CREDIT_CARDS, new ShowYourCreditCards());
        commands.put(GO_TO_PAYMENT, new GoToMakePaymentCommand());
        commands.put(MAKE_PAYMENT, new MakePayment());
        commands.put(GO_TO_RAFIL, new GoToRefilCommand());
        commands.put(REFIL_ACCOUNT, new RefilCommand());
        commands.put(GO_TO_INSERT_CREDIT_CARD, new GoToInsertCreditCardCommand());
        commands.put(INSERT_CREDIT_CARD, new InsertCreditCardCommand());
        commands.put(GO_TO_DELETE_CREDIT_CARD, new GoToDeleteCreditCardCommand());
        commands.put(DELETE_CREDIT_CARD, new DeleteCreditCardCommand());
        commands.put(GO_TO_BLOCK_CREDIT_CARD, new GoToBlockCreditCardCommand());
        commands.put(BLOCK_CRDIT_CARD, new BlockCreditCardCommand());
        commands.put(GO_TO_UNBLOCK, new GoToUnblockCommand());
        commands.put(UNBLOCK, new UnblockCommand());
    }

    public static Command defineCommand(HttpServletRequest req) {
        Command resultCommand = null;
        String commandName = req.getParameter(Parameters.COMMAND);
        resultCommand = commands.get(commandName);
        return resultCommand;
    }


}
