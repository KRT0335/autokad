package com.project2.service;

import org.springframework.stereotype.Service;

import com.project2.repository.PlaylistRepository;
import com.project2.model.Playlist;

@Service(value = "playlistService")
public class PlaylistService {

	private PlaylistRepository playlistRepository;

	public <S extends Playlist> S save(Playlist p) {
		return playlistRepository.save(p);
	}

}
