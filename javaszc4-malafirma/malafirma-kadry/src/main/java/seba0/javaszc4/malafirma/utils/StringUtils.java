package seba0.javaszc4.malafirma.utils;

public final class StringUtils {

    private final static byte[] WAGI = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};

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

    public static boolean isPESEL(String value) {
        if (value == null || value.length() != 11) {
            return false;
        }
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            char c = value.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
            sum += (c - '0') * WAGI[i];
        }
        return sum % 10 == value.charAt(10) - '0';
    }
}
