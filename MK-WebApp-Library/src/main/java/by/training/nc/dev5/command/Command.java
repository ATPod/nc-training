package by.training.nc.dev5.command;

import com.sun.deploy.net.HttpRequest;

/**
 * Created by ASUS on 25.04.2017.
 */
public interface Command {
    void execute (HttpRequest request);
}
