package seba0.javaszc4.malafirma.przychodnia.pracownicy;

import seba0.javaszc4.malafirma.datastore.DataFilter;

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
