package by.training.nc.dev5.serialization;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.logger.TestingSystemLogger;

import java.io.*;

public class QuestionSerializer {
    public boolean serialization(Question q, String filename) {
        boolean flag = false;
        File f = new File(filename);
        ObjectOutputStream ostream = null;
        try {
            FileOutputStream fos = new FileOutputStream(f);
            if (fos != null) {
                ostream = new ObjectOutputStream(fos);
                ostream.writeObject(q);
                flag = true;
            }

        } catch (FileNotFoundException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), "Файл не найден!");
        } catch (NotSerializableException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), "Класс не поддерживают сериализацию!");
        } catch (IOException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), "Ошибка ввода-вывода!");
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }

            } catch (IOException e) {
                TestingSystemLogger.INSTANCE.logError(getClass(), "Ошибка закрытия потока!");
            }
        }
        return flag;
    }

    public Question deserialization(String fileName) throws InvalidObjectException {
        File fr = new File(fileName);
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);
            Question question = (Question) istream.readObject();
            return question;
        } catch (FileNotFoundException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), "Файл для десериализации не существует");
        } catch (IOException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), "I/O ошибка: " + e);
        } catch (ClassNotFoundException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        } finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } catch (IOException e) {
                TestingSystemLogger.INSTANCE.logError(getClass(), "ошибка закрытия потока ");
            }
        }
        throw new InvalidObjectException("объект не восстановлен!");
    }
}
