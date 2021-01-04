/*
Author: Jason Snow
Date: 1/3/2021

This program creates a file namead Exercise12_15.txt if it does not exist, writes 100 randomly generated  integers into it, and then reads them back out, listing them in ascending order.
*/


import java.io.*;
import java.util.*;

public class Exercise12_15 {
	public static void main(String[] args) throws java.io.IOException {
		File txtFile = new File("Exercise12_15.txt");
		if (txtFile.exists()) {
			System.out.println("File already exists.");
			System.exit(0);
		}
		
		try ( PrintWriter testF = new PrintWriter(txtFile); ) {
			for (int i = 0; i < 100; i++) {
				int num = (int)(Math.random()*1000);
				testF.print(num + " ");
			}
		}
		Scanner input = new Scanner(txtFile);
		int[] array = new int[100];
		int i = 0;
		while (input.hasNext()) {
			int intValue = Integer.parseInt(input.next());
			array[i] = intValue;
			i += 1;
		}
		array = sortArray(array);
		for (int w = 0; w < array.length; w++) {
			System.out.print(array[w] + " ");
		}
		
	}
	
	public static int[] sortArray(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			int currentMin = list[i];
			int currentMinIndex = i;
			
			for (int j = i + 1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
		return list;
	}
}
