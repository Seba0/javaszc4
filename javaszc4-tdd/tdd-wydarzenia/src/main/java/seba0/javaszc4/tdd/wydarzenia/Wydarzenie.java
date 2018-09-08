package seba0.javaszc4.tdd.wydarzenia;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Wydarzenie {
    private final String nazwa;
    private final int maksymalnaIloscUczestnikow;
    private final Set<Uczestnik> uczestnicy;

    public Wydarzenie(String nazwa, int maksymalnaIloscUczestnikow) {
        this.nazwa = nazwa;
        this.maksymalnaIloscUczestnikow = maksymalnaIloscUczestnikow;
        this.uczestnicy = new HashSet<>();
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getMaksymalnaIloscUczestnikow() {
        return maksymalnaIloscUczestnikow;
    }

    public Set<Uczestnik> getUczestnicy() {
        return Collections.unmodifiableSet(uczestnicy);
    }

    public boolean addUczestnik(Uczestnik uczestnik) {
        return uczestnicy.add(uczestnik);
    }
}
