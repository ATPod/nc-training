package by.training.nc.dev5.testing.services.interfaces;

import by.training.nc.dev5.testing.dto.StudentDTO;
import by.training.nc.dev5.testing.entities.test.Test;
import by.training.nc.dev5.testing.entities.users.Student;
import by.training.nc.dev5.testing.services.exceptions.ServiceException;

import java.util.List;

public interface IStudentService extends IService<Student>
{
    List<StudentDTO> getStudents() throws ServiceException;
    int passTest(Student student, Test test,
                        List<List<Integer>> questionAnswers) throws ServiceException;
}
