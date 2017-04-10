package by.training.nc.dev5.dao.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @author nic
 *
 */
public class PropertiesUtil {

    public Properties getProperties(String propertiesFile){
        Properties properties = new Properties();
        try{
            properties.load(this.getClass().getClassLoader().getResourceAsStream(propertiesFile));
            return properties;
        }catch(IOException ex){
            return null;
        }
    }

}
