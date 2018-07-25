package javaszc4.zadania.podstawy._5.zbiory;
import java.util.*;
import java.util.regex.*;

public class Imiona {
	private static String format(String imie) {
		if (imie.isEmpty()) {
			return imie;
		}
		return Character.toUpperCase(imie.charAt(0))
			+ imie.substring(1).toLowerCase();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Podaj imiona\n\tEND aby zakonczyć");
		Set<String> imiona = new HashSet<>();
		Pattern pattern = Pattern.compile("[A-Za-z]+");
		while (true) {
			System.out.print("Podaj nowe imię: ");
			String imie = s.nextLine().trim();
			if ("END".equalsIgnoreCase(imie)) {
				break;
			} else if (pattern.matcher(imie).matches()) {
				imie = format(imie);
				if (imiona.add(imie)) {
					System.out.println("Dodano imię: " + imie);
				}
			} else {
				System.out.println("Nieprawidłowe imię: " + imie);
			}
		}
		System.out.println("Ilość podanych imion: " + imiona.size());
		System.out.println("Podane imiona:");
		for(String imie : imiona) {
			System.out.println('\t' + imie);
		}
	}
}
