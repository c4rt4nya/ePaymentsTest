package com.mifinity.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mifinity.entity.CreditCard;
import com.mifinity.entity.User;
import com.mifinity.service.CreditCardService;
import com.mifinity.service.UserService;
import com.mifinity.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	UserService userService;

	@Autowired
	CreditCardService creditCardService;

	/**
	 * Login a user by its username and password
	 * 
	 * @param user
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		logger.info("Login User : {}", user);

		String userId = "";
		User persistedUser = userService.userExist(user);
		if (persistedUser != null) {
			userId = persistedUser.getId().toString();
		}

		ResponseEntity<String> response = new ResponseEntity<String>(userId, new HttpHeaders(), HttpStatus.OK);
		return response;
	}

	/**
	 * Create a user by its username and password
	 * 
	 * @param user
	 * @param ucBuilder
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", user);

		if (userService.userNameExist(user.getUserName())) {
			logger.error("Unable to create. A User with name {} already exist", user.getUserName());
			return new ResponseEntity(
					new CustomErrorType("Unable to create. A User with name " + user.getUserName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		userService.newUser(user);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	/**
	 * Search the credit cards by a number and a user id
	 * 
	 * @param number
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/creditCard/search/{cardNumber}/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> search(@PathVariable("cardNumber") String number, @PathVariable("userId") long userId) {
		logger.info("Searching credit cards : {}", number);

		List<CreditCard> creditCardsList = creditCardService.searchCreditCard(number, userId);
		ObjectMapper mapper = new ObjectMapper();

		String creditCardsJSON = null;
		try {
			creditCardsJSON = mapper.writeValueAsString(creditCardsList);
		} catch (JsonProcessingException error) {
			logger.error(error.toString());
		}
		return new ResponseEntity<String>(creditCardsJSON, new HttpHeaders(), HttpStatus.OK);
	}

	/**
	 * Add a credit card
	 * 
	 * @param creditCard
	 * @param ucBuilder
	 * @return
	 */
	@RequestMapping(value = "/creditCard/add/", method = RequestMethod.POST)
	public ResponseEntity<?> createCreditCard(@RequestBody CreditCard creditCard, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Credit Card : {}", creditCard);

		creditCardService.addCard(creditCard);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/creditCard/{id}").buildAndExpand(creditCard.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
}