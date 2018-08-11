package seba0.javaszc4.interfaces.cli;

import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public final class CommandLineInterface {

    private static final List<String> YES
            = Arrays.asList("y", "yes", "t", "tak");
    private static final List<String> NO
            = Arrays.asList("n", "no", "nie");
    private final Scanner scanner;
    private final PrintStream out;

    public CommandLineInterface(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;

    }

    public CommandLineInterface() {
        this(System.in, System.out);
    }

    public synchronized <T extends Enum<? extends CLIFormInput>> CLIFormValues<T> printForm(Class<T> form) {
        CLIFormInput[] elements = (CLIFormInput[]) form.getEnumConstants();
        String[] values = new String[elements.length];
        out.println("Wypełnij formularz(wpisz \"anuluj\" aby anulować):");
        int size = 0;
        for (CLIFormInput e : elements) {
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
                    return new CLIFormValues<T>(values);
                } else if (NO.contains(value)) {
                    return null;
                }
            }
            out.println("Błędna odpowiedz");
        }
    }

    public synchronized <T extends Enum> T printMenu(Class<T> menu) {
        return printMenu(Arrays.asList(menu.getEnumConstants()));
    }

    public synchronized <T> T printMenu(Collection<T> elements) {
        List<T> tmp = new ArrayList<>(elements);
        out.println("Wybierz opcje z menu:");
        int i = 0;
        for (T element : tmp) {
            out.print('\t');
            out.print(++i);
            out.print(": ");
            out.println(element);
        }
        out.println("\t0: Anuluj");
        while (true) {
            out.print("Podaj numer opcji [0.." + i + "]: ");
            try {
                int value = scanner.nextInt();
                if (value == 0) {
                    return null;
                } else if (value > 0 && value <= elements.size()) {
                    return tmp.get(value - 1);
                }
            } catch (Exception e) {
            }
            out.println("Błędny numer opcji");
        }
    }

    public int nextOption(final int last, int[] disabled) {
        Arrays.sort(disabled);
        out.print("Podaj numer opcji [1-" + last + "]: ");
        while (true) {
            try {
                long start = System.currentTimeMillis();
                if (scanner.hasNext()) {
                    if (System.currentTimeMillis() - start < 1) {
                        continue;
                    }
                    int opcja = scanner.nextInt();
                    if (opcja < 1 || opcja > last) {
                        out.println("Wybrano niepoprawny numer opcji");
                    } else if (Arrays.binarySearch(disabled, opcja) >= 0) {
                        out.println("Ta opcja jest w tym momencie niedozwolona");
                    } else {
                        return opcja;
                    }
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                out.println("Wybrano niepoprawny numer opcji");
            }
        }
    }

    public void print(boolean value) {
        out.print(value);
    }

    public void print(char value) {
        out.print(value);
    }

    public void print(long value) {
        out.print(value);
    }

    public void print(float value) {
        out.print(value);
    }

    public void print(double value) {
        out.print(value);
    }

    public void print(String value) {
        out.print(value);
    }

    public void print(Object value) {
        out.print(value);
    }

    public void println() {
        out.println();
    }

    public void println(boolean value) {
        out.println(value);
    }

    public void println(char value) {
        out.println(value);
    }

    public void println(long value) {
        out.println(value);
    }

    public void println(float value) {
        out.println(value);
    }

    public void println(double value) {
        out.println(value);
    }

    public void println(String value) {
        out.println(value);
    }

    public void println(Object value) {
        out.println(value);
    }

    public String next() {
        return scanner.next();
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public boolean nextBoolean() {
        return scanner.nextBoolean();
    }

    public byte nextByte() {
        return scanner.nextByte();
    }

    public short nextShort() {
        return scanner.nextShort();
    }

    public int nextInt() {
        return scanner.nextInt();
    }

    public long nextLong() {
        return scanner.nextLong();
    }

    public float nextFloat() {
        return scanner.nextFloat();
    }

    public double nextDouble() {
        return scanner.nextDouble();
    }

    public BigInteger nextBigInteger() {
        return scanner.nextBigInteger();
    }

    public BigDecimal nextBigDecimal() {
        return scanner.nextBigDecimal();
    }

}
