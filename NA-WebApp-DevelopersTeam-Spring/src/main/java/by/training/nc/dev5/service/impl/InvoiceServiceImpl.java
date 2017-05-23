package by.training.nc.dev5.service.impl;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.InvoiceDao;
import by.training.nc.dev5.dao.ProjectDao;
import by.training.nc.dev5.dao.persistence.JpaDaoFactory;
import by.training.nc.dev5.dto.CustomerDto;
import by.training.nc.dev5.dto.InvoiceDto;
import by.training.nc.dev5.dto.ProjectDto;
import by.training.nc.dev5.entity.Invoice;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.service.InvoiceService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 13.05.2017.
 */
public class InvoiceServiceImpl implements InvoiceService {
    private static DaoFactory daoFactory;
    private InvoiceDao invoiceDao;
    private ProjectDao projectDao;

    static {
        daoFactory = new JpaDaoFactory();
    }

    {
        invoiceDao = daoFactory.getInvoiceDao();
        projectDao = daoFactory.getProjectDao();
    }

    public void issueInvoice(ProjectDto projectDto, double price) {
        Invoice invoice = new Invoice();
        Project project = projectDao.getEntityById(projectDto.getId());

        invoice.setPrice(price);
        invoice.setProject(project);
        invoice.setPaid(false);

        invoiceDao.create(invoice);
    }

    public Collection<InvoiceDto> getInvoices(CustomerDto customer) {
        Collection<Invoice> invoicesByCustomer =
                invoiceDao.getInvoicesByCustomer(customer.getId());
        Collection<InvoiceDto> result =
                new ArrayList<InvoiceDto>(invoicesByCustomer.size());

        for (Invoice invoice : invoicesByCustomer) {
            result.add(createInvoiceDto(invoice));
        }

        return result;
    }

    private InvoiceDto createInvoiceDto(Invoice invoice) {
        InvoiceDto dto = new InvoiceDto();
        ProjectDto projectDto = new ProjectDto();

        dto.setPaid(invoice.isPaid());
        dto.setPrice(invoice.getPrice());

        return dto;
    }
}
