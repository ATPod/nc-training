package by.training.nc.dev5.entity;

import java.util.Date;

/**
 * Created by Nikita on 26.03.2017.
 */
public class TimeSheet {
    private int id;
    private Date date;
    private int projectId;
    private int developerId;
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
     * Gets the value of projectId
     *
     * @return the value of projectId.
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * Sets the value of projectId
     *
     * @param projectId the new value of projectId.
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    /**
     * Gets the value of developerId
     *
     * @return the value of developerId.
     */
    public int getDeveloperId() {
        return developerId;
    }

    /**
     * Sets the value of developerId
     *
     * @param developerId the new value of developerId.
     */
    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
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
}
