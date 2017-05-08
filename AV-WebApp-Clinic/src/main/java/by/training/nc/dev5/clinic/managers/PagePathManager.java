package by.training.nc.dev5.clinic.managers;

import by.training.nc.dev5.clinic.constants.ConfigConstants;

import java.util.ResourceBundle;

/**
 * Created by user on 04.04.2017.
 */
public class PagePathManager implements Manager {
    private final ResourceBundle bundle = ResourceBundle.getBundle(ConfigConstants.CONFIGS_SOURCE);
    private static PagePathManager instance;

    public static synchronized PagePathManager getInstance(){
        if(instance == null){
            instance = new PagePathManager();
        }
        return instance;
    }

    public String getProperty(String key){
        return bundle.getString(key);
    }
}
