package by.training.nc.dev5.testing.services;

import by.training.nc.dev5.testing.dao.exceptions.DaoException;
import by.training.nc.dev5.testing.dao.interfaces.IStudentDAO;
import by.training.nc.dev5.testing.dto.StudentDTO;
import by.training.nc.dev5.testing.entities.test.Option;
import by.training.nc.dev5.testing.entities.test.Question;
import by.training.nc.dev5.testing.entities.test.Test;
import by.training.nc.dev5.testing.entities.users.Student;
import by.training.nc.dev5.testing.services.exceptions.ServiceException;
import by.training.nc.dev5.testing.services.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService extends AbstractService<Student> implements IStudentService{
    @Autowired
    IStudentDAO studentDAO;
    public StudentService(IStudentDAO studentDAO){
        super(studentDAO);
        this.studentDAO = studentDAO;
    }
    @Override
    public List<StudentDTO> getStudents() throws ServiceException
    {
        try {
            List<Student> studentList = studentDAO.getAll();
            List<StudentDTO> result = new ArrayList<StudentDTO>(studentList.size());
            StudentDTO dto;
            for (Student item:studentList){
                dto = new StudentDTO();
                dto.setFirstName(item.getName());
                dto.setLastName(item.getSurname());
                dto.setLogin(item.getLogin());
                dto.setPassword(item.getPassword());
                dto.setScores(item.getScores());
                result.add(dto);
            }
            return result;
        }
        catch(DaoException e)
        {
            throw new ServiceException("Dao error!",e);
        }
    }
    @Override
@Transactional(propagation = Propagation.SUPPORTS)
    public int passTest(Student student, Test test,
                        List<List<Integer>> questionAnswers) throws ServiceException {
        int studentResult = 0;
        List<Question> questions = test.getQuestions();
        int questionAmount = questions.size();
        for (int i = 0; i < questionAmount; i++) {
            studentResult += answeringQuestion(student, questions.get(i), questionAnswers.get(i));
        }
        student.setScores(studentResult + student.getScores());
        update(student);
        return studentResult;
    }

    private int answeringQuestion(Student student, Question question, List<Integer> answers) {
        for (Option option : question.getAnswerOptions()) {
            if (option.isRight()) {
                //если пользователь пропустил правильный вариант
                if (!answers.contains(option.getNumber())) {
                    return 0;
                }
            } else {
                if (!option.isRight()) {
                    //если выбрал неверный вариант
                    if (answers.contains(option.getNumber())) {
                        return 0;
                    }
                }

            }
        }
        student.setScores(student.getScores() + question.getScores());
        return question.getScores();

    }
}
