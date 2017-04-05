package by.training.nc.dev5.commands;

import by.training.nc.dev5.commands.user.*;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.constants.Parameters;

import javax.servlet.http.HttpServletRequest;

public enum Commands {
    GOTOLOGIN{{
        this.command=new GoToLoginCommand();
        this.redirectJSP=JspPaths.LOGIN_PAGE_PATH;
    }},
    GOTOREGISTRATION{{
        this.command=new GoToRegistration();
        this.redirectJSP=JspPaths.REGISTRATION_PAGE_PATH;
    }},
    GOTOSTUDENTREGISTRATION{{
       this.command=new GoToStudentRegistrationForm();
        this.redirectJSP=JspPaths.STUDENT_REGISTER_FORM;
    }},
    GOTOTUTORREGISTRATION{{
        this.command=new GoToTutorRegistrationForm();
        this.redirectJSP=JspPaths.TUTOR_REGISTER_FORM;
    }},
    REGISTERSTUDENT{{
        this.command=new RegisterStudentCommand();
        this.redirectJSP=JspPaths.LOGIN_PAGE_PATH;
    }},
    REGISTERTUTOR{{
        this.command=new RegisterTutorCommand();
        this.redirectJSP=JspPaths.LOGIN_PAGE_PATH;
    }},
    LOGIN{{
        this.command=new LoginUserCommand();
        this.redirectJSP="";
    }},
    STUDENTMENU{{
        this.command=new RegisterStudentCommand();
        this.redirectJSP=JspPaths.STUDENT_MENU;
    }},
    TUTORMENU{{
        this.command=new RegisterStudentCommand();
        this.redirectJSP=JspPaths.TUTOR_MENU;
    }},
    LOGOUTUSER{{
        this.command=new LogoutUserCommand();
        this.redirectJSP=JspPaths.INDEX_PAGE_PATH;
    }}
    ;
    public Command command = null;
    public String redirectJSP=null;
    public static Command defineCommand(HttpServletRequest req) {
        Command resultCommand = null;
        String command = req.getParameter(Parameters.COMMAND);
        if (command != null)
            try {
                resultCommand = Commands.valueOf(command.toUpperCase()).command;
            } catch (IllegalArgumentException e) {
                System.out.println("Неверная команда!");
            }
        return resultCommand;
    }
}
