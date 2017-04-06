package by.training.nc.dev5.cli;

import java.util.Collection;

/**
 * Created by Nikita on 24.03.2017.
 */
public interface MenuController {
    /**
     * Gets action that has to be performed after specified key entered.
     * @param key   a key that identifies some action to be performed
     * @return an instance of {@link MenuAction} that can be invoked or null
     * if key is not valid
     * @throws NullPointerException - if the specified key is null and this
     * model does not permit null keys
     */
    MenuAction getAction(String key);

    /**
     * Gets all valid keys, each of them is bound to some action
     * @return a collection of keys.
     */
    Collection<String> getKeys();
}
