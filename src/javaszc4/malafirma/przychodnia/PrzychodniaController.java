package javaszc4.malafirma.przychodnia;

import javaszc4.malafirma.datastore.DataStoreManager;
import javaszc4.malafirma.datastore.csv.CSVDataStore;
import javaszc4.malafirma.przychodnia.view.ViewController;

public class PrzychodniaController {
    public static void main(String[] args) {

        DataStoreManager.registerStore("malafirma", CSVDataStore.class);
        ViewController.init(args);
    }
}
