package by.training.nc.dev5.clinic.managers;

import by.training.nc.dev5.clinic.constants.ConfigConstants;

import java.util.ResourceBundle;

public class MessageManager implements Manager{
    private static MessageManager instance;
    private final ResourceBundle bundle = ResourceBundle.getBundle(ConfigConstants.MESSAGES_SOURCE);

    public static synchronized MessageManager getInstance(){
        if(instance == null){
            instance = new MessageManager();
        }
        return instance;
    }

    public String getProperty(String key) {
        return bundle.getString(key);
    }
}
