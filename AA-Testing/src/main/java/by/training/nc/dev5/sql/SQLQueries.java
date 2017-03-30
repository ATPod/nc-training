package by.training.nc.dev5.sql;
public interface SQLQueries {
    String DELETE_QUESTION="DELETE FROM questions WHERE questions.id = ?";
    String DELETE_TEST="DELETE FROM tests WHERE tests.id = ?";
    String DELETE_OPTION="DELETE FROM options WHERE options.id = ?";
    String DELETE_USER="DELETE FROM users WHERE users.id = ?";

    String UPDATE_QUESTION="DELETE FROM questions WHERE questions.id = ?";
    String UPDATE_TEST="DELETE FROM tests WHERE tests.id = ?";
    String UPDATE_OPTION="DELETE FROM options WHERE options.id = ?";
    String UPDATE_USER="DELETE FROM users WHERE users.id = ?";

    String INSERT_QUESTION="INSERT INTO questions(id,text,scores,fk_test) values(?,?,?,?);";
    String INSERT_TEST="INSERT INTO tests(id,name,subject,tutor_id) values(?,?,?,?);";
    String INSERT_OPTION="INSERT INTO options(id,text,number, rightness,question_id) values(?,?,?,?,?);";
    String INSERT_USER="INSERT INTO users(id,type,login,password,name, surname,scores,subject) values(?,?,?,?,?,?);";

    String FIND_QUESTION="SELECT * FROM questions WHERE id= ? ;";
    String FIND_TEST="SELECT * FROM tests WHERE id= ? ;";
    String FIND_OPTION="SELECT * FROM options WHERE id= ? ;";
    String FIND_USER="SELECT * FROM users WHERE id= ? ;";

    String GET_ALL_QUESTIONS="SELECT * FROM questions;";
    String GET_ALL_TESTS="SELECT * FROM tests;";
    String GET_ALL_OPTIONS="SELECT * FROM options;";
    String GET_ALL_USERS="SELECT * FROM users;";
}
