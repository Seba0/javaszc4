package seba0.javaszc4.tdd.zadania._2;

import java.util.Objects;

public class Uczestnik {
    private final String imie;
    private final String nazwisko;
    private final String mail;
    private final String telefon;

    public Uczestnik(String imie, String nazwisko, String mail, String telefon) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.mail = mail;
        this.telefon = telefon;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getMail() {
        return mail;
    }

    public String getTelefon() {
        return telefon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Uczestnik)) return false;
        Uczestnik uczestnik = (Uczestnik) o;
        return Objects.equals(mail, uczestnik.mail) &&
                Objects.equals(telefon, uczestnik.telefon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, telefon);
    }
}
