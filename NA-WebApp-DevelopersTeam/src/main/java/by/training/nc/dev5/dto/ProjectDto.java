package by.training.nc.dev5.dto;

import java.util.Collection;

/**
 * Created by Nikita on 10.05.2017.
 */
public class ProjectDto {
    private int id;
    private ManagerDto manager;
    private Collection<DeveloperDto> developers;

    /**
     * Gets the value of id
     *
     * @return the value of id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of id
     *
     * @param id the new value of id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the value of manager
     *
     * @return the value of manager.
     */
    public ManagerDto getManager() {
        return manager;
    }

    /**
     * Sets the value of manager
     *
     * @param manager the new value of manager.
     */
    public void setManager(ManagerDto manager) {
        this.manager = manager;
    }

    /**
     * Gets the value of developers
     *
     * @return the value of developers.
     */
    public Collection<DeveloperDto> getDevelopers() {
        return developers;
    }

    /**
     * Sets the value of developers
     *
     * @param developers the new value of developers.
     */
    public void setDevelopers(Collection<DeveloperDto> developers) {
        this.developers = developers;
    }
}
