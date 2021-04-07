package com.bank;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

	private String firstname;
	
	private String lastname;
	
	private String uuid;
	
	private byte pinHash[];
	
	private ArrayList<Account> accounts;
	
	/**
	 * Create new user
	 * @param firstane
	 * @param lastname
	 * @param pin
	 * @param theBank
	 */
	
	public User(String firstane, String lastname,  String pin, Bank theBank) 
	{
		// set user's name
		this.firstname=firstane;
		this.lastname=lastname;
		
		// Store the pin's MD5 hash
		try {
			MessageDigest md5=MessageDigest.getInstance("MD5");
			this.pinHash=md5.digest(pin.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		this.uuid=theBank.getNewUiid();
		
		//Create empty list account
		this.accounts=new ArrayList<Account>();
		
		//print log messsage
		System.out.printf("New User created "+ lastname, firstane, this.uuid+"");
	}

	/**
	 * Add an account
	 * @param account
	 */
	public void addAccount(Account account) {
			this.accounts.add(account);
	}

	public String getUuid() {
		// TODO Auto-generated method stub
		return this.uuid;
	}
}
