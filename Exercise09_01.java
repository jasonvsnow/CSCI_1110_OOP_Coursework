/*
 * Author: Jason Snow
 * Date: 12/9/2020
 * 
 * This program makes two rectangle objects and displays their width, height, area, and perimeter.
 */

public class Exercise09_01 {
	public static void main(String[] args) {
		Rectangle rectangle1 = new Rectangle(4, 40);
		Rectangle rectangle2 = new Rectangle(3.5, 35.9);
		System.out.printf("Rectangle 1\n");
		System.out.printf("Width:%.1f\nHeight:%.1f\nArea:%.2f\nPerimeter:%.2f", rectangle1.width, rectangle1.height, rectangle1.getArea(), rectangle1.getPerimeter());
		System.out.printf("\n\nRectangle 2\n");
		System.out.printf("Width:%.1f\nHeight:%.1f\nArea:%.2f\nPerimeter:%.2f", rectangle2.width, rectangle2.height, rectangle2.getArea(), rectangle2.getPerimeter());

	}
}

class Rectangle {
	double width;
	double height;
	
	Rectangle() {
		width = 1;
		height= 1;
	}
	
	Rectangle(double newWidth, double newHeight) {
		width = newWidth;
		height = newHeight;
	}
	
	double getArea() {
		return (height * width);
	}
	
	double getPerimeter() {
		return ((height * 2) + (width * 2));
	}
	
}