package by.training.nc.dev5.accounts;

/**
 * Created by F1 on 12.04.2017.
 */
public enum UserRole {
    CUSTOMER {
        public int getRoleId() {
            return CUSTOMER_ROLE_ID;
        }
    },
    DEVELOPER {
        @Override
        public int getRoleId() {
            return DEVELOPER_ROLE_ID;
        }
    },
    MANAGER {
        @Override
        public int getRoleId() {
            return MANAGER_ROLE_ID;
        }
    };
    public static final int CUSTOMER_ROLE_ID = 1;
    public static final int MANAGER_ROLE_ID = 2;
    public static final int DEVELOPER_ROLE_ID = 3;

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
