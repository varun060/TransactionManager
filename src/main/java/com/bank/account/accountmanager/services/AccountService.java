package com.bank.account.accountmanager.services;

import org.springframework.stereotype.Service;

/**
 * interface for Account services
 * @author varun
 *
 */
@Service
public interface AccountService {
	

	public String uploadFile() throws Exception;

	public String getRelativeBalance(String accId, String fromDate, String toDate) throws Exception;

}
