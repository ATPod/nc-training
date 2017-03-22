package by.training.nc.dev5.tools;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by user on 17.03.2017.
 * Logger of application
 *
 * @author varchenko
 * @version 1.0
 *
 */
public final class Logger {
    public static String logFileRoot = "src"
            + File.separator
            + "main"
            + File.separator
            + "java"
            + File.separator
            + "by"
            + File.separator
            + "training"
            + File.separator
            + "nc"
            + File.separator
            + "dev5"
            + File.separator
            + "logs"
            + File.separator
            + "log.txt";


    /**
     * Writes log in file
     * @param exception - the entity of Throwable
     */
    public static void log(final Throwable exception){
        final StringWriter errors = new StringWriter();
        exception.printStackTrace(new PrintWriter(errors));

        try{
            PrintWriter printwriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(logFileRoot), true)));
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            printwriter.println(sdf.format(Calendar.getInstance().getTime()));
            printwriter.println(exception.getMessage());
            printwriter.println(errors.toString());
        } catch (IOException e) {
            Logger.log(e);
        }
    }

}
