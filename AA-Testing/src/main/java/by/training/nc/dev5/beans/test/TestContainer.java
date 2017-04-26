package by.training.nc.dev5.beans.test;

import java.util.ArrayList;
import java.util.List;

/**
 * This class describes entity <b>TestContainer</b>
 * that contains all tests of testing system and represents operations
 * with them
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 */
//Singleton
public enum TestContainer {
    INSTANCE;
    private List<Test> tests = new ArrayList<>();

    /**
     * @return tests
     */
    public List<Test> getTests() {
        return tests;
    }

    /**
     * @param tests - tests to set
     */

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public void addTest(Test test) {
        INSTANCE.tests.add(test);
    }

    /**
     * Get test from TestContainer
     *
     * @param testName - name of test
     * @return test
     */
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
        StringBuilder sb = new StringBuilder("Все тесты: " + "\n\n");
        for (Test test : tests) {
            sb.append(test);
        }
        return sb.toString();
    }
}
