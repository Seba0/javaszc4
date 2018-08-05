package javaszc4.malafirma.przychodnia.pracownicy;

import javaszc4.malafirma.datastore.DataFilter;
import javaszc4.malafirma.datastore.DataStore;
import javaszc4.malafirma.datastore.DataStoreManager;
import javaszc4.malafirma.datastore.DataTable;
import javaszc4.malafirma.pracownicy.Pracownik;
import javaszc4.malafirma.pracownicy.PracownikFiltr;
import javaszc4.malafirma.pracownicy.PracownikManager;

import java.util.*;

public final class LekarzManager {

    private LekarzManager() {
    }

    private static <T extends DataTable> Collection<T> getCollection(Class<T> type) {
        return getCollection(type, null);
    }

    private static <T extends DataTable> Collection<T> getCollection(Class<T> type, DataFilter<T> filter) {
        try {
            DataStore dataStore = DataStoreManager.openStore("malafirma");
            return dataStore.select(type, filter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public static Collection<Lekarz> getLekarzy() {
        return getCollection(Lekarz.class);
    }

    public static Collection<Pacjent> getPacjenci() {
        return getCollection(Pacjent.class);
    }

    public static Collection<Wizyta> getWizyty() {
        return getCollection(Wizyta.class);
    }

    public static Queue<Wizyta> getWizyty(Lekarz lekarz) {
        return new LinkedList<>(getCollection(Wizyta.class, new WizytaLekarzFiltr(lekarz)));
    }

    public static Queue<Wizyta> getWizyty(Pacjent pacjent) {
        return new LinkedList<>(getCollection(Wizyta.class, new WizytaPacjentFiltr(pacjent)));
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

    public static Lekarz createLekarz(long idPracownika) {
        Pracownik pracownik = PracownikManager.getPracownik(idPracownika);
        Lekarz lekarz = new Lekarz();
        lekarz.setImie(pracownik.getImie());
        lekarz.setNazwisko(pracownik.getNazwisko());
        lekarz.setPesel(pracownik.getPesel());
        lekarz.setTelefon(pracownik.getTelefon());
        lekarz.setAdres(pracownik.getAdres());
        lekarz.setStanowisko(pracownik.getStanowisko());
        lekarz.setDzial(pracownik.getDzial());
        if (!addData(lekarz, new PracownikFiltr<>(lekarz))) {
            return null;
        }
        return lekarz;
    }

    public static PacjentBuilder createPacjent(String imie, String nazwisko, long pesel) {
        return new PacjentBuilder() {
            @Override
            protected Pacjent build(Pacjent pacjent) {
                if (!addData(pacjent, new PacjentFiltr(pacjent))) {
                    return null;
                }
                return pacjent;
            }
        }.imie(imie).nazwisko(nazwisko).pesel(pesel);
    }

    public static Wizyta createWizyta(Date data, Pacjent pacjent) {
        return createWizyta(data, pacjent, pacjent.getLekarz());
    }

    public static Wizyta createWizyta(Date data, Pacjent pacjent, Lekarz lekarz) {
        Wizyta wizyta = new Wizyta();
        wizyta.setData(data);
        wizyta.setLekarz(lekarz);
        wizyta.setPacjent(pacjent);
        if (!addData(wizyta, new WizytaFilter(wizyta))) {
            return null;
        }
        return wizyta;
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

    private static boolean deleteTable(Class<? extends DataTable> table, long id) {
        try {
            DataStore dataStore = DataStoreManager.openStore("malafirma");
            return dataStore.delete(table, id) != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete(Lekarz pracownik) {
        return deleteTable(pracownik);
    }

    public static boolean deleteLekarz(long id) {
        return deleteTable(Lekarz.class, id);
    }

    public static boolean delete(Pacjent pacjent) {
        try {
            DataStore dataStore = DataStoreManager.openStore("malafirma");
            Collection rows = dataStore.select(Pracownik.class, new PacjentFiltr(pacjent));
            if (rows.isEmpty()) {
                return deleteTable(pacjent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deletePacjent(long id) {
        try {
            DataStore dataStore = DataStoreManager.openStore("malafirma");
            Pacjent pacjent = dataStore.select(Pacjent.class, id);
            if (pacjent == null) {
                return false;
            }
            Collection rows = dataStore.select(Wizyta.class, new PacjentWizytaFiltr(pacjent));
            if (rows.isEmpty()) {
                return deleteTable(Pacjent.class, id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteWizyta(long id) {
        try {
            DataStore dataStore = DataStoreManager.openStore("malafirma");
            Wizyta wizyta = dataStore.select(Wizyta.class, id);
            if (wizyta == null) {
                return false;
            } else if (wizyta.getData().compareTo(new Date()) <= 0) {
                return false;
            }
            return deleteTable(Wizyta.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static <T extends DataTable> T getObject(Class<T> table, long id) {
        try {
            DataStore dataStore = DataStoreManager.openStore("malafirma");
            return dataStore.select(table, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private static <T extends DataTable> Collection<T> getObject(Class<T> table, DataFilter<T> filter) {
        try {
            DataStore dataStore = DataStoreManager.openStore("malafirma");
            return dataStore.select(table, filter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;

    }

    public static Lekarz getLekarz(long id) {
        return getObject(Lekarz.class, id);
    }

    private static <T extends DataTable> T getSingle(Class<T> table, DataFilter<T> filter) {
        Collection<T> collection = getObject(table, filter);
        for (T element : collection) {
            return element;
        }
        return null;
    }

    public static Pacjent getPacjent(long pesel) {
        return getSingle(Pacjent.class, new PacjentFiltr(pesel));
    }
}
