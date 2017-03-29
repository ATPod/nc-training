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
    public Test()
    {

    }

    public Test(int id, int authorId, String subject, String name, List<Question> questions) {
        this.id = id;
        this.authorId = authorId;
        this.subject = subject;
        this.name = name;
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

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

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + authorId;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (questions != null ? questions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", questions=" + questions +
                '}';
    }
}