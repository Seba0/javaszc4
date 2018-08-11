package seba0.javaszc4.malafirma.kadry.pracownicy;

public abstract class PracownikBuilder {

    private String imie;
    private String nazwisko;
    private long pesel;
    private long telefon;
    private String adres;
    private Stanowisko stanowisko;
    private Dzial dzial;

    PracownikBuilder() {
    }

    public PracownikBuilder imie(String imie) {
        this.imie = imie;
        return this;
    }

    public PracownikBuilder nazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
        return this;
    }

    public PracownikBuilder pesel(long pesel) {
        this.pesel = pesel;
        return this;
    }

    public PracownikBuilder telefon(long telefon) {
        this.telefon = telefon;
        return this;
    }

    public PracownikBuilder adres(String adres) {
        this.adres = adres;
        return this;
    }

    public PracownikBuilder stanowisko(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
        return this;
    }

    public PracownikBuilder dzial(Dzial dzial) {
        this.dzial = dzial;
        return this;
    }

    protected abstract Pracownik build(Pracownik pracownik);

    public Pracownik build() {
        Pracownik pracownik = new Pracownik();
        pracownik.setImie(imie);
        pracownik.setNazwisko(nazwisko);
        pracownik.setPesel(pesel);
        pracownik.setTelefon(telefon);
        pracownik.setAdres(adres);
        pracownik.setStanowisko(stanowisko);
        pracownik.setDzial(dzial);
        return build(pracownik);
    }
}
