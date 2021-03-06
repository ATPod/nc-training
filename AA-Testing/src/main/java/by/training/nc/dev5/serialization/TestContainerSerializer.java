package by.training.nc.dev5.serialization;

import by.training.nc.dev5.beans.test.TestContainer;
import by.training.nc.dev5.logger.TestingSystemLogger;

import java.io.*;

public class TestContainerSerializer {
    public boolean serialization(TestContainer tc, String filename) {
        boolean flag = false;
        File f = new File(filename);
        ObjectOutputStream ostream = null;
        try {
            FileOutputStream fos = new FileOutputStream(f);
            if (fos != null) {
                ostream = new ObjectOutputStream(fos);
                ostream.writeObject(tc);
                flag = true;
            }

        } catch (FileNotFoundException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),"Файл не найден! " + e);
        } catch (NotSerializableException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),"Класс не поддерживает сериализацию " + e);
        } catch (IOException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
        } finally {
            try {
                if (ostream != null) {
                    ostream.close();
                }

            } catch (IOException e) {
                TestingSystemLogger.INSTANCE.logError(getClass(),"ошибка закрытия потока");
            }
        }
        return flag;
    }

    public TestContainer deserialization(String fileName) throws InvalidObjectException {
        File fr = new File(fileName);
        ObjectInputStream istream = null;
        try {
            FileInputStream fis = new FileInputStream(fr);
            istream = new ObjectInputStream(fis);
            TestContainer testContainer = (TestContainer) istream.readObject();
            return testContainer;
        } catch (FileNotFoundException e) {
            System.out.println("Файл для десериализации не существует" + e);
        } catch (IOException e) {
            System.out.println("I/O ошибка: " + e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } catch (IOException e) {
                TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
            }
        }
        throw new InvalidObjectException("объект не восстановлен!");
    }
}
