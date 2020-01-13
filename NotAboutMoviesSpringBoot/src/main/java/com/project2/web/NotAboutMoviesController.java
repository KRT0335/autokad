package com.project2.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.project2.model.Account;
import com.project2.model.MouritsResult;
import com.project2.model.Playlist;
import com.project2.model.Song;
import com.project2.model.SuperJoke;
import com.project2.service.AccountService;
import com.project2.service.PlaylistService;
import com.project2.service.SongService;

@RestController(value = "NAMController")
@RequestMapping(value = "/nam")
public class NotAboutMoviesController {

	private AccountService accountService;
	private PlaylistService playlistService;
	private SongService songService;

	private RestTemplate restTemplate;

	final String origin = "http://localhost:4200";

	/*
	 * We're using setter injection.
	 */
	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@Autowired
	public void setPlaylistService(PlaylistService playlistService) {
		this.playlistService = playlistService;
	}

	@Autowired
	public void setSongService(SongService songService) {
		this.songService = songService;
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

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		// This string refers to the name of a view we have created.
		return "index";
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Account> getAllAccounts() {

		return this.accountService.findAllAccounts();

	}

	@GetMapping(value = "/new")
	public void postAccount() {
		this.accountService.insertAccount(new Account("name", "username", "password"));
	}

	@GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public Account getAccountByCredentials() {
		String u = "username";
		String p = "password";
		return this.accountService.findAccountByCredentials(u, p);
	}

	@CrossOrigin(origins = origin)
	@GetMapping(value = "/login/{username}/{password}")
	public Account login(@PathVariable("username") String username, @PathVariable("password") String password) {
		Account acc = this.accountService.findAccountByCredentials(username, password);

		if (acc != null) {
			return acc;
		}
		return null;
	}

	@CrossOrigin(origins = origin)
	@GetMapping(value = "/register/{name}/{username}/{password}")
	public Account register(@PathVariable("name") String name, @PathVariable("username") String username,
			@PathVariable("password") String password) {
		List<Account> acc = this.accountService.findAccountByCredentialsCheck(username, password);

		if (!acc.isEmpty()) {
			return null;
		}

		Account newAcc = new Account(name, username, password);
		this.accountService.insertAccount(newAcc);
		return newAcc;
	}

	@GetMapping(value = "/playlist/new")
	public void insertPlaylist() {
		this.playlistService.insertPlaylist(
				new Playlist(1, "My Hot Track", new Account("Owner of sick track", "username", "password")));
	}
	
	@CrossOrigin(origins = origin)
	@GetMapping(value = "/playlist/new/{playlistname}/{userpk}")
	public void insertNewPlaylist(@PathVariable("playlistname") String playlistname, @PathVariable("userpk") int userpk) {
		Account account = findAccountById(userpk);
		this.playlistService.insertPlaylist(new Playlist(playlistname, account));

	}

	@GetMapping(value = "/playlist/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Playlist> getAllPlaylists() {
		return this.playlistService.findAllPlaylists();
	}

	@CrossOrigin(origins = origin)
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Account findAccountById(@PathVariable("id") int id) {
		return this.accountService.findAccountById(id);
	}

	@GetMapping(value = "/song/new")
	public void insertSong() {

		this.songService.insertSong(new Song("songname", "artist", "lyrics"));
	}

	@GetMapping(value = "/song/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Song> getAllSongs() {
		return this.songService.getAllSongs();
	}

	@GetMapping(value = "/song/add/{playlistid}/{songid}")
	public void insertRelation(@PathVariable("playlistid") int playlistid, @PathVariable("songid") int songid) {
		Playlist tempPlaylist = this.playlistService.findPlaylistById(playlistid);
		Song tempSong = this.songService.findSongBySongid(songid);
		List<Playlist> tempPlaylistList = tempSong.getPlaylists();
		List<Song> tempSongList = tempPlaylist.getSongs();
		tempPlaylistList.add(tempPlaylist);
		tempSongList.add(tempSong);
		tempSong.setPlaylists(tempPlaylistList);
		tempPlaylist.setSongs(tempSongList);
		this.playlistService.insertPlaylist(tempPlaylist);
		this.songService.insertSong(tempSong);
	}

	@GetMapping(value = "/lyrics/q/{q}")
	public Song getSongs(@PathVariable("q") String q) {
		final String url = "https://mourits-lyrics.p.rapidapi.com/?q=" + q;
		restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json");
		httpHeaders.add("User-Agent", "Mozilla/5.0");
		httpHeaders.add("X-RapidAPI-Host", "mourits-lyrics.p.rapidapi.com");
		httpHeaders.add("X-RapidAPI-Key", "2220a256eamshe293e8ca0d6332dp1f3c26jsncc1dd78ca7e0");

		try {
			HttpEntity<String> entity = new HttpEntity<String>("String", httpHeaders);
			ResponseEntity<MouritsResult> respEntity = this.restTemplate.exchange(url, HttpMethod.GET, entity,
					MouritsResult.class);

			MouritsResult result = respEntity.getBody();
			Song song = new Song(result.getSongname(), result.getArtist(), result.getResult().getLyrics());
			return song;
		} catch (UnknownHttpStatusCodeException e) {
			return new Song("API NO WORK", "UH OH", "The API Mourits Lyrics is down.");
		}

	}

	@GetMapping(value = "/favoritejoke")
	public SuperJoke getSuperJoke() {
		restTemplate = new RestTemplate();
		SuperJoke retrievedJoke = this.restTemplate.getForObject("http://api.icndb.com/jokes/random", SuperJoke.class);
		return retrievedJoke;
	}

}
