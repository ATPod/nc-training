package by.training.nc.dev5.utils;
import java.io.IOException;
import java.util.Properties;
/**
 * Created by user on 28.03.2017.
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
