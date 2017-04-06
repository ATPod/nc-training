package by.training.nc.dev5.clinic.commands.factory;

import by.training.nc.dev5.clinic.commands.Command;
import by.training.nc.dev5.clinic.commands.user.GoToRegistrationCommand;
import by.training.nc.dev5.clinic.commands.user.LoginUserCommand;
import by.training.nc.dev5.clinic.commands.user.LogoutUserCommand;
import by.training.nc.dev5.clinic.commands.user.RegistrationCommand;

/**
 * Created by user on 04.04.2017.
 */
public enum CommandType {
    //user commands
    LOGIN, LOGOUT, REGISTRATION, GOTOREGISTRATION, BACK,

    // client commands
    PAYMENT, GOTOPAYMENT, BALANCE, ADDFUNDS, GOTOADDFUNDS, BLOCK, BACKCLIENT,

    // admin commands
    CLIENTS, OPERATIONS, UNBLOCK, GOTOUNBLOCK, BACKADMIN;

    public Command getCurrentCommand() throws EnumConstantNotPresentException{
        switch(this){
            case LOGIN:
                return new LoginUserCommand();

            case LOGOUT:
                return new LogoutUserCommand();

            case REGISTRATION:
                return new RegistrationCommand();

            case GOTOREGISTRATION:
                return new GoToRegistrationCommand();

            case BACK:
                //return new GoBackCommand();

            /*case PAYMENT:
                return new PaymentCommand();

            case GOTOPAYMENT:
                return new GoToPaymentCommand();

            case BALANCE:
                return new BalanceCommand();

            case ADDFUNDS:
                return new AddFundsCommand();

            case GOTOADDFUNDS:
                return new GoToAddFundsCommand();

            case BLOCK:
                return new BlockCommand();

            case BACKCLIENT:
                return new GoBackClientCommand();

            case CLIENTS:
                return new ShowClientsCommand();

            case OPERATIONS:
                return new ShowOperationsCommand();

            case UNBLOCK:
                return new UnblockCommand();

            case GOTOUNBLOCK:
                return new GoToUnblockCommand();

            case BACKADMIN:
                return new GoBackAdminCommand();*/

            default:
                throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        }
    }

    public String getValue(){
        switch(this){
            case PAYMENT:
                return "";

            case BLOCK:
                return "";

            case UNBLOCK:
                return "";

            case ADDFUNDS:
                return "";

            default:
                throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        }
    }
}
