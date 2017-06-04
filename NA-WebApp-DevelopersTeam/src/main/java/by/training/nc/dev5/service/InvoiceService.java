package by.training.nc.dev5.service;

import by.training.nc.dev5.dto.CustomerDto;
import by.training.nc.dev5.dto.InvoiceDto;
import by.training.nc.dev5.dto.ProjectDto;

import java.util.Collection;

/**
 * Created by Nikita on 13.05.2017.
 */
public interface InvoiceService {
    void issueInvoice(ProjectDto project, double price);

    Collection<InvoiceDto> getInvoices(CustomerDto customer);
}
