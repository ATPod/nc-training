package by.training.nc.dev5.clinic.constants;

/**
 * Created by user on 04.04.2017.
 */
public class SqlRequests {
    public static final String GET_ALL_CLIENTS = "SELECT first_name, last_name FROM users WHERE access_level = 0 ORDER BY last_name";
    public static final String GET_ALL_ACCOUNTS = "SELECT * FROM accounts";
    public static final String GET_ALL_CARDS = "SELECT * FROM cards";
    public static final String ADD_USER = "INSERT INTO user(login, password, access_level) VALUES (?, ?, ?)";
    public static final String CHECK_LOGIN = "SELECT login FROM user WHERE login = ?";
    public static final String CHECK_AUTHORIZATION = "SELECT login, password FROM user WHERE login = ? AND password = ?";
    public static final String CHECK_ACCESS_LEVEL = "SELECT access_level FROM user WHERE login = ?";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM user WHERE login = ?";
    public static final String ADD_ACCOUNT = "INSERT INTO accounts (amount, currency, status) VALUES (?, ?, ?)";
    public static final String ADD_ACCOUNT_WITH_ID = "INSERT INTO accounts (aid, amount, currency, status) VALUES (?, ?, ?, ?)";
    public static final String MAKE_ACCOUNT_OPERATION = "UPDATE accounts SET amount = (amount + ?) WHERE aid = ?";
    public static final String GET_ACCOUNT_BY_USER_ID = "SELECT * FROM accounts, users WHERE users.aid = accounts.aid AND users.uid = ?";
    public static final String GET_ACCOUNT_BY_ID = "SELECT * FROM accounts WHERE aid = ?";
    public static final String CHANGE_STATUS = "UPDATE accounts SET status = ? WHERE aid = ?";
    public static final String CHECK_ACCOUNT_STATUS = "SELECT status FROM accounts WHERE aid = ?";
    public static final String GET_BLOCKED_ACCOUNTS = "SELECT * FROM accounts WHERE status = 1";
    public static final String UNBLOCK_ACCOUNT = "UPDATE accounts SET status = 0 WHERE aid = ?";
    public static final String CREATE_OPERATION = "INSERT INTO operations (uid, aid, amount, description) VALUES (?, ?, ?, ?)";
    public static final String GET_ALL_OPERATIONS = "SELECT * FROM operations, users WHERE users.uid = operations.uid ORDER BY date";
}
