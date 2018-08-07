package javaszc4.malafirma.przychodnia.pracownicy;

import javaszc4.malafirma.datastore.DataFilter;

import java.util.Objects;

class WizytaLekarzFiltr implements DataFilter<Wizyta> {
    private final Lekarz lekarz;

    WizytaLekarzFiltr(Lekarz lekarz) {
        this.lekarz = lekarz;
    }

    @Override
    public boolean accept(Wizyta object) {
        return Objects.equals(lekarz, object.getLekarz());
    }
}
