package by.training.nc.dev5.entity;

import javax.persistence.*;

/**
 * Created by Nikita on 28.03.2017.
 */
@Entity
@Table(name = "task_quota")
public class TaskQuota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "developers_number")
    private int developersNumber;
    @ManyToOne
    @JoinColumn(name = "qualification_id")
    private Qualification qualification;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

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

    /**
     * Gets the value of qualification
     *
     * @return the value of qualification.
     */
    public Qualification getQualification() {
        return qualification;
    }

    /**
     * Sets the value of qualification
     *
     * @param qualification the new value of qualification.
     */
    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    /**
     * Gets the value of task
     *
     * @return the value of task.
     */
    public Task getTask() {
        return task;
    }

    /**
     * Sets the value of task
     *
     * @param task the new value of task.
     */
    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "TaskQuota{" +
                "id=" + id +
                ", developersNumber=" + developersNumber +
                ", qualification=" + qualification +
                ", task=" + task +
                '}';
    }
}
