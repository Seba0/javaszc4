package seba0.javaszc4.malafirma.utils;

public final class StringUtils {

    private StringUtils() {
    }

    public static boolean isNumeric(String value) {
        if(value == null || value.isEmpty()) {
            return false;
        }
        value = value.trim();
        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
