package javaszc4.zadania.podstawy._6.maile.menus;

public enum MainMenu {
    NAPISZ("Napisz maila"),
    WYSLIJ("Wyśłij napisane maile"),
    WYSWIETL("Wyświetl wiadomości czekające w kolejce do wysłąnia"),
    WYJDZ("Zakończ program");

    private final String label;

    MainMenu(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
