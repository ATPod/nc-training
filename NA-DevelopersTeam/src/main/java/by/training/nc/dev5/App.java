package by.training.nc.dev5;

import by.training.nc.dev5.accounts.UserRole;
import by.training.nc.dev5.cli.MenuAction;
import by.training.nc.dev5.cli.MenuController;
import by.training.nc.dev5.cli.MenuView;
import by.training.nc.dev5.cli.util.ValueReaderUtil;
import by.training.nc.dev5.cli.util.ValueWriterUtil;
import by.training.nc.dev5.entity.Customer;
import by.training.nc.dev5.entity.Manager;
import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.entity.TermsOfReference;
import by.training.nc.dev5.service.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Sample application. Demonstrates usage of classes
 *
 * @author Nikita Atroshenko
 */
public class App implements MenuController {

    /** This annotation is used to get all actions of this class */
    @Retention(RetentionPolicy.RUNTIME)
    private @interface Action {
        /** A string key that this action should be bound to */
        String key();

        /** A description of this action */
        String description();
    }

    private Map<String, MenuAction> menuActionsByKeyMap;
    private TermsOfReferenceBuilder termsOfReferenceBuilder;
    private Person user;

    public App() {
        initializeMenuActionsByKeyMap();
    }

    public static void main(String[] args ) {
        App app = new App();
        MenuView menuView = new MenuView(app);

        menuView.run();
    }

    @Action(key = "log-on",
            description = "Log on to system")
    void logOn() {
        AuthenticationService authenticationService =
                AuthenticationService.getInstance();

        String login = ValueReaderUtil.readString("Enter login");
        String password = ValueReaderUtil.readString("Enter password");

        Person person = authenticationService.logOn(login, password);

        if (person == null) {
            System.out.println("Login failed");
            return;
        }

        switch (person.getUserRole()) {
            case CUSTOMER:
                user = person;
                System.out.println("Logged in as customer");
                break;
            case DEVELOPER:
                System.out.println(
                        "Logging in as developer is not supported yet");
                break;
            case MANAGER:
                user = person;
                System.out.println("Logged in as manager");
                break;
        }
    }

    @Action(key = "show-pending-tors",
            description = "Shows all terms of reference " +
                    "that have no bound projects")
    void showPendingTermsOfReference() {
        ManagerService managerService = ManagerService.getInstance();

        Collection<TermsOfReference> pendingTermsOfReference =
                managerService.getPendingTermsOfReference();

        ValueWriterUtil.writeCollection(pendingTermsOfReference);
    }

    @Action(key = "add-task",
            description = "Adds tasks to new terms of reference")
    void addTask() {
        HelpService helpService = HelpService.getInstance();

        if (user == null || !user.getUserRole().equals(UserRole.CUSTOMER)) {
            System.out.println("Please, log on as customer");
            return;
        }

        if (termsOfReferenceBuilder == null) {
            termsOfReferenceBuilder = new TermsOfReferenceBuilder();
            termsOfReferenceBuilder.setCustomer((Customer) user);
        }

        TaskBuilder taskBuilder = new TaskBuilder();

        int qualificationId = ValueReaderUtil.readInt(
                "Enter qualification id");
        String specification = ValueReaderUtil.readString(
                "Enter specification");
        int developersNumber = ValueReaderUtil.readInt(
                "Enter developers number");

        taskBuilder.setSpecification(specification);
        taskBuilder.setDevelopersNumber(
                helpService.getQualification(qualificationId),
                developersNumber);

        termsOfReferenceBuilder.addTask(taskBuilder.createTask());
    }

    @Action(key = "propose-tor",
            description = "Propose your terms of reference to system")
    void proposeTermsOfReference() {
        CustomerService customerService = CustomerService.getInstance();
        TermsOfReference tor;

        if (user == null || !user.getUserRole().equals(UserRole.CUSTOMER)) {
            System.out.println("Please, log on as customer");
            return;
        }

        if (termsOfReferenceBuilder == null ||
                termsOfReferenceBuilder.getTasks().size() == 0) {
            System.out.println("No tasks added to terms of reference");
            return;
        }

        tor = termsOfReferenceBuilder.createTermsOfReference();
        customerService.proposeTermsOfReference(tor);

        termsOfReferenceBuilder = null;
    }

    @Action(key = "show-tasks",
            description = "Shows added tasks")
    void showTasks() {
        if (user == null || !user.getUserRole().equals(UserRole.CUSTOMER)) {
            System.out.println("Please, log in as customer");
            return;
        }

        if (termsOfReferenceBuilder == null) {
            System.out.println("No tasks were added");
            return;
        }

        ValueWriterUtil.writeCollection(termsOfReferenceBuilder.getTasks());
    }

    @Action(key = "show-qualifications",
            description = "Shows registered qualifications")
    void showQualifications() {
        HelpService helpService = HelpService.getInstance();

        ValueWriterUtil.writeCollection(helpService.getQualifications());
    }

    @Action(key = "who-am-i",
            description = "Prints information about user")
    void whoAmI() {
        if (user == null) {
            System.out.println("Guest");
        } else {
            System.out.printf("Name\t%s%n", user.getName());
            System.out.printf("Role\t%s%n", user.getUserRole());
        }
    }

    /**
     * Initializes menu actions map with annotated methods of this class
     */
    private void initializeMenuActionsByKeyMap() {
        Method[] actions = App.class.getDeclaredMethods();

        menuActionsByKeyMap = new HashMap<String, MenuAction>();

        for (final Method actionMethod : actions) {
            if (actionMethod.isAnnotationPresent(Action.class)) {
                final Action actionAnnotation = actionMethod
                        .getAnnotation(Action.class);

                menuActionsByKeyMap.put(actionAnnotation.key(),
                        new MenuAction() {
                            public void performAction() {
                                try {
                                    actionMethod.invoke(App.this);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            }

                            public String getDescription() {
                                return actionAnnotation.description();
                            }
                        });
            }
        }
    }

    /**
     * Gets action that has to be performed after specified key entered.
     *
     * @param key a key that identifies some action to be performed
     * @return an instance of {@link MenuAction} that can be invoked or null
     * if key is not valid
     * @throws NullPointerException - if the specified key is null and this
     *                              model does not permit null keys
     */
    public MenuAction getAction(String key) {
        return menuActionsByKeyMap.get(key);
    }

    /**
     * Gets all valid keys, each of them is bound to some action
     *
     * @return a collection of keys.
     */
    public Collection<String> getKeys() {
        return menuActionsByKeyMap.keySet();
    }
}