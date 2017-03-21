package by.training.nc.dev5.beans.users;

import by.training.nc.dev5.exceptions.StudentLogicException;

import java.io.Serializable;

/**
 * Created by NotePad.by on 15.03.2017.
 */
public class Student extends User {
    private int balls;

    public Student(int id, String name, String surname, int balls) {
        super(id, name, surname);
        this.balls = balls;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) throws StudentLogicException {
        if (balls < 0) {
            throw new StudentLogicException("Balls amount is incorrect!");
        }
        this.balls = balls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return balls == student.balls;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + balls;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "balls=" + balls +
                '}';
    }
}



