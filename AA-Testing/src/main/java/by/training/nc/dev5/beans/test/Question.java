package by.training.nc.dev5.beans.test;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Alena Artsiuschcyk on 15.03.2017.
 */
public class Question implements Serializable {
    private String text;
    private int balls;
    private Map<Integer, String> variants;
    private List<Integer> rightAnswersNumbers;

    public Question(String text, int balls, Map<Integer, String> variants, List<Integer> rightAnswersNumbers) {
        this.text = text;
        this.balls = balls;
        this.variants = variants;
        this.rightAnswersNumbers = rightAnswersNumbers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public Map<Integer, String> getVariants() {
        return variants;
    }

    public void setVariants(Map<Integer, String> variants) {
        this.variants = variants;
    }

    public List<Integer> getRightAnswersNumbers() {
        return rightAnswersNumbers;
    }

    public void setRightAnswersNumbers(List<Integer> rightAnswersNumbers) {
        this.rightAnswersNumbers = rightAnswersNumbers;
    }

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

    @Override
    public int hashCode() {
        int result = text.hashCode();
        result = 31 * result + balls;
        result = 31 * result + variants.hashCode();
        result = 31 * result + rightAnswersNumbers.hashCode();
        return result;
    }

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
