/*
Author: Jason Snow
Date: 1/5/2021

This program has an Octagon class which extends the GeometricObject class and implements the Comparable and Cloneable interfaces. The program then tests it by making one octagon object, cloning it, and comparing the clone to the origional.
*/
import java.util.*;

public class Exercise13_11 {
	public static void main(String[] args) {
		Octagon test1 = new Octagon(4);
		Octagon test2 = (Octagon)test1.clone();
		System.out.print(test1.compareTo(test2));
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

class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon> {
	private double sides;
	
	public Octagon() {
		sides = 1;
	}
	public Octagon(double sides) {
		this.sides = sides;
	}
	public double getSides() {
		return sides;
	}
	public void setSides(double sides) {
		this.sides = sides;
	}
	public double getArea() {
		return (2 + 4/(Math.sqrt(2))) * sides * sides;
	}
	public double getPerimeter() {
		return sides * 8;
	}
	
	@Override
	public int compareTo(Octagon o) {
		if (getArea() > o.getArea()) return 1;
		else if (getArea() < o.getArea()) return -1;
		else return 0;
	}
	
	public Object clone() {
		try {
			return super.clone();
		}
		catch (CloneNotSupportedException ex) {
			return null;
		}
	}
}
