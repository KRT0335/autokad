package com.revature.service;

import org.springframework.stereotype.Service;

import com.revature.model.Playlist;
import com.revature.repository.PlaylistRepository;

@Service(value = "playlistService")
public class PlaylistService {

	private PlaylistRepository playlistRepository;

}
