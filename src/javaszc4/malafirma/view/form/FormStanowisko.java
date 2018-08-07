package javaszc4.malafirma.view.form;

import javaszc4.malafirma.pracownicy.PracownikManager;
import javaszc4.malafirma.utils.StringUtils;
import javaszc4.malafirma.view.cui.simple.SimpleFormElement;

public enum FormStanowisko implements SimpleFormElement {
    NAZWA("Nazwa") {
        @Override
        public boolean isValid(String value) {
            if(!super.isValid(value) || StringUtils.isNumeric(value)) {
                return false;
            }
            return PracownikManager.getStanowisko(value.trim()) == null;
        }
    },
    OPIS("Opis");

    private final String label;

    FormStanowisko(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public boolean isValid(String value) {
        return value != null && value.length() > 3;
    }
}
