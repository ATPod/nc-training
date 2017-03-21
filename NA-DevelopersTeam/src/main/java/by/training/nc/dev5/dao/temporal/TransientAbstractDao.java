package by.training.nc.dev5.dao.temporal;

import by.training.nc.dev5.dao.AbstractDao;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Nikita on 21.03.2017.
 */
public abstract class TransientAbstractDao<E, K> implements AbstractDao<E, K> {
    private final Map<K, E> storage;

    public TransientAbstractDao() {
        storage = new HashMap<K, E>();
    }

    @Override
    public List<E> getAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public E getEntityById(K id) {
        return storage.get(id);
    }

    @Override
    public void update(E entity, K id) {
        synchronized (storage) {
            storage.remove(id);
            storage.put(id, entity);
        }
    }

    @Override
    public void delete(K id) {
        synchronized (storage) {
            storage.remove(id);
        }
    }

    protected abstract K generateUniqueId();

    @Override
    public K create(E entity) {
        K id = generateUniqueId();

        synchronized (storage) {
            storage.put(id, entity);
        }

        return id;
    }

    protected Map<K, E> getByPredicate(Predicate<E> predicate) {
        Set<Map.Entry<K, E>> filtered = storage.entrySet().stream().filter(
                e -> predicate.test(e.getValue())
        ).collect(Collectors.toSet());
        Map<K, E> result = new HashMap<>();

        for (Map.Entry<K, E> keEntry : filtered) {
            result.put(keEntry.getKey(), keEntry.getValue());
        }

        return result;
    }
}
