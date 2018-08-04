package javaszc4.zajecia.podstawy._2.zbiory.mapy.zadania._2;

import java.util.*;

public final class Film {
    private final String tytul;
    private final Set<Gatunek> gatunek;
    private final String rezyser;
    private final int rokWydania;

    public Film(String tytul, Set<Gatunek> gatunek, String rezyser, int rokWydania) {
        this.tytul = tytul;
        this.gatunek = new TreeSet<>(gatunek);
        this.rezyser = rezyser;
        this.rokWydania = rokWydania;
    }

    public String getTytul() {
        return tytul;
    }

    public Set<Gatunek> getGatunek() {
        return Collections.unmodifiableSet(gatunek);
    }

    public String getRezyser() {
        return rezyser;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return rokWydania == film.rokWydania &&
                Objects.equals(tytul, film.tytul) &&
                Objects.equals(gatunek, film.gatunek) &&
                Objects.equals(rezyser, film.rezyser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tytul, gatunek, rezyser, rokWydania);
    }

    @Override
    public String toString() {
        return "Film{" +
                "tytul='" + tytul + '\'' +
                ", gatunek=" + Arrays.toString(gatunek.toArray()) +
                ", rezyser='" + rezyser + '\'' +
                ", rokWydania=" + rokWydania +
                '}';
    }
}
