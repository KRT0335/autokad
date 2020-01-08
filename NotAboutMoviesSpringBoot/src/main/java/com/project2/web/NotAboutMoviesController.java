package com.project2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project2.service.AccountService;
import com.project2.model.SuperJoke;

@RestController(value = "NAMController")
@RequestMapping(value = "/nam")
public class NotAboutMoviesController {
	
	private AccountService accountService;

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * We're using setter injection.
	 */
	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	/*
	 * The "value" here denotes that we must use the "/home" pattern to access the
	 * resource that this method returns. This means that in order to access this
	 * view, we should type: /account/home
	 * 
	 * We've also specified that the only acceptable method is "GET".
	 */

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "This is suppose to be the home page";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		//This string refers to the name of a view we have created.
		return "index";
	}
	
	@GetMapping(value = "/favoritejoke")
	public SuperJoke getSuperJoke() {
		SuperJoke retrievedJoke = this.restTemplate.getForObject("http://api.icndb.com/jokes/random", SuperJoke.class);
		return retrievedJoke;
	}

}
