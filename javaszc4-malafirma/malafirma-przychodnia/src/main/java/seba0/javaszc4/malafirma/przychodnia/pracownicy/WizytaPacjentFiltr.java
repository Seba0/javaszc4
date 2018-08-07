package seba0.javaszc4.malafirma.przychodnia.pracownicy;

import seba0.javaszc4.malafirma.datastore.DataFilter;

import java.util.Objects;

class WizytaPacjentFiltr implements DataFilter<Wizyta> {
    private final Pacjent pacjent;

    WizytaPacjentFiltr(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    @Override
    public boolean accept(Wizyta object) {
        return Objects.equals(pacjent, object.getPacjent());
    }
}
