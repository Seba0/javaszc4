package seba0.javaszc4.malafirma.kadry.view.form;

import seba0.javaszc4.interfaces.cli.CLIFormInput;
import seba0.javaszc4.malafirma.kadry.pracownicy.PracownikManager;
import seba0.javaszc4.malafirma.utils.StringUtils;

public enum FormStanowisko implements CLIFormInput {
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
