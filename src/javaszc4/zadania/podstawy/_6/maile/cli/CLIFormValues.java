package javaszc4.zadania.podstawy._6.maile.cli;

public final class CLIFormValues<T extends Enum> {
    private final String[] values;

    CLIFormValues(String[] values) {
        this.values = values;
    }

    public String getValue(T field) {
        return values[field.ordinal()];
    }
}
