package javaszc4.malafirma;

import javaszc4.malafirma.datastore.DataStoreManager;
import javaszc4.malafirma.datastore.csv.CSVDataStore;
import javaszc4.malafirma.view.ViewController;

public class ApplicationController {
    public static void main(String[] args) {
        DataStoreManager.registerStore("malafirma", CSVDataStore.class);
        ViewController.init(args);
    }
}
