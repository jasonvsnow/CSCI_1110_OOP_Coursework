/*
Author: Jason Snow
Date: 12/15/2020

This program has makes an Account Object which is a superclass of the SavingsAccountand CheckingsAccount objects. All of which have their toString() methods invoked and printed.
*/

import java.util.*;

public class Exercise11_03 {
	public static void main(String[] args) {
		Account test1 = new Account(140, 100);
		SavingsAccount test2 = new SavingsAccount(141, 145.45);
		CheckingsAccount test3 = new CheckingsAccount(142, 200);
		System.out.print(test1.toString() + "\n");
		System.out.print(test2.toString() + "\n");
		System.out.print(test3.toString() + "\n");
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
	public String toString() {
		return "Account\nID: " + id + " Balance: $" + balance + " Annual Interest Rate: %" + annualInterestRate/100 + " Date Created: " + dateCreated;
	}
}

class SavingsAccount extends Account {
	
	SavingsAccount(int id, double balance) {
		setID(id);
		setBalance(balance);
	}
	
	public void withdraw(double withdrawl) {
		double hold = getBalance();
		if ((hold - withdrawl) >= 0) setBalance(hold - withdrawl);
		else System.out.println("Insufficient funds to make this withdrawl.");
	}
	
	public String toString() {
		return "Savings Account\nID: " + getID() + " Balance: $" + getBalance() + " Annual Interest Rate: %" + getAnnualInterestRate()/100 + " Date: " + getDateCreated();
	}
}

class CheckingsAccount extends Account {
	private double overdraft;
	
	CheckingsAccount(int id, double balance) {
		setID(id);
		setBalance(balance);
		overdraft = 100;
	}
	
	public double gertOverdraft() {
		return overdraft;
	}
	
	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}
	
	public void withdraw(double withdrawl) {
		double hold = getBalance();
		if ((hold - withdrawl) >= -overdraft) setBalance((hold - withdrawl));
		else System.out.println("This withdrawl exceeds overdraft limit.");
	}
	
	public String toString() {
		return "Savings Account\nID: " + getID() + " Balance: $" + getBalance() + " Overdraft Limit: $" + overdraft + " Annual Interest Rate: %" + getAnnualInterestRate()/100 + " Date: " + getDateCreated();
	}

}

