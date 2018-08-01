package javaszc4.malafirma.pracownicy;

import javaszc4.malafirma.datastore.DataFilter;

import java.util.Objects;

class DzialFiltr implements DataFilter<Dzial> {

    private final Dzial dzial;

    DzialFiltr(Dzial dzial) {
        this.dzial = dzial;
    }

    @Override
    public boolean accept(Dzial object) {
        return Objects.equals(dzial.getNazwa(), object.getNazwa());
    }

    @Override
    public int limit() {
        return 1;
    }
}
