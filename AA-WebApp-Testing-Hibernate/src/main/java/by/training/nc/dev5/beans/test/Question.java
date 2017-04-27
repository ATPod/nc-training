package by.training.nc.dev5.beans.test;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int id;
    @Column(name = "text", nullable = false, length = 1000)
    private String text;
    @Column(name = "scores", nullable = false)
    private int scores;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "questions_options",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "option_id"))
    private List<Option> answerOptions;

    public Question() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public List<Option> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<Option> answerOptions) {
        this.answerOptions = answerOptions;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (id != question.id) return false;
        if (scores != question.scores) return false;
        if (text != null ? !text.equals(question.text) : question.text != null) return false;
        return answerOptions != null ? answerOptions.equals(question.answerOptions) : question.answerOptions == null;

    }*/

   /* @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + scores;
        result = 31 * result + (answerOptions != null ? answerOptions.hashCode() : 0);
        return result;
    }*/

    /*@Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", scores=" + scores +
                ", answerOptions=" + answerOptions +
                '}';
    }*/
}
