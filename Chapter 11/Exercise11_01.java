import java.util.*;
import javax.xml.bind.*;

public class Exercise11_01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		double side1 = 0;
		double side2 = 0;
		double side3 = 0;
		while (valid == false) {
			System.out.println("Enter three sides for a triangle");
			System.out.print("Side1: ");
			side1 = input.nextDouble();
			System.out.print("Side2: ");
			side2 = input.nextDouble();
			System.out.print("Side3: ");
			side3 = input.nextDouble();
			if (isValid(side1, side2, side3)) {
				valid = true;
			}
			else System.out.printf("Invalid side lengths for a triangle. Enter valid side lenghts.\n\n");
		}
		System.out.print("Enter a color for the triangle: ");
		String color = input.next();
		boolean choosing = true;
		boolean filled = false;
		while (choosing == true) {
			System.out.print("Enter a 1 for a filled triangle or a 2 for a non-filled triangle: ");
			int choice = input.nextInt();
			if (choice == 1) {
				filled = true;
				choosing = false;
			}
			else if (choice == 2) {
				filled = false;
				choosing = false;
			}
			else System.out.println("Invalid choice.");
		}
		Triangle triangle1 = new Triangle(side1, side2, side3);
		triangle1.setColor(color);
		triangle1.setFilled(filled);
		System.out.printf("Triangle\nArea: %.2f Perimeter: %.2f Color: %s Filled: %b ", triangle1.getArea(), triangle1.getPerimeter(), triangle1.getColor(), triangle1.isFilled());
		System.out.print("Date Created: " + triangle1.getDateCreated());
		
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
}

class GeometricObject {
	private String color = "white";
	private boolean filled;
	private Date dateCreated;
	
	public GeometricObject() {
		dateCreated = new Date();
	}
	
	public GeometricObject(String color, boolean filled) {
		dateCreated = new Date();
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
	}
}

class Triangle extends GeometricObject {
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle() {
		side1 = 1;
		side2 = 1;
		side3 = 1;
	}
	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}
	
	public double getArea() {
		double s = (side1 + side2 + side3)/2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}
	
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	public String toString() {
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
}
