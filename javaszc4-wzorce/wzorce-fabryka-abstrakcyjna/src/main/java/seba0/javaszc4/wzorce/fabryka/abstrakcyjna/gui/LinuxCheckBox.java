package seba0.javaszc4.wzorce.fabryka.abstrakcyjna.gui;

public class LinuxCheckBox implements CheckBox {
    @Override
    public void paint(boolean isChecked) {
        System.out.println("Linux CheckBox is " + (isChecked ? "" : "not ") + "checked");
    }
}
