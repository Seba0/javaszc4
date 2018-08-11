package seba0.javaszc4.malafirma.kadry.pracownicy;

import seba0.javaszc4.malafirma.datastore.DataFilter;

import java.util.Objects;

class DzialFiltr implements DataFilter<Dzial> {

    private final String nazwa;

    DzialFiltr(Dzial dzial) {
        this.nazwa = dzial.getNazwa();
    }

    DzialFiltr(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public boolean accept(Dzial object) {
        return Objects.equals(nazwa, object.getNazwa());
    }

    @Override
    public int limit() {
        return 1;
    }
}
