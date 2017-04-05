package by.training.nc.dev5.beans.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class describes entity <b>TestContainer</b>
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 */

public class TestContainer implements Serializable{
    private List<Test> tests = new ArrayList<>();

    /**
     *
     * @return tests
     */
    public List<Test> getTests() {
        return tests;
    }

    /**
     *
     * @param tests - tests to set
     */

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public void addTest(Test test) {
        tests.add(test);
    }

    /**
     * Get test from TestContainer
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
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
	 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestContainer that = (TestContainer) o;

        return tests != null ? tests.equals(that.tests) : that.tests == null;

    }

    /* (non-Javadoc)
      * @see java.lang.Object#hashCode()
      */
    @Override
    public int hashCode() {
        return tests != null ? tests.hashCode() : 0;
    }

    /* (non-Javadoc)
        * @see java.lang.Object#toString()
        */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Все тесты: ").append("\n");
        for (Test test : tests) {
            sb.append(test);
        }
        return sb.toString();
    }
}
