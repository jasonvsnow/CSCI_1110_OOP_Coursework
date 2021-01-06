/*
Author: Jason Snow
Date: 12/5/2020

This program extends a Triangle class from an abstract GeometricObject class. It implements a Colorable interface. Five triangle objects are created in an array and then assigned random side values. The program then prints out the area of each object in the array and invokes its howToColor method if it is colorable.
*/

import java.util.*;

public class Exercise13_07 {
	public static void main(String[] args) {
		Triangle[] triangleArray = new Triangle[5];
		for (int i = 0; i < triangleArray.length; i++) {
			double side1 = 1;
			double side2 = 1;
			double side3 = 1;
			boolean valid = false;
			while (valid == false) {
				side1 = (int)(Math.random()*100);
				side2 = (int)(Math.random()*100);
				side3 = (int)(Math.random()*100);
				if (isValid(side1, side2, side3)) valid = true;
			}
			triangleArray[i] = new Triangle(side1, side2, side3);
		}
		
		for (int i = 0; i < triangleArray.length; i++) {
			System.out.println("Triangle " + (i+1));
			System.out.printf("Area: %.2f\n", triangleArray[i].getArea());
			triangleArray[i].howToColor();
			System.out.println("");
		} 


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

class Triangle extends GeometricObject implements Colorable {
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
	
	public void howToColor() {
		System.out.println("Color all three sides");
	}
}

interface Colorable {
	public abstract void howToColor();
}

