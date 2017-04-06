package by.training.nc.dev5.clinic.logger;
import org.apache.log4j.Logger;
/**
 * Created by user on 05.04.2017.
 */
public enum  ClinicLogger {
    INSTANCE;
    private Logger logger;

    @SuppressWarnings("rawtypes")
    public void logError(Class sender, String message){
        logger = Logger.getLogger(sender);
        logger.error(message);
    }
}
