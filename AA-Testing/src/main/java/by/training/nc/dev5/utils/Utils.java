package by.training.nc.dev5.utils;

public class Utils {
    /**
     * Generates random number from segment [left,from]
     * @param from -left border
     * @param to-right border
     * @return random number from segment [left,from]
     */
    public static int generateNumber(int from,int to)
    {
        return ((int)(Math.random()*(to-from+1))+from);
    }
}
