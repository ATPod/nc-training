package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.TaskDao;
import by.training.nc.dev5.dao.TaskQuotaDao;
import by.training.nc.dev5.dao.TermsOfReferenceDao;
import by.training.nc.dev5.dao.persistence.JpaDaoFactory;
import by.training.nc.dev5.dto.CustomerDto;
import by.training.nc.dev5.dto.QualificationDto;
import by.training.nc.dev5.dto.TaskDto;
import by.training.nc.dev5.dto.TermsOfReferenceDto;
import by.training.nc.dev5.entity.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikita on 08.05.2017.
 */
public class TermsOfReferenceServiceImpl implements TermsOfReferenceService {
    private static DaoFactory daoFactory;

    static {
        daoFactory = new JpaDaoFactory();
    }

    private TermsOfReferenceDao termsDao;
    private TaskDao taskDao;
    private TaskQuotaDao taskQuotaDao;

    {
        termsDao = daoFactory.getTermsOfReferenceDao();
        taskDao = daoFactory.getTaskDao();
        taskQuotaDao = daoFactory.getTaskQuotaDao();
    }

    public void applyTermsOfReference(TermsOfReferenceDto termsOfReferenceDto) {
        TermsOfReferenceBuilder termsBuilder = new TermsOfReferenceBuilder();
        Customer customer = new Customer();

        for (TaskDto taskDto : termsOfReferenceDto.getTasks()) {
            TaskBuilder taskBuilder = new TaskBuilder();

            taskBuilder.setSpecification(taskDto.getSpecification());
            for (Map.Entry<QualificationDto, Integer> entry
                    : taskDto.getQuotas().entrySet()) {
                Qualification qualification = new Qualification();

                qualification.setId(entry.getKey().getId());
                taskBuilder.setDevelopersNumber(
                        qualification, entry.getValue());
            }

            termsBuilder.addTask(taskBuilder.createTask());
        }

        customer.setId(termsOfReferenceDto.getCustomer().getId());
        termsBuilder.setCustomer(customer);

        termsDao.create(termsBuilder.createTermsOfReference());
    }

    public Collection<TermsOfReferenceDto> getTermsByCustomer(CustomerDto customerDto) {
        Collection<TermsOfReference> termsByCustomer = termsDao
                .getTermsOfReferenceByCustomer(customerDto.getId());
        Collection<TermsOfReferenceDto> result =
                new ArrayList<TermsOfReferenceDto>(termsByCustomer.size());

        for (TermsOfReference terms : termsByCustomer) {
            result.add(createTermsDto(terms));
        }

        return result;
    }

    private TermsOfReferenceDto createTermsDto(TermsOfReference terms) {
        TermsOfReferenceDto termsDto = new TermsOfReferenceDto();
        CustomerDto customerDto = new CustomerDto();
        Customer customer = terms.getCustomer();

        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());

        termsDto.setId(terms.getId());
        termsDto.setCustomer(customerDto);

        terms.setTasks(taskDao.getTasks(terms.getId()));
        termsDto.setTasks(new ArrayList<TaskDto>(terms.getTasks().size()));

        for (Task task : terms.getTasks()) {
            TaskDto taskDto = new TaskDto();

            taskDto.setSpecification(task.getSpecification());
            taskDto.setQuotas(new HashMap<QualificationDto, Integer>());

            task.setTaskQuotas(taskQuotaDao.getTaskQuotas(task.getId()));

            for (TaskQuota taskQuota : task.getTaskQuotas()) {
                QualificationDto qDto = new QualificationDto();

                qDto.setName(taskQuota.getQualification().getName());
                qDto.setId(taskQuota.getQualification().getId());

                taskDto.getQuotas().put(qDto, taskQuota.getDevelopersNumber());
            }

            termsDto.getTasks().add(taskDto);
        }

        return termsDto;
    }

    public Collection<TermsOfReferenceDto> getPendingTerms() {
        Collection<TermsOfReference> termsWithNoProject =
                termsDao.getTermsOfReferenceWithNoProject();
        Collection<TermsOfReferenceDto> result =
                new ArrayList<TermsOfReferenceDto>(termsWithNoProject.size());

        for (TermsOfReference terms : termsWithNoProject) {
            result.add(createTermsDto(terms));
        }

        return result;
    }
}
