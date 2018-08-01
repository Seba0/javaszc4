package javaszc4.malafirma.pracownicy;

import javaszc4.malafirma.datastore.DataFilter;
import javaszc4.malafirma.datastore.DataStore;
import javaszc4.malafirma.datastore.DataStoreManager;
import javaszc4.malafirma.datastore.DataTable;

import java.util.Collection;
import java.util.Collections;

public final class PracownikManager {

    private PracownikManager() {
    }

    private static <T extends DataTable> Collection<T> getCollection(Class<T> type) {
        try {
            DataStore dataStore = DataStoreManager.openStore("malafirma");
            return dataStore.select(type, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public static Collection<Pracownik> getPracownicy() {
        return getCollection(Pracownik.class);
    }

    public static Collection<Dzial> getDzial() {
        return getCollection(Dzial.class);
    }

    public static Collection<Stanowisko> getStanowisko() {
        return getCollection(Stanowisko.class);
    }

    private static <T extends DataTable> boolean addData(T table, DataFilter<T> filter) {
        try {
            DataStore dataStore = DataStoreManager.openStore("malafirma");
            Collection<T> rows = dataStore.select(table.getClass(), filter);
            if (!rows.isEmpty()) {
                return false;
            }
            return dataStore.insert(table) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static PracownikBuilder createPracownik(String imie, String nazwisko, long pesel) {
        return new PracownikBuilder() {
            @Override
            protected Pracownik build(Pracownik pracownik) {
                if (!addData(pracownik, new PracownikFiltr(pracownik))) {
                    return null;
                }
                return pracownik;
            }
        }.imie(imie).nazwisko(nazwisko).pesel(pesel);
    }

    public static Stanowisko createStanowisko(String nazwa, String opis) {
        Stanowisko stanowisko = new Stanowisko();
        stanowisko.setNazwa(nazwa);
        stanowisko.setOpis(opis);
        if (!addData(stanowisko, new StanowiskoFiltr(stanowisko))) {
            return null;
        }
        return stanowisko;
    }

    public static Dzial createDzial(String nazwa, String opis) {
        Dzial dzial = new Dzial();
        dzial.setNazwa(nazwa);
        dzial.setOpis(opis);
        if (!addData(dzial, new DzialFiltr(dzial))) {
            return null;
        }
        return dzial;
    }

    private static boolean deleteTable(DataTable table) {
        try {
            DataStore dataStore = DataStoreManager.openStore("malafirma");
            return dataStore.delete(table);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete(Pracownik pracownik) {
        return deleteTable(pracownik);
    }

    public static boolean delete(Stanowisko stanowisko) {
        try {
            DataStore dataStore = DataStoreManager.openStore("malafirma");
            Collection rows = dataStore.select(Pracownik.class, new PracownikStanowiskoFiltr(stanowisko));
            if (rows.isEmpty()) {
                return deleteTable(stanowisko);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete(Dzial dzial) {
        try {
            DataStore dataStore = DataStoreManager.openStore("malafirma");
            Collection rows = dataStore.select(Pracownik.class, new PracownikDzialFiltr(dzial));
            if (rows.isEmpty()) {
                return deleteTable(dzial);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
