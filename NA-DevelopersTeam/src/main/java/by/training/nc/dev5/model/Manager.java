package by.training.nc.dev5.model;

import by.training.nc.dev5.artifact.Project;
import by.training.nc.dev5.artifact.ProjectEstimator;
import by.training.nc.dev5.artifact.TermsOfReference;
import by.training.nc.dev5.billing.BillingService;
import by.training.nc.dev5.billing.Invoice;
import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.DeveloperDao;
import by.training.nc.dev5.dao.TermsOfReferenceDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides project management logic
 *
 * @author Nikita Atroshenko
 */
public class Manager {

    private final DeveloperDao developerDao;
    private final TermsOfReferenceDao termsOfReferenceDao;

    public Manager() {
        developerDao = DaoFactory.getDaoFactory(DaoFactory.TRANSIENT)
                .getDeveloperDao();
        termsOfReferenceDao = DaoFactory.getDaoFactory(DaoFactory.TRANSIENT)
                .getTermsOfReferenceDao();
    }

    /**
     * Forms project basing on terms of reference
     * @param tor terms of reference provided by customer
     * @return a project with assigned team
     */
    public Project formProject(TermsOfReference tor) {
        Project project = new Project();
        List<Developer> team = new ArrayList<>();

        tor = termsOfReferenceDao.create(tor);
        project.setTermsOfReference(tor);

        for (Qualification q : Qualification.values()) {
            List<Developer> qDevs = developerDao.getUnassignedDevelopers(q);

            team.addAll(qDevs);
            qDevs.forEach(dev -> dev.setProject(project));
        }

        project.setDevelopers(team);

        return project;
    }

    /**
     * Estimates project cost
     * @param p project to estimate
     * @return project cost
     */
    public double estimateProject(Project p) {
        ProjectEstimator estimator = new ProjectEstimator(p);

        return estimator.estimateProject();
    }

    /**
     * Issues invoice to be payed by customer
     * @param c customer to issue invoice for
     * @param p project associated with invoice
     */
    public void issueInvoiceForCustomer(Customer c, Project p) {
        Invoice invoice = new Invoice();
        double price = estimateProject(p);

        invoice.setCustomer(c);
        invoice.setProject(p);
        invoice.setPrice(price);

        BillingService.getInstance().issueInvoice(invoice);
    }
}
