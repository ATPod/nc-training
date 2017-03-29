package by.training.nc.dev5.beans.test;


import java.io.Serializable;
import java.util.List;

/**
 * This class describes entity <b>Test</b>
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 */
public class Test implements Serializable {
    private int id;
    private String subject;
    private String name;
    private List<Question> questions;

    /**
     * Creates new entity of the class <b>{@code Test}</b> and initialize it
     *
     * @param id        - id
     * @param subject   - the name of subject
     * @param name      - the name of test
     * @param questions -test questions
     */

    public Test(int id, String subject, String name, List<Question> questions) {
        this.id = id;
        this.subject = subject;
        this.name = name;
        this.questions = questions;
    }

    /**
     * @return test id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return subject of test
     */

    public String getSubject() {
        return subject;
    }

    /**
     * @param subject subject to set
     */

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return name of test
     */
    public String getName() {
        return name;
    }

    /**
     * @param name name to set
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return test questions
     */

    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions questions to set
     */

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
	 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (id != test.id) return false;
        if (subject != null ? !subject.equals(test.subject) : test.subject != null) return false;
        if (name != null ? !name.equals(test.name) : test.name != null) return false;
        return questions != null ? questions.equals(test.questions) : test.questions == null;

    }

    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (questions != null ? questions.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", questions=" + questions +
                '}';
    }
}