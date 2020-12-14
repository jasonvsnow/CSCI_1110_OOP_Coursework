/*
 * Author: Jason Snow
 * Date: 12/9/2020
 * 
 * This program creates a MyInteger object and then tests all the methods within it.
 */


public class Exercise10_03 {
	public static void main(String[] args) {
		MyInteger hold = new MyInteger(7);
		MyInteger compare = new MyInteger(10);
		System.out.println("hold.getValue() test: " + hold.getValue());
		System.out.println("compare.getValue() test: " + compare.getValue());
		System.out.println("");
		System.out.println("Test for group of three nonstatic methods");
		System.out.printf("hold.isEven() test: %b\nhold.isOdd() test: %b\nhold.isPrime() test: %b\n", hold.isEven(), hold.isOdd(), hold.isPrime());
		System.out.println("");
		System.out.println("Test for three static(int) methods");
		System.out.printf("MyInteger.isEven(10): %b\nMyInteger.isOdd(10): %b\nMyInteger.isPrime(10): %b\n", MyInteger.isEven(10), MyInteger.isOdd(10), MyInteger.isPrime(10));
		System.out.println("");
		System.out.println("Test for three static(MyInteger) methods");
		System.out.printf("MyInteger.isEven(hold): %b\nMyInteger.isOdd(hold): %b\nMyInteger.isPrime(hold): %b\n", MyInteger.isEven(hold), MyInteger.isOdd(hold), MyInteger.isPrime(hold));
		System.out.println("");
		System.out.printf("\nTest for non-static hold.equals(7): %b", hold.equals(7));
		System.out.printf("\nTest for non-static hold.equals(compare): %b\n", hold.equals(compare));
		System.out.println("");
		char[] array = {'1', '2', '3'};
		System.out.println("Char[] array = {'1', '2', '3'}");
		System.out.printf("Test for MyInteger.parseInt(array): %d\n", MyInteger.parseInt(array));
		System.out.printf("Test for MyInteger.parseInt(\"456\"): %d", MyInteger.parseInt("456"));
		


	}
}

class MyInteger {
	private int value;
	
	MyInteger(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	//first set
	public boolean isEven() {
		return this.value%2 == 0;
	}
	public boolean isOdd() {
		return this.value%2 == 1;
	}
	public boolean isPrime() {
		if(this.value <= 1) return false;
	    for (int i = 2; i <= this.value/2; i++) {
	    	if (this.value % i == 0) return false;
	    }
	    return true;
	}
	
	//second set
	public static boolean isEven(int value) {
		return value%2 == 0;
	}
	public static boolean isOdd(int value) {
		return value%2 == 1;
	}
	public static boolean isPrime(int value) {
		if(value <= 1) return false;
	    for (int i = 2; i <= value/2; i++) {
	    	if (value % i == 0) return false;
	    }
	    return true;
	}
	
	//third set
	public static boolean isEven(MyInteger c) {
		int value = c.getValue();
		return value%2 == 0;
	}
	public static boolean isOdd(MyInteger c) {
		int value = c.getValue();
		return value%2 == 1;
	}
	public static boolean isPrime(MyInteger c) {
		int value = c.getValue();
		if(value <= 1) return false;
	    for (int i = 2; i <= value/2; i++) {
	    	if (value % i == 0) return false;
	    }
	    return true;
	}
	
	//equals
	public boolean equals(int value) {
		return this.value == value;
	}
	public boolean equals(MyInteger c) {
		return this.value == c.getValue();
	}
	
	public static int parseInt(char[] array) {
		String hold = "";
		for (int i = 0; i < array.length; i++) {
			hold += array[i];
		}
		return MyInteger.parseInt(hold);
	}
	public static int parseInt(String hold) {
		return Integer.parseInt(hold);
	}

}
