package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.Task;
import by.training.nc.dev5.entity.TermsOfReference;

import java.util.Collection;

/**
 * Created by Nikita on 26.03.2017.
 */
public interface TermsOfReferenceDao extends AbstractDao<TermsOfReference, Integer> {
    Collection<Task> getTasks();
}
