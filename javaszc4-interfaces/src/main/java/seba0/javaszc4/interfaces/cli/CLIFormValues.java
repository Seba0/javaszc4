package seba0.javaszc4.interfaces.cli;

public final class CLIFormValues<T extends Enum> {
    private final String[] values;

    CLIFormValues(String[] values) {
        this.values = values;
    }

    public String getValue(T field) {
        return values[field.ordinal()];
    }
}
