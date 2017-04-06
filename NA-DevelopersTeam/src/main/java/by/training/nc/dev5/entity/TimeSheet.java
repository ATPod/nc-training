package by.training.nc.dev5.entity;

import java.util.Date;

/**
 * Created by Nikita on 26.03.2017.
 */
public class TimeSheet {
    private int id;

    private Date date;
    private Developer developer;
    private Project project;
    private int time;
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
     * Gets the value of developer
     *
     * @return the value of developer.
     */
    public Developer getDeveloper() {
        return developer;
    }

    /**
     * Sets the value of developer
     *
     * @param developer the new value of developer.
     */
    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    /**
     * Gets the value of project
     *
     * @return the value of project.
     */
    public Project getProject() {
        return project;
    }

    /**
     * Sets the value of project
     *
     * @param project the new value of project.
     */
    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "TimeSheet{" +
                "id=" + id +
                ", date=" + date +
                ", developer=" + developer +
                ", project=" + project +
                ", time=" + time +
                '}';
    }
}
