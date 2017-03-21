package by.training.nc.dev5.beans.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NotePad.by on 16.03.2017.
 */
public class TestContainer {
    private List<Test> tests = new ArrayList<>();

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public void addTest(Test test) {
        tests.add(test);
    }

    public Test getTest(String testName) {
        for (Test test : tests) {
            if (test.getName().equalsIgnoreCase(testName)) {
                return test;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Все тесты: ").append("\n");
        for (Test test : tests) {
            sb.append(test);
        }
        return sb.toString();
    }
}
