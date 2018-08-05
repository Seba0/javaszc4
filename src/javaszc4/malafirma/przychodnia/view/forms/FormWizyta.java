package javaszc4.malafirma.przychodnia.view.forms;

import javaszc4.malafirma.przychodnia.pracownicy.LekarzManager;
import javaszc4.malafirma.utils.StringUtils;
import javaszc4.malafirma.view.cui.simple.SimpleFormElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum FormWizyta implements SimpleFormElement {
    ID_LEKARZA("Id Lekarza") {
        @Override
        public boolean isValid(String value) {
            if (!StringUtils.isNumeric(value)) {
                return false;
            }
            long id = Long.parseUnsignedLong(value);
            return LekarzManager.getLekarz(id) != null;
        }
    },
    PESEL_PACJENTA("PESEL Pacjenta") {
        @Override
        public boolean isValid(String value) {
            if (!StringUtils.isPESEL(value)) {
                return false;
            }
            long id = Long.parseUnsignedLong(value);
            return LekarzManager.getPacjent(id) != null;
        }
    },
    DATA_WIZYTY("Data wzyty [YY-MM-DD HH:MM]") {
        @Override
        public boolean isValid(String value) {
            if (!super.isValid(value)) {
                return false;
            }
            try {
                return FORMAT.parse(value).compareTo(new Date()) > 0;
            } catch (Throwable t) {
                return false;
            }
        }
    };

    private static final DateFormat FORMAT = new SimpleDateFormat("yy-MM-dd HH:mm");

    private final String label;

    FormWizyta(String label) {
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
