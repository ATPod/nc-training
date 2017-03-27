package by.training.nc.dev5.beans.test;


import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 * This class describes entity <b>Question</b>
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 */
public class Question implements Serializable {
    private String text;
    private int balls;
    private Map<Integer, String> variants;
    private List<Integer> rightAnswersNumbers;
    /**
     * Creates new entity of the class <b>{@code Question}</b> and initialize it
     *
     * @param text      -text of question
     * @param balls    - balls if the answer is right
     * @param variants -variants of answer with their numbers
     * @param rightAnswersNumbers  -numbers of right answers
     */

    public Question(String text, int balls, Map<Integer, String> variants, List<Integer> rightAnswersNumbers) {
        this.text = text;
        this.balls = balls;
        this.variants = variants;
        this.rightAnswersNumbers = rightAnswersNumbers;
    }

    /**
     *
     * @return text of question
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text - text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return balls
     */
    public int getBalls() {
        return balls;
    }

    /**
     *
     * @param balls - balls to set
     */
    public void setBalls(int balls) {
        this.balls = balls;
    }

    /**
     *
     * @return variants
     */
    public Map<Integer, String> getVariants() {
        return variants;
    }

    /**
     *
     * @param variants - variants to set
     */

    public void setVariants(Map<Integer, String> variants) {
        this.variants = variants;
    }

    /**
     *
     * @return - list of right answers numbers
     */
    public List<Integer> getRightAnswersNumbers() {
        return rightAnswersNumbers;
    }

    /**
     *
     * @param rightAnswersNumbers -right answers to set
     */
    public void setRightAnswersNumbers(List<Integer> rightAnswersNumbers) {
        this.rightAnswersNumbers = rightAnswersNumbers;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
	 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (balls != question.balls) return false;
        if (!text.equals(question.text)) return false;
        if (!variants.equals(question.variants)) return false;
        return rightAnswersNumbers.equals(question.rightAnswersNumbers);

    }
    /* (non-Javadoc)
      * @see java.lang.Object#hashCode()
      */
    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + balls;
        result = 31 * result + variants.hashCode();
        result = 31 * result + rightAnswersNumbers.hashCode();
        return result;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Вопрос: ").append(text).append(" ");
        sb.append(balls).append("балла(ов)").append(System.lineSeparator());
        for (int i = 0; i < variants.size(); i++) {
            sb.append(i + 1).append(". ").append(variants.get(i + 1)).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
