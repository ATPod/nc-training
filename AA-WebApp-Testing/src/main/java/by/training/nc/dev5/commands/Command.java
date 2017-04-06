package by.training.nc.dev5.commands;

import javax.servlet.http.HttpServletRequest;
//Интерфейс Команда
public interface Command {
    //Выполнить команду
    String execute(HttpServletRequest request);
}
