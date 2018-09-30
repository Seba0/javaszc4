package seba0.javaszc4.wielowatkowosc.synchronizacja._1;


public class ActionThread extends Thread {
    private final int values;
    private final Table table;

    public ActionThread(int values, Table table) {
        this.values = values;
        this.table = table;
    }

    @Override
    public void run() {
        table.printTable(values);
    }
}
