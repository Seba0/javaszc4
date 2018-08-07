package seba0.javaszc4.malafirma.kadry.pracownicy;

import seba0.javaszc4.malafirma.datastore.DataFilter;

import java.util.Objects;

class PracownikStanowiskoFiltr implements DataFilter<Pracownik> {

    private final Stanowisko stanowisko;

    PracownikStanowiskoFiltr(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }

    @Override
    public boolean accept(Pracownik object) {
        return Objects.equals(stanowisko, object.getStanowisko());
    }

    @Override
    public int limit() {
        return 1;
    }
}
