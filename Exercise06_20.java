
import java.util.Scanner;

public class Exercise06_20 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String message = input.nextLine();
		System.out.println("'" + message + "' is " + message.length() + " character's long");
		System.out.print("There are " + countLetters(message) + " letters in '" + message + "'");
	}
	
	public static int countLetters(String s) {
		int count = 0;
		for (int x = 0; x < s.length(); x++) {
			char hold = s.charAt(x);
			if (Character.isLetter(hold)) {
				count += 1;
			}
		}
		return count;
	}
	
}
