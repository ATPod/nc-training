package by.training.nc.dev5.commands;

import by.training.nc.dev5.commands.student.PassTestCommand;
import by.training.nc.dev5.commands.student.ShowResultCommand;
import by.training.nc.dev5.commands.student.ShowTestCommand;
import by.training.nc.dev5.commands.turor.AddTestCommand;
import by.training.nc.dev5.commands.turor.CreateTestCommand;
import by.training.nc.dev5.commands.turor.FillTestCommand;
import by.training.nc.dev5.commands.turor.ShowStudentsCommand;
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
        commands.put(GO_TO_STUDENT_REGISTRATION, new GoToStudentRegistrationForm());
        commands.put(GO_TO_TUTOR_REGISTRATION, new GoToTutorRegistrationForm());
        commands.put(REGISTER_STUDENT, new RegisterStudentCommand());
        commands.put(REGISTER_TUTOR, new RegisterTutorCommand());
        commands.put(LOGIN, new LoginUserCommand());
        commands.put(STUDENT_MENU, new RegisterStudentCommand());
        commands.put(TUTOR_MENU, new RegisterStudentCommand());
        commands.put(LOGOUT_USER, new LogoutUserCommand());
        commands.put(SHOW_TESTS, new ShowTestsCommand());
        commands.put(SHOW_TEST, new ShowTestCommand());
        commands.put(SHOW_RESULT, new ShowResultCommand());
        commands.put(SHOW_STUDENTS, new ShowStudentsCommand());
        commands.put(CREATE_TEST,new CreateTestCommand());
        commands.put(FILL_TEST,new FillTestCommand());
        commands.put(ADD_TEST,new AddTestCommand());

    }

    public static Command defineCommand(HttpServletRequest req) {
        Command resultCommand = null;
        String commandName = req.getParameter(Parameters.COMMAND);
        resultCommand = commands.get(commandName);
        return resultCommand;
    }


}