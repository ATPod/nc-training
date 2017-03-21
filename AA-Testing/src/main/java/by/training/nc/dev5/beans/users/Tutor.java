package by.training.nc.dev5.beans.users;

/**
 * Created by NotePad.by on 15.03.2017.
 */
public class Tutor extends User {
    private String subject;

    public Tutor(int id, String name, String surname, String subject) {
        super(id, name, surname);
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

        return subject.equals(tutor.subject);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + subject.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "subject='" + subject + '\'' +
                '}';
    }
}
