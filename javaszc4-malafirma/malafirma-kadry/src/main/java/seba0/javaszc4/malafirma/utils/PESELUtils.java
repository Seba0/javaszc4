package seba0.javaszc4.malafirma.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class PESELUtils {

    private PESELUtils() {

    }

    private final static byte[] WAGI = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};

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

    public static Date getDataUrodzenia(String pesel) {
        if (!isPESEL(pesel)) {
            return null;
        }
        int rok = Integer.parseInt(pesel.substring(0, 2));
        int miesiac = Integer.parseInt(pesel.substring(2, 4));
        int dzien = Integer.parseInt(pesel.substring(4, 6));
        if (miesiac > 80) {
            miesiac -= 80;
            rok += 1800;
        } else if (miesiac > 60) {
            miesiac -= 60;
            rok += 2200;
        } else if (miesiac > 40) {
            miesiac -= 40;
            rok += 2100;
        } else if (miesiac > 20) {
            miesiac -= 20;
            rok += 2000;
        } else {
            rok += 1900;
        }
        Calendar c = GregorianCalendar.getInstance();
        c.set(rok, miesiac - 1, dzien);
        return c.getTime();
    }
}
