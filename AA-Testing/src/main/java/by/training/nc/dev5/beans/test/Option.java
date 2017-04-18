package by.training.nc.dev5.beans.test;

/**
 * This class describes entity <b>Option</b>
 * that represents possible question answer
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 */
public class Option {
    private int id;
    private int questionId;
    private String text;
    private int number;
    private boolean rightness;

    /**
     * Creates new entity of the class <b>{@code Option}</b>
     */
    public Option() {

    }

    /**
     * Creates new entity of the class <b>{@code Option}</b> and initialize it
     *
     * @param id         - option id
     * @param questionId - id of question that contains this option
     * @param text       - text of option
     * @param number     - number of option in the current question
     * @param rightness  - indicates rightness of this option for current question
     */
    public Option(int id, int questionId, String text, int number, boolean rightness) {
        this.id = id;
        this.questionId = questionId;
        this.text = text;
        this.number = number;
        this.rightness = rightness;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id -id to set
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return id of question that contains this option
     */

    public int getQuestionId() {
        return questionId;
    }

    /**
     * @param questionId -id to set
     */

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * @return option text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text -text to set
     */

    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return option number in the current question
     */

    public int getNumber() {
        return number;
    }

    /**
     * @param number-number to set
     */

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return rightness of option for current question
     */

    public boolean isRightness() {
        return rightness;
    }

    /**
     * @param rightness -rightness to set
     */

    public void setRightness(boolean rightness) {
        this.rightness = rightness;
    }

    /* (non-Javadoc)
       * @see java.lang.Object#equals()
       */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Option option = (Option) o;

        if (id != option.id) return false;
        if (questionId != option.questionId) return false;
        if (number != option.number) return false;
        if (rightness != option.rightness) return false;
        return text != null ? text.equals(option.text) : option.text == null;

    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + questionId;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + (rightness ? 1 : 0);
        return result;
    }

    /* (non-Javadoc)
       * @see java.lang.Object#toString()
       */
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(number).append(".").append(" ").append(text);
        sb.append("\n");
        return sb.toString();
    }
}
