package com.project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.project2.model.Song;
import com.project2.repository.SongRepository;

@Configuration
@Service(value="songService")
public class SongService {

	@Autowired
	SongRepository songRepository;
	
	public void setSongRepository(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public void insertSong(Song s) {
		this.songRepository.save(s);
	}
}
