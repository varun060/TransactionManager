package com.bank.account.accountmanager.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.opencsv.CSVReader;
/**
 * class which holds
 * All util methods to help CSV reading
 * @author varun
 *
 */
public class CSVUtils {
	/**
	 * get CSV Reader using the file in specofoed location
	 * @return
	 * @throws FileNotFoundException
	 */
	public static CSVReader getCSVReader(String location) throws FileNotFoundException {
		 CSVReader csvReader = null; 
	       		// 
	           // csvReader = new CSVReader(new FileReader 
	            //("/home/varun/AccountManagement/test.csv")); 
	            
	            csvReader = new CSVReader(new FileReader 
	    	            (location)); 
	            return csvReader;
	        } 
	       
	

}
