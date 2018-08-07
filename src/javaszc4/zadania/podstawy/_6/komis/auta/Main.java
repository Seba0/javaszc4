package javaszc4.zadania.podstawy._6.komis.auta;

import javaszc4.zadania.podstawy._6.komis.Komis;
import javaszc4.zadania.podstawy._6.komis.auta.modele.AlfaRomeoModel;
import javaszc4.zadania.podstawy._6.komis.auta.modele.AudiModel;
import javaszc4.zadania.podstawy._6.komis.auta.modele.BMWModel;

import java.util.*;

public class Main {

    private final static Class<? extends Enum>[] MODELE = new Class[]{
            AlfaRomeoModel.class, AudiModel.class, BMWModel.class, Chevrolet.class
    };

    private final static Class<? extends Samochod>[] MARKI = new Class[]{
            AlfaRomeo.class, Audi.class, BMW.class, Chevrolet.class
    };

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        List<Samochod> listaSamochodow = new ArrayList<>(20);
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int index = r.nextInt(MARKI.length);
            Enum[] modele = MODELE[index].getEnumConstants();
            Samochod samochod = MARKI[index].newInstance();
            index = r.nextInt(modele.length);
            samochod.setModel(modele[index]);
            listaSamochodow.add(samochod);
        }
        List<Komis> komisy = Arrays.asList(
                new Komis("Komis A", "Adres A"),
                new Komis("Komis B", "Adres B")
        );
        for (Samochod samochod : listaSamochodow) {
            komisy.get(r.nextBoolean() ? 0 : 1)
                    .getListaSamochodow()
                    .add(samochod);
        }
        Map<String, List<Samochod>> autka = new HashMap<>();
        for(Komis komis : komisy) {
            for(Samochod samochod : komis.getListaSamochodow()) {
                String model = samochod.getModel().toString();
                List<Samochod> samochods = autka.get(model);
                if(samochods == null) {
                    samochods = new ArrayList<>();
                    autka.put(model, samochods);
                }
                samochods.add(samochod);
            }
        }
    }
}
