package by.training.nc.dev5.clinic.managers;

import by.training.nc.dev5.clinic.constants.ConfigsConstants;

import java.util.ResourceBundle;

public enum  MessageManager implements Manager{
    INSTANCE;

    private final ResourceBundle bundle = ResourceBundle.getBundle(ConfigsConstants.MESSAGES_SOURCE);

    public String getProperty(String key) {
        return bundle.getString(key);
    }
}
