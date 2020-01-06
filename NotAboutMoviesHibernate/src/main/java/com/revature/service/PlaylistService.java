package com.revature.service;

import com.revature.model.Playlist;
import com.revature.repository.PlaylistRepository;
import com.revature.repository.PlaylistRepositoryImpl;

public class PlaylistService {

	PlaylistRepository pr = new PlaylistRepositoryImpl();

	public void insertPlaylist(Playlist p) {
		pr.insertPlaylist(p);
	}
}
