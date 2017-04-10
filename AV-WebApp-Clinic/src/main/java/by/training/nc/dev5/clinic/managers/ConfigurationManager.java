package by.training.nc.dev5.clinic.managers;

import by.training.nc.dev5.clinic.constants.ConfigsConstants;

import java.util.ResourceBundle;

/**
 * Created by user on 04.04.2017.
 */
public enum  ConfigurationManager implements Manager {
    INSTANCE;

    private final ResourceBundle bundle = ResourceBundle.getBundle(ConfigsConstants.CONFIGS_SOURCE);

    public String getProperty(String key){
        return bundle.getString(key);
    }
}
