package by.training.nc.dev5.dao.temporal;

import by.training.nc.dev5.dao.DeveloperDao;
import by.training.nc.dev5.model.Developer;
import by.training.nc.dev5.model.Qualification;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Nikita on 21.03.2017.
 */
public class TransientDeveloperDao implements DeveloperDao {
    private int idCounter;

    private final Map<Integer, Developer> storage;

    public TransientDeveloperDao() {
        storage = new HashMap<>();
    }

    @Override
    public Collection<Developer> getAll() {
        return storage.values();
    }

    @Override
    public Developer getEntityById(Integer id) {
        return storage.get(id);
    }

    @Override
    public void update(Developer entity, Integer id) {
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
    public Developer create(Developer entity) {
        Integer id = generateUniqueId();

        synchronized (storage) {
            storage.put(id, entity);
        }
        entity.setId(id);

        return entity;
    }


    private synchronized int generateUniqueId() {
        return idCounter++;
    }

    @Override
    public List<Developer> getUnassignedDevelopers(Qualification q) {
        return storage.values().stream().filter(dev ->
                dev.getQualification().equals(q) && dev.getProject() != null
        ).collect(Collectors.toList());
    }
}
