package com.project2.service;

import java.util.List;

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
	
	public List<Song> getAllSongs(){
		return this.songRepository.findAll();
	}
	
	public Song findSongBySongid(int id) {
		return this.songRepository.findSongBySongid(id);
	}
	
	public Song findSongBySongnameAndArtistAndLyrics(String songname, String artist, String lyrics) {
		return this.songRepository.findSongBySongnameAndArtistAndLyrics(songname, artist, lyrics);
	}
}
