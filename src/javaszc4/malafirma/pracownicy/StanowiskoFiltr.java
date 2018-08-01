package javaszc4.malafirma.pracownicy;

import javaszc4.malafirma.datastore.DataFilter;

import java.util.Objects;

class StanowiskoFiltr implements DataFilter<Stanowisko> {

    private final Stanowisko stanowisko;

    StanowiskoFiltr(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }

    @Override
    public boolean accept(Stanowisko object) {
        return Objects.equals(stanowisko.getNazwa(), object.getNazwa());
    }

    @Override
    public int limit() {
        return 1;
    }
}
