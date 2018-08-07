package javaszc4.malafirma.przychodnia.view.forms;

import javaszc4.malafirma.pracownicy.PracownikManager;
import javaszc4.malafirma.utils.StringUtils;
import javaszc4.malafirma.view.cui.simple.SimpleFormElement;

public enum FormLekarz implements SimpleFormElement {
    ID_PRACOWNIKA("Id Pracownika") {
        @Override
        public boolean isValid(String value) {
            if(!StringUtils.isNumeric(value)) {
                return false;
            }
            long id = Long.parseUnsignedLong(value);
            return PracownikManager.getPracownik(id) != null;
        }
    };

    private final String label;

    FormLekarz(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
