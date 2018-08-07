package seba0.javaszc4.malafirma.cli;

public interface SimpleFormElement {
    String getLabel();

    boolean isValid(String value);
}
