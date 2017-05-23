package by.training.nc.dev5.testing.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Data transfer object TestDTO
 */
public class TestDTO {
    @Size(min = 2, max = 20, message = "{test.name.size.error}")
    @Pattern(regexp = "(\\b[a-zA-Zа-яА-Я]+ *)+", message = "{test.name.format.error}")
    @NotNull(message = "{test.name.fill.error}")
    private String testName;
    @Size(min = 2, max = 10, message = "Question amount should be between 2 and 10 characters long")
    @Pattern(regexp = "^[0-9]+$", message = "Question amount should be numeric with no spaces")
    @NotNull(message = "Question amount cannot be empty")
    private int questionAmount;
    @Size(min = 2, max = 10, message = "Option amount should be between 2 and 10 characters long")
    @Pattern(regexp = "^[0-9]+$", message = "Option amount should be numeric with no spaces")
    @NotNull(message = "Option amount cannot be empty")
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
