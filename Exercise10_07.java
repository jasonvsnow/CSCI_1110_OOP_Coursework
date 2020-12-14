/*
 * Author: Jason Snow
 * Date: 12/14/2020
 * 
 * This program reperesnts an ATM that has ten accounts with ids 0-9 and an initial balance of $100. Users enter valid IDs to choose an account and then can check balance, withdraw, or deposit money before exiting to choose a different account. The loop to choose an account never stops.
 */
import java.util.*;

public class Exercise10_07 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Account[] idStore = new Account[10]; 
		for (int i = 0; i < idStore.length; i++) {
			idStore[i] = new Account(i, 100);
		}
		boolean forever = true;
		while (forever == true) {
			System.out.print("Enter an id: ");
			int check = input.nextInt();
			boolean valid = false;
			for (int c = 0; c < idStore.length; c++) {
				if (check == idStore[c].getID()) {
					valid = true;
					break;
				}
			}
			if (valid == true) {
				boolean main = true;
				while (main == true) {
					System.out.println("Main Menu");
					System.out.println("1: check balance");
					System.out.println("2: withdraw");
					System.out.println("3: deposit");
					System.out.println("4: exit");
					System.out.print("Enter a choice: ");
					int choice = input.nextInt();
					if (choice == 1) {
						System.out.printf("The balance is $%.2f\n\n", idStore[check].getBalance());
					}
					else if (choice == 2) {
						System.out.print("Enter an amount to withdraw: ");
						double with = input.nextDouble();
						idStore[check].withdraw(with);
						System.out.println("");
					}
					else if (choice == 3) {
						System.out.print("Enter an amount to deposit: ");
						double dep = input.nextDouble();
						idStore[check].deposit(dep);
						System.out.println("");
					}
					else if (choice == 4) {
						main = false;
						System.out.println("");
					}
					else System.out.println("Invalid choice.");
				}
			}
			else System.out.println("Please enter valid ID.");
		}
	}
}

class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
		
	Account() {
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		dateCreated = new Date();
	}
	
	Account(int newID, double newBalance) {
		id = newID;
		balance = newBalance;
		dateCreated = new Date();
	}
	
	public int getID() {
		return id;
	}
	public void setID(int newID) {
		id = newID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double newBalance) {
		balance = newBalance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double newAnnualInterestRate) {
		annualInterestRate = newAnnualInterestRate;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public double getMonthlyInterestRate() {
		return annualInterestRate/12;
	}
	public double getMonthlyInterest() {
		return balance * (getMonthlyInterestRate()/100);
	}
	public void withdraw(double withdrawl) {
		balance -= withdrawl;
	}
	public void deposit(double depositAmount) {
		balance += depositAmount;
	}
	
}

