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
    private int authorId;
    private String subject;
    private String name;
    private List<Question> questions;

    /**
     * Creates new entity of the class <b>{@code Test}</b>
     */
    public Test() {

    }

    /**
     * Creates new entity of the class <b>{@code Test}</b> and initialize it
     *
     * @param id             -id
     * @param authorId       - id of test author
     * @param subject        -test subject
     * @param name-          test name
     * @param questions-test questions
     */
    public Test(int id, int authorId, String subject, String name, List<Question> questions) {
        this.id = id;
        this.authorId = authorId;
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
     * @param id-id to set
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return author id
     */

    public int getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId -author id to set
     */

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    /**
     * @return test subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject-subject to set
     */

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return test name
     */

    public String getName() {
        return name;
    }

    /**
     * @param name-name to set
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
     * @param questions-questions to set
     */

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals()
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (id != test.id) return false;
        if (authorId != test.authorId) return false;
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
        result = 31 * result + authorId;
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
        StringBuilder sb = new StringBuilder();
        sb.append("Тест " + name).append("\n");
        for (Question question : questions) {
            sb.append(question);
        }
        sb.append("\n");
        return sb.toString();
    }
}