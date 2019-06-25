//Package for all business strategy executors
package com.bank.account.accountmanager.business.strategy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.bank.account.accountmanager.business.models.Transaction;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
/**
 * Strategy executor for balance calculation
 * This class will decide how to map CSV columns to class
 * Headers will be mapped to specific class variables depending on
 * the requirement
 * 
 * @author varun
 *
 */
@Component
public class TransactionStrategyExecutor {
	
	/**
	 * Method to define strategy by mapping CSV column to 
	 * Model class attributes
	 * @return
	 */
	public HeaderColumnNameTranslateMappingStrategy<Transaction> getStrategy(){
		
		 // Hashmap to map CSV data to  
        // Bean attributes. 
        Map<String, String> mapping = new 
                      HashMap<String, String>(); 
        mapping.put("transactionId", "transactionId"); 
        mapping.put("fromAccountId","fromAccId"); 
        mapping.put("toAccountId","toAccId"); 
        mapping.put("createdAt", "createdAt"); 
        mapping.put("amount", "amount"); 
        mapping.put("transactionType", "transType"); 
        mapping.put("relatedTransaction", "relatedTransId"); 
       
     // HeaderColumnNameTranslateMappingStrategy 
        // for Transaction class 
        HeaderColumnNameTranslateMappingStrategy<Transaction> strategy = 
             new HeaderColumnNameTranslateMappingStrategy<Transaction>(); 
        strategy.setType(Transaction.class); 
        strategy.setColumnMapping(mapping); 
        
        return strategy;
        
    
  
		
	}

}
