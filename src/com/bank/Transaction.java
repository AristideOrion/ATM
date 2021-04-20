package com.bank;

import java.util.Date;

/**
 * @author ADA
 *
 */
public class Transaction  {
	
	/*
	 * Specific id for the transaction
	 */
	private Integer transactionId;
	
	/*
	 * The time of this transaction
	 */
	private Date timestamp;
	
	/*
	 *  The type of transaction
	 */
	public String type;
	
	/*
	 * The ATM
	 */
	private ATM atm;
	
	/*
	 * A memo for this transaction
	 */
	private String memo;
	
	/**
	 * The account in which the transaction was performed.
	 */
	private Account  inAccount;

	private double amount;
	
	/**
	 * Create new Transaction
	 * @param amount
	 * @param inAccount
	 */
	public Transaction(double amount, Account inAccount)
	{
		this.amount=amount;
		this.inAccount=inAccount;
		this.timestamp=new Date();
		this.memo="";
		
	}
	
	
	public Transaction(double amount, String memo, Account inAccount)
	{
		this(amount,inAccount);
		this.memo=memo;
	}
	public void update() {}

	/**
	 * Get amount of the transaction
	 * @return
	 */
	public double getAmount() {
		// TODO Auto-generated method stub
		return this.amount;
	}

	/**
	 * Get amount of the transaction
	 * @return
	 */
	public String getSummaryLine() {
		if(this.amount>=0)
		{
			return String.format("Xs: $x.02f :Xs", this.timestamp.toString(),this.amount,this.memo);
		}else
		{
		return String.format("Xs: $x.02f) :Xs", this.timestamp.toString(),this.amount,this.memo);
		}
	}

}
