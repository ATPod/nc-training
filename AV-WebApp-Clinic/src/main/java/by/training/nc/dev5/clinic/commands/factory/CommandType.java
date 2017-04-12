package by.training.nc.dev5.clinic.commands.factory;

import by.training.nc.dev5.clinic.commands.Command;
import by.training.nc.dev5.clinic.commands.doctor.*;
import by.training.nc.dev5.clinic.commands.doctor.add.*;
import by.training.nc.dev5.clinic.commands.doctor.delete.*;
import by.training.nc.dev5.clinic.commands.doctor.goback.GoBackToChoosePatientCommand;
import by.training.nc.dev5.clinic.commands.doctor.goback.GoBackToDoctorInnerMenuCommand;
import by.training.nc.dev5.clinic.commands.doctor.goback.GoBackToDoctorMainCommand;
import by.training.nc.dev5.clinic.commands.doctor.gotoadd.*;
import by.training.nc.dev5.clinic.commands.user.*;

/**
 * Created by user on 04.04.2017.
 */
public enum CommandType {
    //user commands
    LOGIN, LOGOUT, REGISTRATION, GOTOREGISTRATION, BACK,

    // doctor commands
    GOTOCHOOSEPATIENT, CHOOSEPATIENT, BACKTODOCTORMAIN, BACKTOCHOOSEPATIENT, BACKTODOCTORINNERMENU,
    GOTOADDPATIENT, ADDPATIENT, DELPATIENT,
    GOTOADDDIAGNOSIS, ADDDIAGNOSIS, DELDIAGNOSIS,
    GOTOADDDRUG, ADDDRUG, DELDRUG,
    GOTOADDPROCEDURE, ADDPROCEDURE, DELPROCEDURE,
    GOTOADDSURGERY, ADDSURGERY, DELSURGERY;

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

            case GOTOCHOOSEPATIENT:
                return new GoToChoosePatientCommand();

            case CHOOSEPATIENT:
                return new ChoosePatientCommand();

            case BACKTODOCTORMAIN:
                return new GoBackToDoctorMainCommand();

            case BACKTOCHOOSEPATIENT:
                return new GoBackToChoosePatientCommand();

            case BACKTODOCTORINNERMENU:
                return new GoBackToDoctorInnerMenuCommand();

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

            case GOTOADDPROCEDURE:
                return new GoToAddProcedureCommand();

            case ADDPROCEDURE:
                return new AddProcedureCommand();

            case DELPROCEDURE:
                return new DelProcedureCommand();

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
