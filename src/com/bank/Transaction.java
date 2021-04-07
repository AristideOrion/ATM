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
	
	
	private Account  inAccount;
	
	
	
	public void update() {}

}
