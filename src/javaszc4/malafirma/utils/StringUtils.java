package javaszc4.malafirma.utils;

public final class StringUtils {
    private StringUtils() {
    }

    public static boolean isNumeric(String value) {
        value = value.trim();
        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
