package by.training.nc.dev5.beans.test;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Alena Artsiuschcyk on 15.03.2017.
 */
public class Test implements Serializable {
    private String authorName;
    private String authorSurname;
    private String subject;
    private String name;
    private List<Question> questions;

    public Test(String authorName, String authorSurname, String subject, String name, List<Question> questions) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.subject = subject;
        this.name = name;
        this.questions = questions;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
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

        if (!authorName.equals(test.authorName)) return false;
        if (!authorSurname.equals(test.authorSurname)) return false;
        if (!subject.equals(test.subject)) return false;
        if (!name.equals(test.name)) return false;
        return questions.equals(test.questions);

    }

    @Override
    public int hashCode() {
        int result = authorName.hashCode();
        result = 31 * result + authorSurname.hashCode();
        result = 31 * result + subject.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + questions.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Тест ");
        sb.append(name).append("\n");
        for (Question question : questions) {
            sb.append(question).append("\n");
        }
        return sb.toString();
    }
}