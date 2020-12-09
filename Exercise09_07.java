/*
 * Author: Jason Snow
 * Date: 12/9/2020
 * 
 * This program creates an account object and a test program that withdraws $2,500 then deposits $3,000 before printing the balance, the monthly interest, and the date the account was created)
 */
import java.util.*;

public class Exercise09_07 {
	public static void main(String[] args) {
		Account account1 = new Account(1122, 20000);
		account1.setAnnualInterestRate(4.5);
		account1.withdraw(2500);
		account1.deposit(3000);
		System.out.printf("Balance: $%,.2f\nMonthly Interest: $%,.2f\n", account1.getBalnace(), account1.getMonthlyInterest());
		System.out.printf("%1$s %2$tB %2$td, %2$tY","Date Created:", account1.getDateCreated());
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
	public double getBalnace() {
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

