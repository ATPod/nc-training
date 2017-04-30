package by.training.nc.dev5.entity;

import by.training.nc.dev5.accounts.UserRole;

/**
 * Created by Nikita on 26.03.2017.
 */
public class Manager extends Person {
    public Manager() {
        setUserRole(UserRole.MANAGER);
    }
}
