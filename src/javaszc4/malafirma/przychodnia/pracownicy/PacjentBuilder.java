package javaszc4.malafirma.przychodnia.pracownicy;

public abstract class PacjentBuilder {

    private String imie;
    private String nazwisko;
    private long pesel;
    private long telefon;
    private String adres;
    private Lekarz lekarz;

    PacjentBuilder() {
    }

    public PacjentBuilder imie(String imie) {
        this.imie = imie;
        return this;
    }

    public PacjentBuilder nazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
        return this;
    }

    public PacjentBuilder pesel(long pesel) {
        this.pesel = pesel;
        return this;
    }

    public PacjentBuilder telefon(long telefon) {
        this.telefon = telefon;
        return this;
    }

    public PacjentBuilder adres(String adres) {
        this.adres = adres;
        return this;
    }

    public PacjentBuilder lekarz(Lekarz lekarz) {
        this.lekarz = lekarz;
        return this;
    }

    protected abstract Pacjent build(Pacjent pacjent);

    public Pacjent build() {
        Pacjent pacjent = new Pacjent();
        pacjent.setImie(imie);
        pacjent.setNazwisko(nazwisko);
        pacjent.setPesel(pesel);
        pacjent.setTelefon(telefon);
        pacjent.setAdres(adres);
        pacjent.setLekarz(lekarz);
        return build(pacjent);
    }
}
