package com.revature.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Account;
import com.revature.model.SuperJoke;
import com.revature.service.AccountService;

/*
 * @RestController is a more specific controller that writes to the response body. It
 * is actually a convenient way of specifying:
 * 
 * @Controller
 * @ResponseBody
 */
@RestController(value = "accountController")
/*
 * This provides a way of mapping this entire controller to a certain url
 * pattern.
 */
@RequestMapping(value = "/account")
public class AccountController {

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
	 * view, we should type: /superpet/home
	 * 
	 * We've also specified that the only acceptable method is "GET".
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index() {
		// This string refers to the name of a view we have created.
		return "This should be the home page";
	}

	/*
	 * This is a more specific version of @RequestMapping. It specifies that this
	 * endpoint only accepts GET requests. We have also specified that this endpoint
	 * should return JSON.
	 */
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	/*
	 * This annotation denotes that this method should write to the response body as
	 * the generic @Controller annotation does not write to the response body by
	 * default. It attempts to resolve what you return as a view.
	 */
	@ResponseBody
	public List<Account> getAllAccounts() {
		return this.accountService.findAllAccounts();
	}

//	@GetMapping(value = "/one/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Account getSuperPetByName(@PathVariable String name) {
//
//		return this.accountService.getSuperPetByName(name);
//	}
//
//	@GetMapping(value = "/one/{power}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Account getSuperPetByPower(@PathVariable String power) {
//
//		return this.accountService.getSuperPetByName(power);
//	}

	/*
	 * Note that the PathVariable is simply appended to the url with a "/". We have
	 * an alternative to this PathVariable, which is the @RequestParam annotation.
	 * This instead allows us to take in a query string as a parameter in one of our
	 * methods.
	 */

//	@GetMapping(value = "/one/again", produces = MediaType.APPLICATION_JSON_VALUE)
	/*
	 * When using the @RequestParam annotation, be sure that the parameter names you
	 * append to the url match the RequestParam names specified in the method
	 * signature.
	 * 
	 * NOTE: We are now going to refactor this method to use a ResponseEntity
	 * instead. ResponseEntity contain what you will send back to the client (so the
	 * payload) as well as a status code.
	 */
//	public ResponseEntity<SuperPet> getSuperPetByNameAgain(@RequestParam String name) {
//
//		SuperPet retrievedSuperPet = this.accountService.getSuperPetByName(name);
//
//		if (retrievedSuperPet == null) {
//			throw new NoSuchSuperPetException();
//		}
//
//		else {
//			return new ResponseEntity<>(retrievedSuperPet, HttpStatus.OK);
//		}
//	}

	/*
	 * We can use the @RequestBody annotation to grab information from the Request
	 * Body and immediately marshal it into a Java object. Note that this actually
	 * uses the Jackson ObjectMapper under the hood.
	 */
//	@PostMapping(value = "/new")
//	public void postSuperPet(@RequestBody SuperPet superPet) {
//		this.accountService.insertSuperPet(superPet);
//	}

	@GetMapping(value = "/favoritejoke")
	public SuperJoke getSuperJoke() {
		SuperJoke retrievedJoke = this.restTemplate.getForObject("http://api.icndb.com/jokes/random", SuperJoke.class);
		return retrievedJoke;
	}

}
