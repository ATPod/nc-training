package by.training.nc.dev5.clinic.entities;

import javax.persistence.*;


@NamedQueries( {@NamedQuery(name = "User.getByLogin", query = "SELECT a FROM User a WHERE a.login=?1")} )
/**
 * Created by user on 25.04.2017.
 */
@Entity
public class User extends AbstractEntity{

    private String login;
    private String password;
    private String accessLevel;


    @Column(name = "Login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "AccessLevel")
    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

}
