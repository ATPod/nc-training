package by.training.nc.dev5.cli.util;

import java.util.Collection;

/**
 * Created by F1 on 05.04.2017.
 */
public class ValueWriterUtil {
    public static void writeCollection(Collection collection) {
        for (Object o : collection) {
            System.out.println(o);
        }
    }
}
