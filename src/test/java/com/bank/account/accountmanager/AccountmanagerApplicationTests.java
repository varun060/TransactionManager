// package for all test cases
package com.bank.account.accountmanager;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.account.accountmanager.business.models.OutputModel;
import com.bank.account.accountmanager.business.transactions.BalaneCalculator;

/**
 * Test class to run basic testing features to 
 * ensure that code doesn't break
 * after updates in classes
 * @author varun
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountmanagerApplicationTests {

	// declare Rest service related variables
	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();


	/**
	 * Test case for checking REST service which provides account
	 * details.
	 * It executes calls REST API and validates results
	 * with expected result
	 * @throws Exception
	 */
	@Test
	public void testMarketAnalysisRESTApi() throws Exception {

		BalaneCalculator bc=new BalaneCalculator();
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss"); 
		Date fromDate=df.parse("20-10-2018 2012:00:00");
		Date toDate=df.parse("20-10-2018 2019:00:00");
		OutputModel op=bc.calculateRelBalance(fromDate, toDate, "ACC334455");
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		// calls relative balance rest service for ACC334455
		ResponseEntity<String> response = restTemplate.exchange(
				"http://localhost:8102/uploadCSV", HttpMethod.GET, entity,
				String.class);
		// compares with expected result
		// validating expected result and result from REST API
		String received="Balance is "+op.getBalance()+" Number of transaction "+op.getNoTrans();
		String expected="Balance is -25.0 Number of transaction 1";
		assertEquals(received, expected, false);
		


	}




}
