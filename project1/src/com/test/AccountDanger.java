package com.test;

public class AccountDanger implements Runnable {
	private Account acct = new Account();
	public static void main (String [] args) {
		AccountDanger r = new AccountDanger();
		Thread one = new Abc(r);
		Thread two = new Abc(r);
		one.setName("Fred");
		two.setName("Lucy");
		one.start();
		two.start();
	}
	public void run() {
		for (int x = 0; x < 5; x++) {
			makeWithdrawal(10);
			if (acct.getBalance() < 0) {
				System.out.println("account is overdrawn!");
			}
		}
	}
	private void makeWithdrawal(int amt) {
		if (acct.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName()
					+ " is going to withdraw");
			try {
				Thread.sleep(500);
			} catch(InterruptedException ex) { }
			acct.withdraw(amt);
			System.out.println(Thread.currentThread().getName()
					+ " completes the withdrawal");
		} else {
			System.out.println("Not enough in account for "
					+ Thread.currentThread().getName()
					+ " to withdraw " + acct.getBalance());
		}
	}
}
class Account {
	private int balance = 50;
	public int getBalance() {
		return balance;
	}
	public void withdraw(int amount) {
		balance = balance - amount;
	}
}
class Abc extends Thread{
	AccountDanger ad;
	Abc(AccountDanger ad){
		this.ad=ad;
	}
	public void run(){
		System.out.println("inside run method of Abc class");
	}
}