package by.training.nc.dev5.testing.entities.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "students")
public class Student extends User {
    @Column(name = "scores", nullable = false)
    private int scores;
    public Student() {

    }

    public Student(int id, String name, String surname, String login, String password, int scores) {
        super(id, name, surname, login, password,"STUDENT");
        this.scores = scores;
    }

    public int getScores() {
        return scores;
    }
    public void setScores(int scores) {
        this.scores = scores;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return scores == student.scores;

    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + scores;
        return result;
    }
    @Override
    public String toString() {
        return "Student{" +
                "scores=" + scores +
                '}';
    }
}



