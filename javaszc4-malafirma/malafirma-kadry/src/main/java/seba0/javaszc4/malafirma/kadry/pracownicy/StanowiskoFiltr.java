package seba0.javaszc4.malafirma.kadry.pracownicy;

import seba0.javaszc4.malafirma.datastore.DataFilter;

import java.util.Objects;

class StanowiskoFiltr implements DataFilter<Stanowisko> {

    private final String nazwa;

    StanowiskoFiltr(Stanowisko stanowisko) {
        this.nazwa = stanowisko.getNazwa();
    }

    StanowiskoFiltr(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public boolean accept(Stanowisko object) {
        return Objects.equals(nazwa, object.getNazwa());
    }

    @Override
    public int limit() {
        return 1;
    }
}
