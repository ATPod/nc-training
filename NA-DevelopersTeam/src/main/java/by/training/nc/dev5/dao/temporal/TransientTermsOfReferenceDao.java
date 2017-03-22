package by.training.nc.dev5.dao.temporal;

import by.training.nc.dev5.artifact.TermsOfReference;
import by.training.nc.dev5.dao.TermsOfReferenceDao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikita on 22.03.2017.
 */
public class TransientTermsOfReferenceDao
        implements TermsOfReferenceDao {
    private int idCounter;
    private final Map<Integer, TermsOfReference> storage;

    public TransientTermsOfReferenceDao() {
        storage = new HashMap<Integer, TermsOfReference>();
    }

    @Override
    public Collection<TermsOfReference> getAll() {
        return storage.values();
    }

    @Override
    public TermsOfReference getEntityById(Integer id) {
        return storage.get(id);
    }

    @Override
    public void update(TermsOfReference entity, Integer id) {
        synchronized (storage) {
            storage.remove(id);
            storage.put(id, entity);
        }
    }

    @Override
    public void delete(Integer id) {
        synchronized (storage) {
            storage.remove(id);
        }
    }

    @Override
    public TermsOfReference create(TermsOfReference entity) {
        int id = generateUniqueId();

        synchronized (storage) {
            storage.put(id, entity);
        }

        return entity;
    }

    protected int generateUniqueId() {
        return idCounter++;
    }
}
