package com.bank;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class ATM {
	
	public String location;
	public String managedBy;
	private Bank bank;
	private List<Transaction> listAtmTransactions;
	
	public static void main(String[] args) {
		
		//Init Scanner
		Scanner sc = new Scanner(System.in);
		
		//Init Bank
		Bank theBank = new Bank("Bank of pontault");
		
		//add a user which also create a saving account
		User aUser=theBank.addUser("Aristide", "IT","34556");
		
		//add a check account for our user
		Account newAccount=new Account("Checking",aUser,theBank);
		aUser.addAccount(newAccount);
		theBank.addAccount(newAccount);
		
		User curUser;
		while(true) {
			
			//Stay in the login prompt until Successful login
			curUser=ATM.mainMenuPromt(theBank, sc);
			
			// Stay here until user quits
			ATM.printUserMenu(curUser, sc);
			
		}
		
	}
	
	private static void printUserMenu(User curUser, Scanner sc) {
		//Print a summary of the user's accounts
		curUser.printAccountSummary();
		
		//Choice
		int choice;
		
		do {
			System.out.println("1) Show account transaction history");
			System.out.println("2) Withdrawl");
			System.out.println("3) Deposit");
			System.out.println("4) Transfert");
			System.out.println("5) Quit");
			System.out.println();
			System.out.println("Enter choice");
			choice=sc.nextInt();
			
			if(choice <1 || choice>5)
			{
				System.out.println("Invalid choice. Please choose 1-5");
			}
		} while (choice <1 || choice>5);
		
		switch(choice)
		{
			case 1:
				ATM.showTransHistory(curUser, sc);
				break;
			case 2:
				ATM.withdrawlFunds(curUser, sc);
				break;
			case 3:
				ATM.depositFunds(curUser, sc);
				break;
			case 4:
				ATM.transferFunds(curUser, sc);
				break;
		}
		if(choice !=5) {
			ATM.printUserMenu(curUser, sc);
		}
		
	}

	public static void transferFunds(User curUser, Scanner sc) {
		//inits
		int fromAcct;
		int toAcct;
		double amount;
		double acctBal;
		
		//get the account to transfer from
		do {
			System.out.println("Enter the number of the account to transfer");
			fromAcct=sc.nextInt();
			if(fromAcct<0 || fromAcct>=curUser.numAccounts()) {
				System.out.println("Invalid account. Please try again");
			}
		} while (fromAcct<0 || fromAcct>=curUser.numAccounts());
		acctBal=curUser.getAcctBalance(fromAcct);
		
		//get the account transfer to
		do {
			System.out.println("Enter the number of the account which provide");
			toAcct=sc.nextInt();
			if(toAcct<0 || toAcct>=curUser.numAccounts()) {
				System.out.println("Invalid account. Please try again");
			}
		} while (toAcct<0 || toAcct>=curUser.numAccounts());
		
		//get the account transfer to
				do {
					System.out.printf("Enter the amount to transfer (max $%.02f):$",acctBal);
					amount=sc.nextDouble();
					if(amount<0) {
						System.out.println("Amount must be greater than zero.");
					}else if(amount > acctBal)
					{
						System.out.printf("Amount must be greater than\n", "Balance of $x.02f.\n",acctBal);
					}
				} while (amount<0 || amount>=acctBal);
		//finally, do the transfer
		curUser.addAccTransaction(fromAcct, -1*amount, String.format("Transfert to account %s",curUser.getAcctUUID(toAcct)));
	
	}

	private static User mainMenuPromt(Bank theBank, Scanner sc) {
		String userID;
		String pin;
		User authUser;
		
		do {
			System.out.printf("\nWelcome to %x", theBank.geName());
			System.out.println("Enter user ID");
			userID=sc.nextLine();
			System.out.print("Enter pin");
			pin=sc.nextLine();
			
			authUser=theBank.userLogin(userID, pin);
			if(authUser==null) {
				System.out.println("Incorrect user ID/pin combinaison, please try ag");
			}
		}while(authUser==null);
		
		return authUser;
	}

	public void identities() {
		
	}
	
	public void transactions() {};

	public static void showTransHistory(User curUser, Scanner sc) {
		 int theAcct;
		 
		 //get account whose transaction history to look at
		 do {
			 System.out.printf("Enter the number(1-%d) of the account" + "whose transactions you want to see ",curUser.numAccounts());
			 theAcct=sc.nextInt()-1;
			 if(theAcct < 0 || theAcct >= curUser.numAccounts())
			 {
				 System.out.println("Invalid account.Please try again");
				 
			 }
			 
		 }while(theAcct < 0 || theAcct >= curUser.numAccounts());
	 curUser.printTransactionHistory(theAcct);
	}
}
