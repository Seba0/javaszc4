package javaszc4.malafirma.view.form;

import javaszc4.malafirma.view.cui.simple.SimpleFormOption;

public enum FormNazwaOpis implements SimpleFormOption {
    NAZWA("Nazwa"),
    OPIS("Opis");

    private final String label;

    FormNazwaOpis(String label) {
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
