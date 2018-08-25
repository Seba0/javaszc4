package seba0.javaszc4.tdd.zadania._2;

import java.util.HashSet;
import java.util.Set;

public class Wydarzenie {
    private final String nazwa;
    private final Set<Uczestnik> listaUczestnikow;

    public Wydarzenie(String nazwa) {
        this.nazwa = nazwa;
        this.listaUczestnikow = new HashSet<>();
    }

    public String getNazwa() {
        return nazwa;
    }

    public Set<Uczestnik> getListaUczestnikow() {
        return listaUczestnikow;
    }

    public boolean addUczestnik(Uczestnik uczestnik) {
        return listaUczestnikow.add(uczestnik);
    }

    public boolean removeUczestnik(Uczestnik uczestnik) {
        return listaUczestnikow.remove(uczestnik);
    }

    public boolean removeUczestnik(String telefon, String mail) {
        return listaUczestnikow.remove(new Uczestnik("", "", mail, telefon));
    }
}
