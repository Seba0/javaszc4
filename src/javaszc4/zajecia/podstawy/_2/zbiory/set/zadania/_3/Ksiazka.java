package javaszc4.zajecia.podstawy._2.zbiory.set.zadania._3;

import java.util.Objects;

public class Ksiazka {
    private final String tytul;
    private final String autor;
    private int iloscStron;

    public Ksiazka(String tytul, String autor, int iloscStron) {
        this.tytul = tytul;
        this.autor = autor;
        this.iloscStron = iloscStron;
    }

    public String getTytul() {
        return tytul;
    }

    public String getAutor() {
        return autor;
    }

    public int getIloscStron() {
        return iloscStron;
    }

    public void setIloscStron(int iloscStron) {
        this.iloscStron = iloscStron;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tytul, autor, iloscStron);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ksiazka ksiazka = (Ksiazka) o;
        return iloscStron == ksiazka.iloscStron &&
                Objects.equals(tytul, ksiazka.tytul) &&
                Objects.equals(autor, ksiazka.autor);
    }

    @Override
    public String toString() {
        return "Ksiazka{" +
                "tytul='" + tytul + '\'' +
                ", autor='" + autor + '\'' +
                ", iloscStron=" + iloscStron +
                '}';
    }
}
