package by.training.nc.dev5.dao.temporal;

import by.training.nc.dev5.billing.Invoice;
import by.training.nc.dev5.dao.InvoiceDao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikita on 21.03.2017.
 */
public class TransientInvoiceDao implements InvoiceDao {

    private int idCounter;
    private final Map<Integer, Invoice> storage;

    public TransientInvoiceDao() {
        storage = new HashMap<>();
    }

    @Override
    public Collection<Invoice> getAll() {
        return storage.values();
    }

    @Override
    public Invoice getEntityById(Integer id) {
        return storage.get(id);
    }

    @Override
    public void update(Invoice entity, Integer id) {
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
    public Invoice create(Invoice entity) {
        int id = generateUniqueId();

        synchronized (storage) {
            storage.put(id, entity);
        }

        return entity;
    }

    private synchronized int generateUniqueId() {
        return idCounter++;
    }
}
