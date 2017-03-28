package by.training.nc.dev5.entity;

/**
 * Created by Nikita on 28.03.2017.
 */
public class TaskQuota {
    private int id;
    private int taskId;
    private int qualificationId;
    private int developersNumber;

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
     * Gets the value of taskId
     *
     * @return the value of taskId.
     */
    public int getTaskId() {
        return taskId;
    }

    /**
     * Sets the value of taskId
     *
     * @param taskId the new value of taskId.
     */
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    /**
     * Gets the value of qualificationId
     *
     * @return the value of qualificationId.
     */
    public int getQualificationId() {
        return qualificationId;
    }

    /**
     * Sets the value of qualificationId
     *
     * @param qualificationId the new value of qualificationId.
     */
    public void setQualificationId(int qualificationId) {
        this.qualificationId = qualificationId;
    }

    /**
     * Gets the value of developersNumber
     *
     * @return the value of developersNumber.
     */
    public int getDevelopersNumber() {
        return developersNumber;
    }

    /**
     * Sets the value of developersNumber
     *
     * @param developersNumber the new value of developersNumber.
     */
    public void setDevelopersNumber(int developersNumber) {
        this.developersNumber = developersNumber;
    }
}
