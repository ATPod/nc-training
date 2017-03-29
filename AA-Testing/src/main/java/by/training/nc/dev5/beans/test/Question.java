package by.training.nc.dev5.beans.test;


import java.io.Serializable;
import java.util.List;

/**
 * This class describes entity <b>Question</b>
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 */

public class Question implements Serializable {
    private int id;
    private String text;
    private int scores;
    private List<Option> answerOptions;

    /**
     * Creates new entity of the class <b>{@code Question}</b> and initialize it
     *
     * @param id             - id
     * @param text           - question text
     * @param scores          - scores for right answer
     * @param answerOptions -variants of answer
     */

    public Question(int id, String text, int scores, List<Option> answerOptions) {
        this.id = id;
        this.text = text;
        this.scores = scores;
        this.answerOptions = answerOptions;
    }

    /**
     *
     * @return question id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id id to set
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return question text
     */

    public String getText() {
        return text;
    }

    /**
     *
     * @param text text to set
     */

    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return scores
     */
    public int getScores() {
        return scores;
    }

    /**
     *
     * @param scores scores to set
     */

    public void setScores(int scores) {
        this.scores = scores;
    }

    /**
     *
     * @return variants of question answer
     */

    public List<Option> getAnswerOptions() {
        return answerOptions;
    }

    /**
     *
     * @param answerOptions variants to set
     */

    public void setAnswerOptions(List<Option> answerOptions) {
        this.answerOptions = answerOptions;
    }
    /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (id != question.id) return false;
        if (scores != question.scores) return false;
        if (text != null ? !text.equals(question.text) : question.text != null) return false;
        return answerOptions != null ? answerOptions.equals(question.answerOptions) : question.answerOptions == null;

    }
    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + scores;
        result = 31 * result + (answerOptions != null ? answerOptions.hashCode() : 0);
        return result;
    }
    /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", scores=" + scores +
                ", answerOptions=" + answerOptions +
                '}';
    }
}
