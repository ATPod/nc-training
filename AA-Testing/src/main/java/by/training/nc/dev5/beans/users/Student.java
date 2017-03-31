package by.training.nc.dev5.beans.users;


/**
 * This class describes entity <b>Student</b>
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 */
public class Student extends User {
    private int scores;

    /**
     * Creates new entity of the class <b>{@code Student}</b>
     */
    public Student() {

    }

    /**
     * Creates new entity of the class <b>{@code Student}</b> and initialize it
     *
     * @param id      - id
     * @param name    - name
     * @param surname - surname
     * @param scores  - scores
     */
    public Student(int id, String name, String surname, String login, String password, int scores) {
        super(id, name, surname, login, password);
        this.scores = scores;
    }

    /**
     * @return student scores
     */
    public int getScores() {
        return scores;
    }

    /**
     * @param scores-scores to set
     */

    public void setScores(int scores) {
        this.scores = scores;
    }

    /* (non-Javadoc)
    * @see java.lang.Object#equals()
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return scores == student.scores;

    }

    /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + scores;
        return result;
    }

    /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
    @Override
    public String toString() {
        return "Student{" +
                "scores=" + scores +
                '}';
    }
}



