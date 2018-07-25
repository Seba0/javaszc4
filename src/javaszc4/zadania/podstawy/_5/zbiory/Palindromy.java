package javaszc4.zadania.podstawy._5.zbiory;
import java.util.*;

public class Palindromy {
	
	private static boolean isPalindrom(String text) {
		if(text == null || text.isEmpty()) {
			return false;
		} else if(text.length() == 1) {
			return true;
		}
		StringBuilder sb = new StringBuilder(text.length());
		for(int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if(Character.isLetterOrDigit(c)) {
				sb.append(Character.toLowerCase(c));
			}
		}
		return sb.toString().equals(sb.reverse().toString());
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Podaj palindromy\n\tEND aby zakonczyć");
		Set<String> palindromy = new HashSet<>();
		while (true) {
			System.out.print("Podaj nowy palindrom: ");
			String palindrom = s.nextLine().trim();
			if ("END".equalsIgnoreCase(palindrom)) {
				break;
			} else if (isPalindrom(palindrom)) {
				if (palindromy.add(palindrom)) {
					System.out.println("Dodano palindrom: " + palindrom);
				}
			} else {
				System.out.println("Nieprawidłowy palindrom: " + palindrom);
			}
		}
		System.out.println("Ilość podanych palindromów: " + palindromy.size());
		System.out.println("Podane palindromy:");
		for(String palindrom : palindromy) {
			System.out.println('\t' + palindrom);
		}
	}
}
