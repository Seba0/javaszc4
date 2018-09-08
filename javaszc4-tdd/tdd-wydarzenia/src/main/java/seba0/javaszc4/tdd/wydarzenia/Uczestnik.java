package seba0.javaszc4.tdd.wydarzenia;


import java.util.Objects;

public class Uczestnik {
    private final String imie;
    private final String nazwisko;
    private final String mail;

    public Uczestnik(String imie, String nazwisko, String mail) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.mail = mail;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Uczestnik)) return false;
        Uczestnik uczestnik = (Uczestnik) o;
        return Objects.equals(mail, uczestnik.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail);
    }
}
