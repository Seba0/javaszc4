package seba0.javaszc4.malafirma.przychodnia;

import seba0.javaszc4.malafirma.datastore.DataStoreManager;
import seba0.javaszc4.malafirma.datastore.csv.CSVDataStore;
import seba0.javaszc4.malafirma.przychodnia.view.ViewController;

public class PrzychodniaController {
    public static void main(String[] args) {

        DataStoreManager.registerStore("malafirma", CSVDataStore.class);
        ViewController.init(args);
    }
}
