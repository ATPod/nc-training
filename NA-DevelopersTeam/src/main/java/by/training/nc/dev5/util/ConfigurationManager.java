package by.training.nc.dev5.util;

import java.util.*;

/**
 * Created by Nikita on 27.03.2017.
 */
public class ConfigurationManager extends ResourceBundle {
    private static final ConfigurationManager instance;
    private final List<ResourceBundle> bundles;
    private Enumeration<String> keys;

    static {
        instance = new ConfigurationManager();
    }

    public ConfigurationManager() {
        bundles = new ArrayList<ResourceBundle>();

        bundles.add(ResourceBundle.getBundle("mysql"));
        bundles.add(ResourceBundle.getBundle("pages"));
    }

    /**
     * Gets an object for the given key from this resource bundle.
     * Returns null if this resource bundle does not contain an
     * object for the given key.
     *
     * @param key the key for the desired object
     * @return the object for the given key, or null
     * @throws NullPointerException if <code>key</code> is <code>null</code>
     * @throws MissingResourceException if no object is specified for the
     * <code>key</code>
     */
    protected Object handleGetObject(String key) {
        MissingResourceException last = null;

        for (ResourceBundle bundle : bundles) {
            try {
                return bundle.getString(key);
            } catch (MissingResourceException e) {
                last = e;
            }
        }

        assert last != null;
        throw last;
    }

    private void initKeys() {
        final List<String> keysList = new ArrayList<String>();

        for (ResourceBundle bundle : bundles) {
            Enumeration<String> bundleKeys = bundle.getKeys();

            while (bundleKeys.hasMoreElements()) {
                keysList.add(bundleKeys.nextElement());
            }
        }

        keys = new Enumeration<String>() {
            private int pos = 0;

            public boolean hasMoreElements() {
                return pos < keysList.size();
            }

            public String nextElement() {
                String next = keysList.get(pos);

                pos++;

                return next;
            }
        };
    }

    /**
     * Returns an enumeration of the keys.
     *
     * @return an <code>Enumeration</code> of the keys contained in
     * this <code>ResourceBundle</code> and its parent bundles.
     */
    public Enumeration<String> getKeys() {
        if (keys == null) {
            initKeys();
        }

        return keys;
    }

    public static ConfigurationManager getInstance() {
        return instance;
    }
}
