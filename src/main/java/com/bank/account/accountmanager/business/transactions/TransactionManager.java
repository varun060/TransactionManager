package com.bank.account.accountmanager.business.transactions;

import java.util.List;

import com.bank.account.accountmanager.business.models.Transaction;
/**
 * Singleton class to store all transaction
 * in memory. Only one object will be created for this class 
 * Objects will be initialized during upload 
 * @author varun
 *
 */
public class TransactionManager {
	
	private List<Transaction> transactions;
	private static TransactionManager transManager;
	// private constructor 
	private TransactionManager() {
		
	}
	/**
	 * Method for getting singleton instance
	 * @return
	 */
	public static TransactionManager getTransactionManager() {
		if(null==transManager) {
			transManager=new TransactionManager();
		}
		return transManager;
		
	}

	/**
	 * Method for returning all transactions
	 * @return the transactions
	 */
	public List<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * Method for setting all transactions to singleton object
	 * @param transactions the transactions to set
	 */
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	

}
