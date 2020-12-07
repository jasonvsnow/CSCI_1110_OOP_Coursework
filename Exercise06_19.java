
import java.util.Scanner;

public class Exercise06_19 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the the length of the 3 sides of a triangle: ");
		double sone = input.nextDouble();
		double stwo = input.nextDouble();
		double sthree = input.nextDouble();
		if (isValid(sone, stwo, sthree)) {
			System.out.printf("%-8s%.1f\n", "Side 1: ", sone);
			System.out.printf("%-8s%.1f\n", "Side 2: ", stwo);
			System.out.printf("%-8s%.1f\n", "Side 3: ", sthree);
			System.out.printf("%-8s%.1f","Area: ", area(sone, stwo, sthree));
		}
		else System.out.print("That is not a valid triangle.");
		
	}
	public static boolean isValid(double side1, double side2, double side3) {
		double s12 = side1 + side2;
		double s13 = side1 + side3;
		double s23 = side2 + side3;
		boolean triang = false;
		if (s12 > side3 && s13 > side2 && s23 > side1) {
			triang = true;
		}
		else triang = false;
		return triang;
		
	}
	public static double area(double side1, double side2, double side3) {
		double s = (side1 + side2 + side3)/2;
		
		
		
		double area = Math.sqrt(s * (s- side1 ) * (s - side2) * (s - side3));
		
		return area;
	}
}
