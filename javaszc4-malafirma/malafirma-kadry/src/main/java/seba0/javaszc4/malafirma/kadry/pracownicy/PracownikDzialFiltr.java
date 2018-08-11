package seba0.javaszc4.malafirma.kadry.pracownicy;

import seba0.javaszc4.malafirma.datastore.DataFilter;

import java.util.Objects;

class PracownikDzialFiltr implements DataFilter<Pracownik> {

    private final Dzial dzial;

    PracownikDzialFiltr(Dzial dzial) {
        this.dzial = dzial;
    }

    @Override
    public boolean accept(Pracownik object) {
        return Objects.equals(dzial, object.getDzial());
    }

    @Override
    public int limit() {
        return 1;
    }
}
