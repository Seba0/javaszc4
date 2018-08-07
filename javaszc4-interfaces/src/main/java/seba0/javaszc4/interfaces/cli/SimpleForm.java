package seba0.javaszc4.interfaces.cli;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class SimpleForm {
    private final Scanner scanner;
    private final PrintStream out;
    private static final List<String> YES
            = Arrays.asList("y", "yes", "t", "tak");
    private static final List<String> NO
            = Arrays.asList("n", "no", "nie");

    public SimpleForm(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;

    }

    public SimpleForm() {
        this(System.in, System.out);
    }


    public String[] printForm(SimpleFormElement[] elements) {
        String[] values = new String[elements.length];
        out.println("Wypełnij formularz(wpisz \"anuluj\" aby anulować):");
        int size = 0;
        for (SimpleFormElement e : elements) {
            int labelSize = e.getLabel().length();
            if (labelSize > size) {
                size = labelSize;
            }
        }

        for (int i = 0; i < elements.length; i++) {
            StringBuilder sb = new StringBuilder(size + 1);
            sb.append(elements[i].getLabel());
            while (sb.length() < size) {
                sb.insert(0, ' ');
            }
            sb.insert(0, '\t');
            sb.append(": ");
            String label = sb.toString();
            while (true) {
                out.print(label);
                String value = scanner.nextLine();
                if (value.equalsIgnoreCase("anuluj")) {
                    return null;
                } else if (elements[i].isValid(value)) {
                    values[i] = value;
                    break;
                }
                out.println("Nie poprawnie wypełnione pole");
            }
        }
        while (true) {
            out.print("Czy zatwierdzić formularz? [t/n]: ");
            String value = scanner.nextLine();
            if (value.length() > 0) {
                if (YES.contains(value)) {
                    return values;
                } else if (NO.contains(value)) {
                    return null;
                }
            }
            out.println("Błędna odpowiedz");
        }
    }
}
