package by.training.nc.dev5.beans.test;


import java.io.Serializable;
import java.util.List;

/**
 * This class describes entity <b>Test</b>
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 */
public class Test implements Serializable {
    private String authorName;
    private String authorSurname;
    private String subject;
    private String name;
    private List<Question> questions;

    /**
     * Creates new entity of the class <b>{@code Test}</b> and initialize it
     *
     * @param authorName    -name of author
     * @param authorSurname - surname of author
     * @param subject       - subject of test
     * @param questions     -list of questions
     * @param name          -name of test
     */

    public Test(String authorName, String authorSurname, String subject, String name, List<Question> questions) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.subject = subject;
        this.name = name;
        this.questions = questions;
    }

    /**
     * @return name of author
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName - name of author to set
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * @return surname of author
     */
    public String getAuthorSurname() {
        return authorSurname;
    }

    /**
     * @param authorSurname name of author to set
     */
    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    /**
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject - subject to set
     */

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return - name of test
     */
    public String getName() {
        return name;
    }

    /**
     * @param name - name to set
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return questions of test
     */

    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions - questions to set
     */

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /* (non-Javadoc)
         * @see java.lang.Object#equals(java.lang.Object)
         */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (!authorName.equals(test.authorName)) return false;
        if (!authorSurname.equals(test.authorSurname)) return false;
        if (!subject.equals(test.subject)) return false;
        return name.equals(test.name) && questions.equals(test.questions);

    }

    /* (non-Javadoc)
      * @see java.lang.Object#hashCode()
      */
    @Override
    public int hashCode() {
        int result = authorName.hashCode();
        result = 31 * result + authorSurname.hashCode();
        result = 31 * result + subject.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + questions.hashCode();
        return result;
    }

    /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Тест ");
        sb.append(name).append("\n");
        for (Question question : questions) {
            sb.append(question).append("\n");
        }
        return sb.toString();
    }
}