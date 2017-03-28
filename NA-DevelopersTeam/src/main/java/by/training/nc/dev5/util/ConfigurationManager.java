package by.training.nc.dev5.util;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * Created by Nikita on 27.03.2017.
 */
public class ConfigurationManager extends ResourceBundle {
    private static final ConfigurationManager INSTANCE;
    private final ResourceBundle bundle;

    static {
        INSTANCE = new ConfigurationManager();
    }

    public static ConfigurationManager getInstance() {
        return INSTANCE;
    }

    public ConfigurationManager() {
        bundle = ResourceBundle.getBundle("mysql");
    }

    /**
     * Gets an object for the given key from this resource bundle.
     * Returns null if this resource bundle does not contain an
     * object for the given key.
     *
     * @param key the key for the desired object
     * @return the object for the given key, or null
     * @throws NullPointerException if <code>key</code> is <code>null</code>
     */
    protected Object handleGetObject(String key) {
        return bundle.getString(key);
    }

    /**
     * Returns an enumeration of the keys.
     *
     * @return an <code>Enumeration</code> of the keys contained in
     * this <code>ResourceBundle</code> and its parent bundles.
     */
    public Enumeration<String> getKeys() {
        return bundle.getKeys();
    }
}
