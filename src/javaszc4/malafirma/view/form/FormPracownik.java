package javaszc4.malafirma.view.form;

import javaszc4.malafirma.pracownicy.Pracownik;
import javaszc4.malafirma.pracownicy.PracownikManager;
import javaszc4.malafirma.view.cui.simple.SimpleFormOption;

import java.math.BigInteger;

public enum FormPracownik implements SimpleFormOption {
    IMIE("Imię"),
    NAZWISKO("Nazwisko"),
    PESEL("Pesel") {
        @Override
        public boolean isValid(String value) {
            if (!super.isValid(value)) {
                return false;
            } else if (value.length() != 11) {
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
    },
    TELEFON("Telefon") {
        @Override
        public boolean isValid(String value) {
            if (!super.isValid(value)) {
                return false;
            }
            for (int i = 0; i < value.length(); i++) {
                if (!Character.isDigit(value.charAt(i))) {
                    return false;
                }
            }
            int i = new BigInteger(value).compareTo(MAX_LONG);
            return i <= 0;
        }
    },
    ADRES("Adres"),
    STANOWISKO("Stanowisko") {
        @Override
        public boolean isValid(String value) {
            if (!super.isValid(value)) {
                return false;
            }
            if(FormPracownik.isNumeric(value)) {
                long id = Long.parseUnsignedLong(value);
                if(PracownikManager.isStanowisko(id)) {
                    return true;
                }
            }
            return PracownikManager.isStanowisko(value);
        }
    },
    DZIAL("Dział") {
        @Override
        public boolean isValid(String value) {
            if (!super.isValid(value)) {
                return false;
            }
            if(FormPracownik.isNumeric(value)) {
                long id = Long.parseUnsignedLong(value);
                if(PracownikManager.isDzial(id)) {
                    return true;
                }
            }
            return PracownikManager.isDzial(value);
        }
    };

    private final static byte[] WAGI = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};
    private final static BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);

    private final String label;

    FormPracownik(String label) {
        this.label = label;
    }

    private static boolean isNumeric(String value) {
        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public boolean isValid(String value) {
        return value != null && value.length() > 2;
    }
}
