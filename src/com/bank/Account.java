package com.bank;

import java.util.ArrayList;

public abstract class Account {
	
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
		// TODO Auto-generated method stub
		return this.uuid;
	}

}
