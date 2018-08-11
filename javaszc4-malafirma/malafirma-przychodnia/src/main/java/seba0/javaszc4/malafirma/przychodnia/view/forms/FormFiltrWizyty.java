package seba0.javaszc4.malafirma.przychodnia.view.forms;

import seba0.javaszc4.interfaces.cli.CLIFormInput;
import seba0.javaszc4.malafirma.utils.StringUtils;
import seba0.javaszc4.malafirma.przychodnia.pracownicy.LekarzManager;
import seba0.javaszc4.malafirma.utils.PESELUtils;

public enum FormFiltrWizyty implements CLIFormInput {
    ID_PESEL("ID Lekarza lub PESEL Pacjenta") {
        @Override
        public boolean isValid(String value) {
            if (!StringUtils.isNumeric(value)) {
                return false;
            }
            long id = Long.parseUnsignedLong(value);
            if (PESELUtils.isPESEL(value)) {
                if (LekarzManager.getPacjent(id) != null) {
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
