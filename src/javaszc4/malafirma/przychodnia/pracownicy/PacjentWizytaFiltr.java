package javaszc4.malafirma.przychodnia.pracownicy;

import javaszc4.malafirma.datastore.DataFilter;

import java.util.Date;
import java.util.Objects;

class PacjentWizytaFiltr implements DataFilter<Wizyta> {

    private final Pacjent pacjent;
    private final Date date = new Date();

    PacjentWizytaFiltr(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    @Override
    public boolean accept(Wizyta object) {
        if (object.getData().compareTo(date) <= 0) {
            return false;
        }
        return Objects.equals(pacjent, object.getPacjent());
    }

    @Override
    public int limit() {
        return 1;
    }
}
