package seba0.javaszc4.malafirma.kadry.view.form;

import seba0.javaszc4.interfaces.cli.SimpleFormElement;
import seba0.javaszc4.malafirma.kadry.pracownicy.PracownikManager;
import seba0.javaszc4.malafirma.utils.StringUtils;

import java.math.BigInteger;

public enum FormPracownik implements SimpleFormElement {
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
    STANOWISKO("Stanowisko") {
        @Override
        public boolean isValid(String value) {
            if (!super.isValid(value)) {
                return false;
            }
            if(StringUtils.isNumeric(value)) {
                long id = Long.parseUnsignedLong(value);
                if(PracownikManager.getStanowisko(id) != null) {
                    return true;
                }
            }
            return PracownikManager.getStanowisko(value) != null;
        }
    },
    DZIAL("Dział") {
        @Override
        public boolean isValid(String value) {
            if (!super.isValid(value)) {
                return false;
            }
            if(StringUtils.isNumeric(value)) {
                long id = Long.parseUnsignedLong(value);
                if(PracownikManager.getDzial(id) != null) {
                    return true;
                }
            }
            return PracownikManager.getDzial(value) != null;
        }
    };

    private final static BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);

    private final String label;

    FormPracownik(String label) {
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
