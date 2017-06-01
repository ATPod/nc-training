package by.training.nc.dev5.testing.dto;

/**
 * Data transfer object TestDTO
 */
public class TestDTO {
    private String testName;
    private int questionAmount;
    private int optionAmount;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getQuestionAmount() {
        return questionAmount;
    }

    public void setQuestionAmount(int questionAmount) {
        this.questionAmount = questionAmount;
    }

    public int getOptionAmount() {
        return optionAmount;
    }

    public void setOptionAmount(int optionAmount) {
        this.optionAmount = optionAmount;
    }
}
