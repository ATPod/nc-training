package by.training.nc.dev5.testing.utils;

import by.training.nc.dev5.testing.entities.users.Student;
import by.training.nc.dev5.testing.entities.users.Tutor;

/*
 Entities factory
 */
public class EntityBuilder {
    public static Tutor buildTutor(String firstName, String lastName, String login,
                                   String password, String subject) {
        Tutor tutor = new Tutor();
        tutor.setName(firstName);
        tutor.setSurname(lastName);
        tutor.setPassword(password);
        tutor.setLogin(login);
        tutor.setSubject(subject);
        tutor.setUserType("TUTOR");
        return tutor;
    }

    public static Student buildStudent(String firstName, String lastName, String login,
                                       String password, int scores) {
        Student student = new Student();
        student.setName(firstName);
        student.setSurname(lastName);
        student.setLogin(login);
        student.setPassword(password);
        student.setScores(scores);
        student.setUserType("STUDENT");
        return student;
    }
}
