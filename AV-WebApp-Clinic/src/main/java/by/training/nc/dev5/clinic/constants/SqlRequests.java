package by.training.nc.dev5.clinic.constants;

/**
 * Created by user on 04.04.2017.
 */
public class SqlRequests {
    public static final String ADD_USER = "INSERT INTO user(login, password, access_level) VALUES (?, ?, ?)";
    public static final String CHECK_LOGIN = "SELECT login FROM user WHERE login = ?";
    public static final String CHECK_AUTHORIZATION = "SELECT login, password FROM user WHERE login = ? AND password = ?";
    public static final String CHECK_ACCESS_LEVEL = "SELECT access_level FROM user WHERE login = ?";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM user WHERE login = ?";

    public static final String GET_ALL_PATIENTS = "SELECT * FROM patient ORDER BY name";
    public static final String GET_PATIENT_BY_ID = "SELECT * FROM patient WHERE id=?";
    public static final String CHECK_PATIENT_NAME = "SELECT name FROM patient WHERE name = ?";
    public static final String ADD_PATIENT = "INSERT INTO patient(name) VALUES (?)";
    public static final String DELETE_PATIENT ="DELETE FROM patient WHERE id=?";

    public static final String GET_DIAGNOSISES_BY_PATIENT = "SELECT * FROM diagnosis WHERE patientid=?";
    public static final String ADD_DIAGNOSIS = "INSERT INTO diagnosis (name, patientId) VALUES(?, ?)";
    public static final String DELETE_DIAGNOSIS = "DELETE FROM diagnosis WHERE id=?";

    public static final String GET_DRUGS_BY_PATIENT = "SELECT * FROM drug WHERE patientid=?";
    public static final String ADD_DRUG = "INSERT INTO drug (name, patientId) VALUES(?, ?)";
    public static final String DELETE_DRUG = "DELETE FROM drug WHERE id=?";

    public static final String GET_PROCEDURES_BY_PATIENT = "SELECT * FROM `procedure` WHERE patientid=?";
    public static final String ADD_PROCEDURE = "INSERT INTO `procedure` (name, patientId) VALUES(?, ?)";
    public static final String DELETE_PROCEDURE = "DELETE FROM `procedure` WHERE id=?";

    public static final String GET_SURGERIES_BY_PATIENT = "SELECT * FROM surgery WHERE patientid=?";
    public static final String ADD_SURGERY = "INSERT INTO surgery (name, patientId) VALUES(?, ?)";
    public static final String DELETE_SURGERY = "DELETE FROM surgery WHERE id=?";



}
