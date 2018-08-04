package javaszc4.malafirma.view.cui.simple;
import java.util.*;
import java.io.*;

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
	
	

	public String[] printForm(SimpleFormOption[] options) {
		String[] values = new String[options.length];
		out.println("Wypełnij formularz:");
		for (int i = 0; i < options.length; i++) {
			while (true) {
				out.print('\t');
				out.print(options[i]);
				out.print(": ");
				String value = scanner.nextLine();
				if (options[i].isValid(value)) {
					values[i] =  value;
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
