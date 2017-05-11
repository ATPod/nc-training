package by.training.nc.dev5.dto;

import java.util.Date;

/**
 * Created by Nikita on 10.05.2017.
 */
public class TimeSheetDto {
    private int id;
    private int time;
    private Date date;
    private ProjectDto project;
    private DeveloperDto developer;

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
     * Gets the value of time
     *
     * @return the value of time.
     */
    public int getTime() {
        return time;
    }

    /**
     * Sets the value of time
     *
     * @param time the new value of time.
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Gets the value of date
     *
     * @return the value of date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the value of date
     *
     * @param date the new value of date.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the value of project
     *
     * @return the value of project.
     */
    public ProjectDto getProject() {
        return project;
    }

    /**
     * Sets the value of project
     *
     * @param project the new value of project.
     */
    public void setProject(ProjectDto project) {
        this.project = project;
    }

    /**
     * Gets the value of developer
     *
     * @return the value of developer.
     */
    public DeveloperDto getDeveloper() {
        return developer;
    }

    /**
     * Sets the value of developer
     *
     * @param developer the new value of developer.
     */
    public void setDeveloper(DeveloperDto developer) {
        this.developer = developer;
    }
}
