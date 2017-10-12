package com.epayment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epayment.entity.Account;
import com.epayment.entity.Transfer;
import com.epayment.service.AccountService;
import com.epayment.service.TransferService;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	TransferService transferService;

	@Autowired
	AccountService acountService;

	/**
	 * Add an account
	 * 
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/account/add", method = RequestMethod.POST)
	public ResponseEntity<?> addAccount(@RequestBody Account account) {
		logger.info("Creating a new account : {}", account);

		acountService.addAccount(account);

		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	/**
	 * Add a transfer
	 * 
	 * @param transfer
	 * @return
	 */
	@RequestMapping(value = "/transfer/add", method = RequestMethod.POST)
	public ResponseEntity<?> addTransfer(@RequestBody Transfer transfer) {
		logger.info("Adding a new transfer : {}", transfer);

		try {
			transferService.addTransfer(transfer);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
}