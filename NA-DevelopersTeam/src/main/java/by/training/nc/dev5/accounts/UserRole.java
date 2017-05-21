package by.training.nc.dev5.accounts;

import by.training.nc.dev5.entity.Customer;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.Manager;
import by.training.nc.dev5.entity.Person;

/**
 * Created by F1 on 12.04.2017.
 */
public enum UserRole {
    CUSTOMER {
        public Class<? extends Person> getEntityClass() {
            return Customer.class;
        }

        public int getRoleId() {
            return CUSTOMER_ROLE_ID;
        }
    },
    DEVELOPER {
        public Class<? extends Person> getEntityClass() {
            return Developer.class;
        }

        @Override
        public int getRoleId() {
            return DEVELOPER_ROLE_ID;
        }
    },
    MANAGER {
        public Class<? extends Person> getEntityClass() {
            return Manager.class;
        }

        @Override
        public int getRoleId() {
            return MANAGER_ROLE_ID;
        }
    };
    private static final int CUSTOMER_ROLE_ID = 1;
    private static final int MANAGER_ROLE_ID = 2;
    private static final int DEVELOPER_ROLE_ID = 3;

    public abstract Class<? extends Person> getEntityClass();

    public abstract int getRoleId();

    public static UserRole parseInt(int roleId) {
        switch (roleId) {
        case CUSTOMER_ROLE_ID:
            return CUSTOMER;
        case MANAGER_ROLE_ID:
            return MANAGER;
        case DEVELOPER_ROLE_ID:
            return DEVELOPER;
        default:
            throw new IllegalArgumentException("No role for specified role id");
        }
    }
}
