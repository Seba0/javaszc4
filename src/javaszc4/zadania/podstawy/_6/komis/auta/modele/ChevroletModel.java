package javaszc4.zadania.podstawy._6.komis.auta.modele;

public enum ChevroletModel {
    CRUZE("Cruze"), LUMINA("Lumina"), ORLANDO("Orlando");

    private final String name;

    ChevroletModel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
