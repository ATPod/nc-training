package by.training.nc.dev5.entity;

import by.training.nc.dev5.accounts.UserRole;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by Nikita on 26.03.2017.
 */
@Entity
@Table(name = "manager")
@DiscriminatorValue("" + UserRole.MANAGER_ROLE_ID)
public class Manager extends Person {
    @OneToMany(mappedBy = "manager")
    private Collection<Project> projects;

    public Manager() {
        setUserRole(UserRole.MANAGER);
    }

    /**
     * Gets the value of projects
     *
     * @return the value of projects.
     */
    public Collection<Project> getProjects() {
        return projects;
    }

    /**
     * Sets the value of projects
     *
     * @param projects the new value of projects.
     */
    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }
}
