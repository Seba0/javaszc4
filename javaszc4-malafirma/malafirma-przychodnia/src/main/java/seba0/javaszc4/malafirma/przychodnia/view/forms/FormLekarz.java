package seba0.javaszc4.malafirma.przychodnia.view.forms;

import seba0.javaszc4.interfaces.cli.CLIFormInput;
import seba0.javaszc4.malafirma.utils.StringUtils;
import seba0.javaszc4.malafirma.kadry.pracownicy.PracownikManager;

public enum FormLekarz implements CLIFormInput {
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
