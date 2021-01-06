/*
Author: Jason Snow
Date: 12/5/2020

This program extends a Triangle class from an abstract GeometricObject class. It prompts a user to enter information which is used to create a triangle object and the information of this object is then displayed
*/

import java.util.*;

public class Exercise13_01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		double side1 = 1;
		double side2 = 1;
		double side3 = 1;
		while (valid == false) {
			System.out.println("Enter the requested information for a triangle.");
			System.out.print("Enter a value for side1(ex: 1): ");
			side1 = input.nextDouble();
			System.out.print("Enter a value for side2: ");
			side2 = input.nextDouble();
			System.out.print("Enter a value for side3: ");
			side3 = input.nextDouble();
			if (isValid(side1, side2, side3)) valid = true;
			else System.out.printf("Invalid side lengths for a triangle. Enter valid side lenghts.\n\n");
		}
		System.out.print("Enter a color(ex: green): ");
		String color = input.next();
		boolean proper = false;
		boolean filled = true;
		int choice;
		while (proper == false) {
			System.out.print("Enter 0 for filled or 1 for empty: ");
			choice = input.nextInt();
			if (choice == 0 || choice == 1) {
				proper = true;
				if (choice == 0) filled = true;
				else filled = false;
			}
			else System.out.print("Improper Input");
		}
		System.out.println("");
		Triangle triangle1 = new Triangle(side1, side2, side3);
		triangle1.setColor(color);
		triangle1.setFilled(filled);
		System.out.print(triangle1.toString());
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

abstract class GeometricObject {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
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
		return "Color: " + color + " Filled: " + filled + " Date Created " + dateCreated;
	}
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
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
		return "Area: " + getArea() + " Perimeter: " + getPerimeter() + " Color: " + getColor() + " Is Filled: " + isFilled();
	}
}
