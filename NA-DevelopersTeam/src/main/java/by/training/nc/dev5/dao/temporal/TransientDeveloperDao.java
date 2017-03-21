package by.training.nc.dev5.dao.temporal;

import by.training.nc.dev5.dao.DeveloperDao;
import by.training.nc.dev5.model.Developer;

import java.util.List;

/**
 * Created by Nikita on 21.03.2017.
 */
public class TransientDeveloperDao
        extends TransientAbstractDao<Developer, Integer>
        implements DeveloperDao {
    private int idCounter;

    @Override
    protected synchronized Integer generateUniqueId() {
        return idCounter++;
    }

    @Override
    public List<Developer> getUnassignedDevelopers() {
        // TODO: implement me
        throw new UnsupportedOperationException();
    }
}
