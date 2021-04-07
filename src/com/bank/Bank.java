package com.bank;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Bank {

	public static final String code = "Ax12856448484";
	public static final String address = "18 avenue Mac Donald 7719";

	private List<Customer> customersBank;
	private ATM atm;
	private List<Account> accountsBank;
	private List<User> users;

	public void manages(DebitCard debtCard) {

	}

	public void maintains() {
	}

	/**
	 * Provide unique uuid
	 * @return
	 */
	public String getNewUiid() {
		
		String uuid;
		Random rng = new Random();
		int lenght =6;
		Boolean nonUnique=false;
		
		//continue looping until we get a unique ID
		
		do {
			uuid = "";
			for (int i = 0; i < lenght; i++) {
				uuid += ((Integer) rng.nextInt(10)).toString();
			}
			
			// check to make sure it's unique
			for (User u : this.users) {
				if (uuid.compareTo(u.getUuid()) == 0) {
					nonUnique = true;
					break;
				}
				
			}
			
		} while (nonUnique);
		
		return uuid;
	}

	public String getNewAccountUuid() {
		String uuid;
		Random rng = new Random();
		int lenght =10;
		Boolean nonUnique=false;
		
		//continue looping until we get a unique ID
		
		do {
			uuid = "";
			for (int i = 0; i < lenght; i++) {
				uuid += ((Integer) rng.nextInt(10)).toString();
			}
			
			// check to make sure it's unique
			for (Account ac : this.accountsBank) {
				if (uuid.compareTo(ac.getUuid()) == 0) {
					nonUnique = true;
					break;
				}
				
			}
			
		} while (nonUnique);
		
		return uuid;
	}

	public void addAccount(Account account) {
		this.accountsBank.add(account);
	}
}
