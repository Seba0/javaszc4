package javaszc4.malafirma.pracownicy;

import javaszc4.malafirma.datastore.DataFilter;

public class PracownikFiltr<T extends Pracownik> implements DataFilter<T> {

    private final T pracownik;

    public PracownikFiltr(T pracownik) {
        this.pracownik = pracownik;
    }

    @Override
    public boolean accept(T object) {
        return pracownik.getPesel() == object.getPesel();
    }

    @Override
    public int limit() {
        return 1;
    }
}
