package seba0.javaszc4.malafirma.kadry.view.form;

import seba0.javaszc4.interfaces.cli.CLIFormInput;
import seba0.javaszc4.malafirma.kadry.pracownicy.PracownikManager;
import seba0.javaszc4.malafirma.utils.PESELUtils;
import seba0.javaszc4.malafirma.utils.StringUtils;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public enum FormPracownik implements CLIFormInput {
    IMIE("Imię"),
    NAZWISKO("Nazwisko"),
    PESEL("Pesel") {
        @Override
        public boolean isValid(String value) {
            Date dataUrodzenia = PESELUtils.getDataUrodzenia(value);
            if (dataUrodzenia == null) {
                return false;
            }
            Calendar c = GregorianCalendar.getInstance();
            c.setTime(dataUrodzenia);
            c.add(Calendar.YEAR, 18);
            Date time = c.getTime();
            Date d = new Date();
            if (time.after(d)) {
                return false;
            }
            c.setTime(dataUrodzenia);
            c.add(Calendar.YEAR, -90);
            time = c.getTime();
            return time.before(d);
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
            if (StringUtils.isNumeric(value)) {
                long id = Long.parseUnsignedLong(value);
                if (PracownikManager.getStanowisko(id) != null) {
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
            if (StringUtils.isNumeric(value)) {
                long id = Long.parseUnsignedLong(value);
                if (PracownikManager.getDzial(id) != null) {
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
