package by.training.nc.dev5.serialization;

import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.logger.TestingSystemLogger;

import java.io.*;

public class TestSerializer {
    public boolean serialization(Test t, String filename) {
        boolean flag = false;
        File f = new File(filename);
        ObjectOutputStream ostream = null;
        try {
            FileOutputStream fos = new FileOutputStream(f);
            if (fos != null) {
                ostream = new ObjectOutputStream(fos);
                ostream.writeObject(t);
                flag = true;
            }

        } catch (FileNotFoundException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), "Файл не найден! " + e);
        } catch (NotSerializableException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), "Класс не поддерживает сериализацию " + e);
        } catch (IOException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }

            } catch (IOException e) {
                TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            }
        }
        return flag;
    }

    public Test deserialization(String fileName) throws InvalidObjectException {
        File fr = new File(fileName);
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);
            Test test = (Test) istream.readObject();
            return test;
        } catch (FileNotFoundException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), "Файл для десериализации не существует" + e);
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
