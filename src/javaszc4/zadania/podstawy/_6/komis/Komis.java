package javaszc4.zadania.podstawy._6.komis;

import javaszc4.zadania.podstawy._6.komis.auta.Samochod;

import java.util.ArrayList;
import java.util.List;

public class Komis {
    private final String nazwa;
    private final String adres;

    public Komis(String nazwa, String adres) {
        this.nazwa = nazwa;
        this.adres = adres;
    }

    private final List<Samochod> listaSamochodow = new ArrayList<>();

    public String getNazwa() {
        return nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public List<Samochod> getListaSamochodow() {
        return listaSamochodow;
    }
}
