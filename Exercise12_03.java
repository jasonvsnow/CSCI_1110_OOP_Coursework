/* 
Author: Jason Snow
Date: 3/1/2021
This program fills an array of 100 integers with random integers and lets a user enter an index to see one of these values, while throwing an exception if the value is out of bounds.
*/

import java.util.*;

class Exercise12_03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] ranArray = new int[100];
		for (int i = 0; i < 100; i++) {
			ranArray[i] = (int)(Math.random()*1000);
		}
		System.out.print("Enter an index: ");
		
		int index = input.nextInt();
		if (index < 0 && index > 99) throw new IndexOutOfBoundsException("Value out of bounds");
		try {
			System.out.println(ranArray[index]);
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println("Out of Bounds.");
		}
		System.out.println("Execution continues...");

	}
}