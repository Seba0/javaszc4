package javaszc4.malafirma.przychodnia.view.forms;

import javaszc4.malafirma.przychodnia.pracownicy.Lekarz;
import javaszc4.malafirma.przychodnia.pracownicy.LekarzManager;
import javaszc4.malafirma.utils.StringUtils;
import javaszc4.malafirma.view.cui.simple.SimpleFormElement;

import java.math.BigInteger;

public enum FormFiltrWizyty implements SimpleFormElement {
    ID_PESEL("ID Lekarza lub PESEL Pacjenta") {
        @Override
        public boolean isValid(String value) {
            if(!StringUtils.isNumeric(value)) {
                return false;
            }
            long id = Long.parseUnsignedLong(value);
            if(StringUtils.isPESEL(value)) {
                if(LekarzManager.getPacjent(id) != null) {
                    return true;
                }
            }
            return LekarzManager.getLekarz(id) != null;
        }
    };

    private final String label;

    FormFiltrWizyty(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
