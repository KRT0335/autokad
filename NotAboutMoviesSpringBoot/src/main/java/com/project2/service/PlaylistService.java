package com.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.project2.model.AllPlaylist;
import com.project2.model.Playlist;
import com.project2.repository.PlaylistRepository;

@Configuration
@Service(value = "playlistService")
public class PlaylistService {

	@Autowired
	PlaylistRepository playlistRepository;

//	public PlaylistService(PlaylistRepository playlistRepository) {
//		super();
//		this.playlistRepository = playlistRepository;
//	}
	
	public void setPlaylistRepository(PlaylistRepository playlistRepository) {
		this.playlistRepository = playlistRepository;
	}

	public void insertPlaylist(Playlist p) {
		this.playlistRepository.save(p);
	}
	
	public List<Playlist> findAllPlaylists(){
		return this.playlistRepository.findAll();
	}
	
	public List<AllPlaylist> giveMeAllOfThePlaylists(){
		return this.playlistRepository.findAllAllPlaylist();
	}

}
