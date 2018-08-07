package javaszc4.malafirma.przychodnia.pracownicy;

import javaszc4.malafirma.datastore.DataFilter;
import javaszc4.malafirma.pracownicy.Pracownik;

class PacjentFiltr implements DataFilter<Pacjent> {

    private final long pesel;

    PacjentFiltr(Pacjent pacjent) {
        this.pesel = pacjent.getPesel();
    }

    PacjentFiltr(long pesel) {
        this.pesel = pesel;
    }

    @Override
    public boolean accept(Pacjent object) {
        return pesel == object.getPesel();
    }

    @Override
    public int limit() {
        return 1;
    }
}
