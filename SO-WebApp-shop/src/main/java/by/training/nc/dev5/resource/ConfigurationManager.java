package by.training.nc.dev5.resource;

import java.util.ResourceBundle;

public class ConfigurationManager {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    private ConfigurationManager() {}

    public static String getProperty(String key) {
    return resourceBundle.getString(key);
  }
}