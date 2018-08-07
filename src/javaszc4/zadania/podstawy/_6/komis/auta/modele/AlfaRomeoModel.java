package javaszc4.zadania.podstawy._6.komis.auta.modele;

public enum AlfaRomeoModel {
    _156("156"), GIULIETTA("Giulietta"), MITO("MiTo");

    private final String name;

    AlfaRomeoModel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
