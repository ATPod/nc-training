package by.training.nc.dev5.clinic.commands.factory;

import by.training.nc.dev5.clinic.commands.*;
import by.training.nc.dev5.clinic.commands.impl.doctorandnurse.ChoosePatientCommand;
import by.training.nc.dev5.clinic.commands.impl.doctorandnurse.goback.GoBackToMenuCommand;
import by.training.nc.dev5.clinic.commands.impl.doctorandnurse.delete.DelDrugCommand;
import by.training.nc.dev5.clinic.commands.impl.doctorandnurse.delete.DelMedProcedureCommand;
import by.training.nc.dev5.clinic.commands.impl.doctor.add.*;
import by.training.nc.dev5.clinic.commands.impl.doctor.delete.*;
import by.training.nc.dev5.clinic.commands.impl.doctorandnurse.goback.GoBackToChoosePatientCommand;
import by.training.nc.dev5.clinic.commands.impl.doctor.gotocommand.*;
import by.training.nc.dev5.clinic.commands.impl.user.*;

/**
 * Created by user on 04.04.2017.
 */
public enum CommandType {
    //user commands
    LOGIN, BACKTOLOGIN, REGISTRATION, GOTOREGISTRATION,
    //doctor & nurse commands
    CHOOSEPATIENT, BACKTOMENU, BACKTOCHOOSEPATIENT,
    // doctor commands
    GOTOADDPATIENT, ADDPATIENT, DELPATIENT,
    GOTOADDDIAGNOSIS, ADDDIAGNOSIS, DELDIAGNOSIS,
    GOTOADDDRUG, ADDDRUG, DELDRUG,
    GOTOADDMEDPROCEDURE, ADDMEDPROCEDURE, DELMEDPROCEDURE,
    GOTOADDSURGERY, ADDSURGERY, DELSURGERY;

    public ICommand getCurrentCommand() throws EnumConstantNotPresentException{
        switch(this){
            case LOGIN:
                return new LoginUserCommand();

            case BACKTOLOGIN:
                return new GoBackToLoginCommand();

            case REGISTRATION:
                return new RegistrationCommand();

            case GOTOREGISTRATION:
                return new GoToRegistrationCommand();

            case CHOOSEPATIENT:
                return new ChoosePatientCommand();

            case BACKTOMENU:
                return new GoBackToMenuCommand();

            case BACKTOCHOOSEPATIENT:
                return new GoBackToChoosePatientCommand();

            case GOTOADDPATIENT:
                return new GoToAddPatientCommand();

            case ADDPATIENT:
                return new AddPatientCommand();

            case DELPATIENT:
                return new DelPatientCommand();

            case GOTOADDDIAGNOSIS:
                return new GoToAddDiagnosisCommand();

            case ADDDIAGNOSIS:
                return new AddDiagnosisCommand();

            case DELDIAGNOSIS:
                return new DelDiagnosisCommand();

            case GOTOADDDRUG:
                return new GoToAddDrugCommand();

            case ADDDRUG:
                return new AddDrugCommand();

            case DELDRUG:
                return new DelDrugCommand();

            case GOTOADDMEDPROCEDURE:
                return new GoToAddMedProcedureCommand();

            case ADDMEDPROCEDURE:
                return new AddMedProcedureCommand();

            case DELMEDPROCEDURE:
                return new DelMedProcedureCommand();

            case GOTOADDSURGERY:
                return new GoToAddSurgeryCommand();

            case ADDSURGERY:
                return new AddSurgeryCommand();

            case DELSURGERY:
                return new DelSurgeryCommand();

            default:
                throw new EnumConstantNotPresentException(this.getDeclaringClass(), this.name());
        }
    }
}
