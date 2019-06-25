package com.bank.account.accountmanager.business.transactions;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bank.account.accountmanager.business.models.OutputModel;
import com.bank.account.accountmanager.business.models.Transaction;

/**
 * Class to handle all business logic related
 * to balance calculations
 * @author varun
 *
 */
@Component
public class BalaneCalculator {

	/**
	 * Method to calculate relative balance using the logic defined
	 * It removes all transactions which are invalid using reverse transaction id
	 * @param fromDate 
	 * @param toDate
	 * @param accId account Id for which balance to be calclated 
	 * @return 
	 * @return
	 */
	public OutputModel calculateRelBalance(Date fromDate, Date toDate, String accId) {

		//declare and initialize output model
		OutputModel ouput=new OutputModel();		
		
		// get transactions from singleton class
		List<Transaction> listTrans=TransactionManager.getTransactionManager().getTransactions();
		// get all transactions in specified time period which are not reverse type
		List<Transaction> transList= listTrans.parallelStream().filter((trans)-> trans.getCreatedDate().after(fromDate)&&trans.getCreatedDate().before(toDate)
				&&(trans.getFromAccId().equals(accId)||trans.getToAccId().equals(accId))&&!trans.getTransType().equals("REVERSAL")).collect(Collectors.toList());
		// get all transactions after from time which are reversal
		List<Transaction> revTransList= listTrans.parallelStream().filter((trans)-> trans.getCreatedDate().after(fromDate)
				&&(trans.getToAccId().equals(accId)||trans.getFromAccId().equals(accId))&&trans.getTransType().equals("REVERSAL")).collect(Collectors.toList());;
				// traverse through reversals and remove from actual list
				for(Transaction revTrans:revTransList) {
					List<Transaction> tobeRemoved=transList.parallelStream().filter(trans->trans.getTransactionId().equals(revTrans.getRelatedTransId())).collect(Collectors.toList());
					transList.removeAll(tobeRemoved);
				}

				if(null!=transList&&!transList.isEmpty()) {
					// get debit and credit by filetering using from and to account
					double debit=transList.parallelStream().filter(tr->tr.getFromAccId().equals(accId)).mapToDouble(Transaction::getAmount).sum();
					double credit=transList.parallelStream().filter(tr->tr.getToAccId().equals(accId)).mapToDouble(Transaction::getAmount).sum();
					ouput.setBalance(0-debit+credit);
					ouput.setNoTrans(transList.size());
					
				}


				return ouput;
	}

}
