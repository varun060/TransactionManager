

/**
 * Package for all controllers
 */
package com.bank.account.accountmanager.controller;

//import logs and spring related classes
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.accountmanager.services.AccountService;


/**
 * Class to handle requests from UI
 * It passes relevant parameters from UI to
 * Service classes
 * @author Varun K R
 *
 */
@RestController
public class AccountRequestController {

	// account business logic object declaration
	@Autowired
	private AccountService accountService;

	

	// log declaration
	private static final Logger logger = LogManager.getLogger(AccountRequestController.class);

	/**
	 * Method calls service layer by passing relevant arguments
	 * to upload CSV file by mapping columns to class variables
	 * 
	 * @return
	 */
	@RequestMapping("/uploadCSV") String uploadCSV(){
		logger.info("getting started uploading");
		// call account service to get CSV Reader and set singleton object
		try {
			return accountService.uploadFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Ended uploading"); 
		return "Error";

	}
	
	

/**
 * Method to handle user request to get relative balance
 * It calls service layer for processing the request by passing required parameters
 * @param accId
 * @param fromDate
 * @param toDate
 * @return
 * @throws Exception
 */
	@RequestMapping("/balance/{accId}/{fromdate}/{todate}")
	public String getRelativeBalance(@PathVariable (value = "accId") String accId,
			@PathVariable (value = "fromdate") String fromDate,@PathVariable (value = "todate") String toDate	) throws Exception {

		logger.info("getting relative balance of "+accId); 

		if(null!=accId&&null!=fromDate&&null!=toDate) {
			// calling service layer
			return accountService.getRelativeBalance(accId,fromDate,toDate);
		}

		return null;
	}






}
