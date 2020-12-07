/*
 * Author: Jason Snow
 * Date: 12/7/2020
 * 
 * This program checks to see if an entered password meets the following criteria:
 * 1) A password must have at least eight characters.
 * 2) A password must contain only letters and digits.
 * 3) A password must contain at least two digits.
 */
import java.util.Scanner;

public class Exercise06_18 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a password: ");
		String pass = input.nextLine();
		if (isValid(pass)) System.out.print("Valid password.");
		else System.out.print("Invalid password.");
	}
	
	public static boolean isValid(String s) {
		int check = 0;
		boolean valid = true;
		if (s.length() < 8) check += 1;
		for (int x = 0; x < s.length(); x++) {
			if (Character.isLetter(s.charAt(x)) || Character.isDigit(s.charAt(x))) check += 0;
			else check += 1;
		}
		int digits = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) digits += 1;
		}
		if (digits < 2) check += 1;
		if (check > 0) valid = false;
		return valid;
	}
}
