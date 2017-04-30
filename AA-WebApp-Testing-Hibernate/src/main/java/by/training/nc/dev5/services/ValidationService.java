package by.training.nc.dev5.services;

public class ValidationService {
    private static ValidationService instance = null;

    private ValidationService() {
    }

    public static ValidationService getInstance() {
        if (instance == null) {
            instance = new ValidationService();
        }
        return instance;
    }

    static private final String numberPattern = "[1-9][0-9]*";
    static private final String stringPattern = "\\b[a-zA-ZА-Яа-яёЁ ]*\\b";

    public boolean isStringValid(String string) {
        return string.matches(stringPattern);
    }

    public boolean isStringNumberValid(String number) {
        return number.matches(numberPattern);
    }

}
