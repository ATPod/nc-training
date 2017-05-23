package by.training.nc.dev5.testing.entities.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "tutors")
public class Tutor extends User {
    @Column(name = "subject", nullable = false, length = 50)
    private String subject;
    public Tutor() {

    }
    public Tutor(int id, String name, String surname, String login, String password, String subject) {
        super(id, name, surname, login, password,"TUTOR");
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Tutor tutor = (Tutor) o;

        return subject != null ? subject.equals(tutor.subject) : tutor.subject == null;

    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Tutor{" +
                "subject='" + subject + '\'' +
                '}';
    }
}
