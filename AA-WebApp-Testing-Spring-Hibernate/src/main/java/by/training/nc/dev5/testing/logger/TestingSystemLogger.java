package by.training.nc.dev5.testing.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//Singleton
public enum TestingSystemLogger {
    INSTANCE;
    private Logger logger = null;

    public void logError(Class sender, String message) {
        logger = LogManager.getLogger(sender);
        logger.error(message);
    }

    public void logWarning(Class sender, String message) {
        logger = LogManager.getLogger(sender);
        logger.warn(message);
    }

    public void logInfo(Class sender, String message) {
        logger = LogManager.getLogger(sender);
        logger.info(message);
    }
    public void logFatalError(Class sender, String message)
    {
        logger = LogManager.getLogger(sender);
        logger.fatal(message);
    }
    public void logDebug(Class sender, String message)
    {
        logger = LogManager.getLogger(sender);
        logger.debug(message);
    }
}
