// package for all services
package com.bank.account.accountmanager.services;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bank.account.accountmanager.business.models.OutputModel;
import com.bank.account.accountmanager.business.models.Transaction;
import com.bank.account.accountmanager.business.strategy.TransactionStrategyExecutor;
import com.bank.account.accountmanager.business.transactions.BalaneCalculator;
import com.bank.account.accountmanager.business.transactions.TransactionManager;
import com.bank.account.accountmanager.utils.CSVUtils;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

/**
 * Class is to handle business logic on data that is received from 
 * repository/related  classes. Controllers will br the upstream classes and
 * data will be sent back after processing.
 * This class will directly access repository/Business related class to get objects 
 * mapped to table/Uploaded files
 * @author varun
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	// autowiring required objects
	@Autowired
	private TransactionStrategyExecutor strategyExec;
	@Autowired
	private BalaneCalculator balanceCalculator;
	@Value( "${csv.loaction}" )
	private String csvLoc;

	/**
	 * Method to upload CSV file.
	 * It uses in memory storage using singleton classes
	 * It executes strategy and maps CSV to objects and sets 
	 * singleton object
	 */
	public String uploadFile() throws Exception {
		String result="Success";
		try {
			// getting CSV reader 
			CSVReader csvReader=CSVUtils.getCSVReader(csvLoc);
			HeaderColumnNameTranslateMappingStrategy<Transaction> strategy =strategyExec.getStrategy();
			CsvToBean csvToBean = new CsvToBean(); 
			// call the parse method of CsvToBean 
			// pass strategy, csvReader to parse method 
			List<Transaction> listTrans = csvToBean.parse(strategy, csvReader); 
			// set singleton object
			TransactionManager.getTransactionManager().setTransactions(listTrans);	

		} catch (FileNotFoundException e) {
			result="Failure";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Method to calculate relative balance by passing details to business 
	 * logic . This method will translate data from controllers to business class
	 * understandable format
	 * @return String : balance information
	 */
	@Override
	public String getRelativeBalance(String accId,
			String paramFromDate, String paramToDate) throws Exception {
		String relBalance=null;
		// convert from and to date to Date format
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss"); 
		Date fromDate=df.parse(paramFromDate);
		Date toDate=df.parse(paramToDate);
		// call business logic to get relative balance
		OutputModel output=balanceCalculator.calculateRelBalance(fromDate,toDate,accId);
		relBalance="Balance is "+output.getBalance()+" Number of transaction "+output.getNoTrans();
		return relBalance;
	}



}
