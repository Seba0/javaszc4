package seba0.javaszc4.malafirma.przychodnia.view.forms;

import java.math.BigInteger;
import seba0.javaszc4.interfaces.cli.SimpleFormElement;
import seba0.javaszc4.malafirma.przychodnia.pracownicy.LekarzManager;
import seba0.javaszc4.malafirma.utils.StringUtils;

public enum FormPacjent implements SimpleFormElement {
    IMIE("Imię"),
    NAZWISKO("Nazwisko"),
    PESEL("Pesel") {
        @Override
        public boolean isValid(String value) {
            return StringUtils.isPESEL(value);
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
    ID_LEKARZA("Id Lekarza") {
        @Override
        public boolean isValid(String value) {
            if (!StringUtils.isNumeric(value)) {
                return false;
            }
            long id = Long.parseUnsignedLong(value);
            return LekarzManager.getLekarz(id) != null;
        }
    };

    private final static BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);

    private final String label;

    FormPacjent(String label) {
        this.label = label;
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
