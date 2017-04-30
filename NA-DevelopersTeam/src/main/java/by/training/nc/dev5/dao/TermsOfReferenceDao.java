package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.TermsOfReference;
import by.training.nc.dev5.exception.DataAccessException;

import java.util.Collection;

/**
 * Created by Nikita on 26.03.2017.
 */
public interface TermsOfReferenceDao extends AbstractDao<TermsOfReference, Integer> {
    Collection<TermsOfReference> getTermsOfReferenceWithNoProject()
            throws DataAccessException;

    Collection<TermsOfReference> getTermsOfReferenceByCustomer(Integer customerId)
        throws DataAccessException;
}
