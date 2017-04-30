package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.*;
import by.training.nc.dev5.entity.Customer;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.Manager;
import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.exception.DataAccessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by F1 on 05.04.2017.
 */
public class AuthenticationService {
    static final Logger logger =
            LogManager.getLogger(AuthenticationService.class);
    private static final AuthenticationService instance =
            new AuthenticationService();
    private final DaoFactory daoFactory =
            DaoFactory.getDaoFactory(DaoFactory.MYSQL);

    public Person signUp(Person person) {
        logger.trace("Signing up new person");
        logger.debug("\tRole='{}'\n" +
                "\tName='{}'\n" +
                "\tLogin='{}'",
                person.getUserRole(), person.getName(), person.getLogin());

        try {
            switch (person.getUserRole()) {
            case CUSTOMER:
                signUpPerson((Customer) person);
                break;
            case DEVELOPER:
                signUpPerson((Developer) person);
                break;
            case MANAGER:
                signUpPerson((Manager) person);
                break;
            }
        } catch (DataAccessException e) {
            logger.error("Sign up person\tFAILED", e);
            e.printStackTrace();
            // todo
        }
        logger.info("Sign up person\tSUCCESS");

        return person;
    }

    private void signUpPerson(Customer customer) throws DataAccessException {
        CustomerDao dao = daoFactory.getCustomerDao();

        dao.create(customer);
    }

    private void signUpPerson(Developer developer)
            throws DataAccessException {

        DeveloperDao dao = daoFactory.getDeveloperDao();

        dao.create(developer);
    }

    private void signUpPerson(Manager manager) throws DataAccessException {
        ManagerDao dao = daoFactory.getManagerDao();

        dao.create(manager);
    }

    public Person logOn(String login, String password) {
        logger.trace("Log on {}", login);

        try {
            PersonDao personDao = daoFactory.getPersonDao();

            Person person = personDao.getPersonByLogin(login);

            logger.info("Log on\tSUCCEED");
            if (person == null) {
                return null;
            }

            if (person.getPassword().equals(password)) {
                return person;
            }

            return null;
        } catch (DataAccessException e) {
            logger.error("Log on\tFAILED");
        }

        return null;
    }

    public static AuthenticationService getInstance() {
        return instance;
    }
}
