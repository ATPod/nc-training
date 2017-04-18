package by.training.nc.dev5.service;

/**
 * Authentication stub/mock service.
 */
public class AuthenticationService {
    public static final String AUTHENTICATED_USER_NAME="admin";
    public static final String AUTHENTICATED_USER_PASSWORD="admin";
    public boolean isUserFound(String username, String password) {
        return((AUTHENTICATED_USER_NAME.equalsIgnoreCase(username))
                && (AUTHENTICATED_USER_PASSWORD.equals(password)));
    }
}
