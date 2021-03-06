package by.training.nc.dev5.service.impl;

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
import by.training.nc.dev5.exception.DataAccessException;
import by.training.nc.dev5.service.TermsOfReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikita on 08.05.2017.
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = DataAccessException.class)
public class TermsOfReferenceServiceImpl implements TermsOfReferenceService {
    private final TermsOfReferenceDao termsDao;
    private final TaskDao taskDao;
    private final TaskQuotaDao taskQuotaDao;

    @Autowired
    public TermsOfReferenceServiceImpl(TermsOfReferenceDao termsDao, TaskDao taskDao, TaskQuotaDao taskQuotaDao) {
        this.termsDao = termsDao;
        this.taskDao = taskDao;
        this.taskQuotaDao = taskQuotaDao;
    }

    public void applyTermsOfReference(TermsOfReferenceDto termsDto) {
        TermsOfReference terms = new TermsOfReference();
        Customer customer = new Customer();

        customer.setId(termsDto.getCustomer().getId());
        terms.setCustomer(customer);

        termsDao.create(terms);

        terms.setTasks(new ArrayList<Task>(termsDto.getTasks().size()));

        for (TaskDto taskDto : termsDto.getTasks()) {
            Task task = new Task();

            task.setSpecification(taskDto.getSpecification());
            task.setTermsOfReference(terms);

            taskDao.create(task);
            task.setTaskQuotas(
                    new ArrayList<TaskQuota>(taskDto.getQuotas().size()));

            for (Map.Entry<QualificationDto, Integer> entry
                    : taskDto.getQuotas().entrySet()) {
                Qualification qualification = new Qualification();
                TaskQuota taskQuota = new TaskQuota();

                qualification.setId(entry.getKey().getId());
                taskQuota.setQualification(qualification);
                taskQuota.setDevelopersNumber(entry.getValue());
                taskQuota.setTask(task);

                taskQuotaDao.create(taskQuota);

                task.getTaskQuotas().add(taskQuota);
            }

            terms.getTasks().add(task);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
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

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
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
