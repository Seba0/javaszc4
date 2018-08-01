package javaszc4.malafirma.datastore;

import java.util.HashMap;
import java.util.Map;

public enum DataStoreManager {
    INSTANCE;

    private final Map<String, DataStore> dataStores = new HashMap<>();
    private final Map<String, Class<? extends DataStore>> dataStoresClase = new HashMap<>();

    public synchronized DataStore openStore(String name) throws Exception {
        DataStore ds = dataStores.get(name);
        if (ds == null) {
            Class<? extends DataStore> aClass = dataStoresClase.get(name);
            ds = aClass.newInstance();
            dataStores.put(name, ds);
        }
        if (ds != null && !ds.isOpen()) {
            ds.open(name);
        }
        return ds;
    }

    public synchronized <T extends DataStore> boolean registerStore(String name, Class<T> type) {
        if (dataStoresClase.containsKey(name)) {
            return false;
        }
        return dataStoresClase.put(name, type) == null;
    }

    public synchronized boolean unregisterStore(String name) throws Exception {
        if (dataStoresClase.remove(name) == null) {
            return false;
        }
        DataStore remove = dataStores.remove(name);
        if (remove != null) {
            remove.close();
        }
        return true;
    }

    public synchronized <T extends DataStore> boolean unregisterStore(Class<T> type) throws Exception {
        for (Map.Entry<String, Class<? extends DataStore>> t : dataStoresClase.entrySet()) {
            if (t.getValue().isAssignableFrom(type)) {
                if (!unregisterStore(t.getKey())) {
                    return false;
                }
            }
        }
        return true;
    }
}
