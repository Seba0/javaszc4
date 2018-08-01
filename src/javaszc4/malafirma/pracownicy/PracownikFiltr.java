package javaszc4.malafirma.pracownicy;

import javaszc4.malafirma.datastore.DataFilter;

class PracownikFiltr implements DataFilter<Pracownik> {

    private final Pracownik pracownik;

    PracownikFiltr(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    @Override
    public boolean accept(Pracownik object) {
        return pracownik.getPesel() == object.getPesel();
    }

    @Override
    public int limit() {
        return 1;
    }
}
