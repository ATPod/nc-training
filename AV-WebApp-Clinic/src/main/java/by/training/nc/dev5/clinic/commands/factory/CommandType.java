package by.training.nc.dev5.clinic.commands.factory;

import by.training.nc.dev5.clinic.commands.Command;
import by.training.nc.dev5.clinic.commands.doctor.GoToChoosePatient;
import by.training.nc.dev5.clinic.commands.user.*;

/**
 * Created by user on 04.04.2017.
 */
public enum CommandType {
    //user commands
    LOGIN, LOGOUT, REGISTRATION, GOTOREGISTRATION, BACK,

    // doctor commands
    PATIENTS;

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
                return new GoBackCommand();

            case PATIENTS:
                return new GoToChoosePatient();

            default:
                throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        }
    }
}
