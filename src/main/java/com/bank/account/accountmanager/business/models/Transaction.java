package com.bank.account.accountmanager.business.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Transaction model class for holding 
 * details of each transaction
 * @author varun
 *
 */
public class Transaction {
	
	private String transactionId;
	private String fromAccId;
	private String toAccId;
	private String createdAt;
	private float amount;
	private String transType;
	private String relatedTransId;
	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @return the fromAccId
	 */
	public String getFromAccId() {
		return fromAccId;
	}
	/**
	 * @param fromAccId the fromAccId to set
	 */
	public void setFromAccId(String fromAccId) {
		this.fromAccId = fromAccId;
	}
	/**
	 * @return the toAccId
	 */
	public String getToAccId() {
		return toAccId;
	}
	/**
	 * @param toAccId the toAccId to set
	 */
	public void setToAccId(String toAccId) {
		this.toAccId = toAccId;
	}
	/**
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}
	/**
	 * @return the transType
	 */
	public String getTransType() {
		return transType;
	}
	/**
	 * @param transType the transType to set
	 */
	public void setTransType(String transType) {
		this.transType = transType;
	}
	/**
	 * @return the relatedTransId
	 */
	public String getRelatedTransId() {
		return relatedTransId;
	}
	/**
	 * @param relatedTransId the relatedTransId to set
	 */
	public void setRelatedTransId(String relatedTransId) {
		this.relatedTransId = relatedTransId;
	}
	
	public Date getCreatedDate()  {
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
		try {
			return df.parse(createdAt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
