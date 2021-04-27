package com.bank;

import java.util.ArrayList;

public  class Account {
	
	public String type;
	
	private User owner;
	
	private double balance;
	
	private String uuid;
	
	private ArrayList<Transaction> listTransactions;

	private String name;
	/**
	 * 
	 * @param name
	 * @param owner
	 * @param thebank
	 */
	public Account(String name, User owner, Bank thebank)
	{
		//set the account name and holder
		this.name=name;
		this.owner=owner;
		
		//get new account uuid
		this.uuid=thebank.getNewAccountUuid();
		
		//init Transactions
		this.listTransactions=new ArrayList<Transaction>();
		
		// add to owner and bank lists
		this.owner.addAccount(this);
		thebank.addAccount(this);
	}
	public void checkBalance()
	{
		
	}
	public String getUuid() {
		return this.uuid;
	}
	
	public Object getSummaryLine() {
		
		//get the account 's balance
		double balance =this.getBalance();
		
		if(balance>=0)
		{
			return String.format("Xs : $%.0.2F", this.uuid, balance, this.name);
		}else
			return String.format("Xs : $(%.02f) : Xs", this.uuid,balance,this.name);
	}
	
	
	public double getBalance() {
		double balanceVariable=0;
		for(Transaction t:this.listTransactions)
		{
			balanceVariable +=t.getAmount();
		}
		
		return balanceVariable;
		
	}
	
	/**
	 * Print transaction history
	 */
	public void printTransHistory() {
		System.out.printf("\nTransaction history for account %s\n",this.uuid);
		for(int i=this.listTransactions.size()-1;i>=0;i--)
		{
			System.out.printf(this.listTransactions.get(i).getSummaryLine());
		}
		System.out.println();
	}
	
	/**
	 * Add a new transaction
	 * @param amount
	 * @param memo
	 */
	public void addTransaction(double amount, String memo) {
		Transaction newTransaction=new Transaction(amount,memo,this);
		this.listTransactions.add(newTransaction);
	}

}
