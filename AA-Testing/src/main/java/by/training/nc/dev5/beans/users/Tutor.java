package by.training.nc.dev5.beans.users;

/**
 * This class describes entity <b>Tutor</b>
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 */
public class Tutor extends User {
    private String subject;

    /**
     * Creates new entity of the class <b>{@code Tutor}</b>
     */
    public Tutor() {

    }

    /**
     * Creates new entity of the class <b>{@code Tutor}</b> and initialize it
     * @param id       -id
     * @param name     -name
     * @param surname  -surname
     * @param login    -login
     * @param password -password
     * @param subject  -subject
     */
    public Tutor(int id, String name, String surname, String login, String password, String subject) {
        super(id, name, surname, login, password);
        this.subject = subject;
    }

    /**
     *
     * @return tutor subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @param subject-subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    /* (non-Javadoc)
        * @see java.lang.Object#equals()
        */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Tutor tutor = (Tutor) o;

        return subject != null ? subject.equals(tutor.subject) : tutor.subject == null;

    }
    /* (non-Javadoc)
        * @see java.lang.Object#hashCode()
        */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        return result;
    }
    /* (non-Javadoc)
        * @see java.lang.Object#toString()
        */
    @Override
    public String toString() {
        return "Tutor{" +
                "subject='" + subject + '\'' +
                '}';
    }
}
