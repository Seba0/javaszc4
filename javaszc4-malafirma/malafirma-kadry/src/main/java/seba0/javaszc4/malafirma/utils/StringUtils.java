package seba0.javaszc4.malafirma.utils;

public final class StringUtils {

    private StringUtils() {
    }

    public static boolean isNumeric(String value) {
        if (value == null) {
            return false;
        }
        value = value.trim();
        if (value.isEmpty()) {
            return false;
        }
        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
