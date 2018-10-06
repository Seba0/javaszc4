package seba0.javaszc4.wzorce.fabryka.abstrakcyjna.gui;

public class OperationSystem {

    private final GuiFactory guiFactory;
    private final Button button;
    private final CheckBox checkBox;

    public OperationSystem(GuiFactory guiFactory) {
        this.guiFactory = guiFactory;
        this.button = guiFactory.createButton();
        this.checkBox = guiFactory.createCheckBox();
    }

    public void showOperationSystemGui() {
        button.paint();
        checkBox.paint(false);
    }

    public static void main(String[] args) {
        OperationSystem system = new OperationSystem(new LinuxGuiFactory());
        system.showOperationSystemGui();
    }
}
