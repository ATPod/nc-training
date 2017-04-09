package by.training.nc.dev5.tools;

import java.io.File;
/**
 * Initializing options
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 */

public class InitializationManager {

    /**
     * @param fileName name of file
     * @return path of file with fileName name
     */
    public static String getTextFilePath(String fileName) {
        StringBuilder path = new StringBuilder();
        path.append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("AA-Testing")
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append("main")
                .append(File.separator)
                .append("java")
                .append(File.separator)
                .append("by")
                .append(File.separator)
                .append("training")
                .append(File.separator)
                .append("nc")
                .append(File.separator)
                .append("dev5")
                .append(File.separator)
                .append("files")
                .append(File.separator)
                .append("input")
                .append(File.separator)
                .append(fileName);
        return path.toString();
    }
    /**
     * @param fileName file to write
     */

    public static void saveToFile(String fileName) {

    }

}
