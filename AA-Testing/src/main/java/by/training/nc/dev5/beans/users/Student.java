package by.training.nc.dev5.beans.users;

import by.training.nc.dev5.exceptions.StudentLogicException;

import java.io.Serializable;

/**
 * This class describes entity <b>Student</b>
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 */
public class Student extends User {
    private int balls;

    public Student() {

    }

    /**
     * Creates new entity of the class <b>{@code Student}</b> and initialize it
     *
     * @param id      - id
     * @param name    - name
     * @param surname - surname
     * @param balls   - balls
     */
    public Student(int id, String name, String surname, int balls) {
        super(id, name, surname);
        this.balls = balls;
    }

    /**
     * @return balls
     */
    public int getBalls() {
        return balls;
    }

    /**
     * @param balls - balls to set
     * @throws StudentLogicException - if balls amount is incorrect
     */
    public void setBalls(int balls) throws StudentLogicException {
        if (balls < 0) {
            throw new StudentLogicException("Balls amount is incorrect!");
        }
        this.balls = balls;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
	 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return balls == student.balls;

    }

    /* (non-Javadoc)
       * @see java.lang.Object#hashCode()
       */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + balls;
        return result;
    }

    /* (non-Javadoc)
        * @see java.lang.Object#toString()
        */
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("Student{"+"\n");
        sb.append("id: ").append(getId()).append("\n");
        sb.append("name: ").append(getName()).append("\n");
        sb.append("surname: ").append(getSurname()).append("\n");
        sb.append("balls: ").append(getBalls()).append("\n}");
        return sb.toString();
    }
}



