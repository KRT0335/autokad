package com.project2.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project2.service.AccountService;
import com.project2.model.Account;
import com.project2.model.SuperJoke;

@RestController(value = "NAMController")
@RequestMapping(value = "/nam")
public class NotAboutMoviesController {

	private AccountService accountService;

	private RestTemplate restTemplate;

	/*
	 * We're using setter injection.
	 */
//	@Autowired
//	public void setAccountService(AccountService accountService) {
//		this.accountService = accountService;
//	}

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

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		// This string refers to the name of a view we have created.
		return "index";
	}

//	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
//	public List<Account> getAllAccounts() {
//		return this.accountService.findAllAccounts();
//	}
/*
	@GetMapping(value = "/lyrics")
	public String getApi() {
		restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
		httpHeaders.set("x-rapidapi-host", "mourits-lyrics.p.rapidapi.com");
		httpHeaders.add("x-rapidapi-key", "2220a256eamshe293e8ca0d6332dp1f3c26jsncc1dd78ca7e0");
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("file", "123");
		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, httpHeaders);
		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		URI uri = null;
		try {
			uri = new URI("https://mourits-lyrics.p.rapidapi.com/?q=we%20burn%20a%20beautiful%20flame");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		ResponseEntity<String> responseEntity = this.restTemplate.exchange(
//				"mourits-lyrics.p.rapidapi.com",
//				HttpMethod.GET,
//				httpEntity, String.class);
//		String str = responseEntity.getBody();
//		String str = this.restTemplate.getForObject("mourits-lyrics.p.rapidapi.com", String.class);
//		return httpHeaders.toString() + "\n " + requestEntity.toString();
//		String str = this.restTemplate.postForEntity(uri, requestEntity, String.class).getBody().toString();
		String str = this.restTemplate.postForEntity(uri, requestEntity, String.class).toString();
		return str;
//		return this.restTemplate.getForObject("mourits-lyrics.p.rapidapi.com", Lyrics.class);
//		return responseEntity;
	}
*/

	@GetMapping(value = "/favoritejoke")
	public SuperJoke getSuperJoke() {
		restTemplate = new RestTemplate();
		SuperJoke retrievedJoke = this.restTemplate.getForObject("http://api.icndb.com/jokes/random", SuperJoke.class);
		return retrievedJoke;
	}

	
}
