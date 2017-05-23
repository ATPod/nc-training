package by.training.nc.dev5.service;

import by.training.nc.dev5.dto.CustomerDto;
import by.training.nc.dev5.dto.TermsOfReferenceDto;

import java.util.Collection;

/**
 * Created by Nikita on 08.05.2017.
 */
public interface TermsOfReferenceService {
    void applyTermsOfReference(TermsOfReferenceDto termsOfReferenceDto);

    Collection<TermsOfReferenceDto> getTermsByCustomer(CustomerDto customerDto);

    Collection<TermsOfReferenceDto> getPendingTerms();
}
