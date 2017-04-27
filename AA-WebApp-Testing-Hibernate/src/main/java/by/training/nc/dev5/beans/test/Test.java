package by.training.nc.dev5.beans.test;

import by.training.nc.dev5.beans.users.Tutor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private int id;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "tutor_id", nullable = false)
    private Tutor author;
    @Column(name = "subject", nullable = false, length = 1000)
    private String subject;
    @Column(name = "name", nullable = false, length = 1000)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, targetEntity = Question.class)
    @JoinTable(
            name = "tests_questions",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<Question> questions;

    public Test() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tutor getAuthor() {
        return author;
    }

    public void setAuthor(Tutor author) {
        this.author = author;
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
        if (author != null ? !author.equals(test.author) : test.author != null) return false;
        if (subject != null ? !subject.equals(test.subject) : test.subject != null) return false;
        if (name != null ? !name.equals(test.name) : test.name != null) return false;
        return questions != null ? questions.equals(test.questions) : test.questions == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (questions != null ? questions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", author=" + author +
                ", subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", questions=" + questions +
                '}';
    }
}