package seba0.javaszc4.malafirma.kadry;

import seba0.javaszc4.malafirma.datastore.DataStoreManager;
import seba0.javaszc4.malafirma.datastore.csv.CSVDataStore;
import seba0.javaszc4.malafirma.kadry.view.ViewController;

public class ApplicationController {
    public static void main(String[] args) {
        DataStoreManager.registerStore("malafirma", CSVDataStore.class);
        ViewController.init(args);
    }
}
