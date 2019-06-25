package com.bank.account.accountmanager.business.models;
/**
 * Class to handle output 
 * @author varun
 *
 */
public class OutputModel {
	//number of transactions
	private int noTrans;
	private double balance;
	/**
	 * @return the noTrans
	 */
	public int getNoTrans() {
		return noTrans;
	}
	/**
	 * @param noTrans the noTrans to set
	 */
	public void setNoTrans(int noTrans) {
		this.noTrans = noTrans;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
