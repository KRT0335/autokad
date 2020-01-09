package com.project2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="songs")
public class Song {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="songid", columnDefinition = "serial")
	private int songid;
	@Column
	private String songname;
	@Column
	private String artist;
	@Column
	private String lyrics;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "songs")
	private Set<Playlist> playlists = new HashSet<>();
	
	private boolean success;
	private SongResult result;

	
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	//From/For Mourits API retrieve
	public Song(boolean success, SongResult result, String artist, String songname) {
		super();
		this.success = success;
		this.result = result;
		this.artist = artist;
		this.songname = songname;
	}
	public Song(int songid, String songname, String artist, String lyrics) {
		super();
		this.songid = songid;
		this.songname = songname;
		this.artist = artist;
		this.lyrics = lyrics;
	}
	public int getSongid() {
		return songid;
	}
	public void setSongid(int songid) {
		this.songid = songid;
	}
	public String getSongname() {
		return songname;
	}
	public void setSongname(String songname) {
		this.songname = songname;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	

	public boolean isSucces() {
		return success;
	}

	public void setSucces(boolean succes) {
		this.success = succes;
	}

	public SongResult getResult() {
		return result;
	}

	public void setResult(SongResult result) {
		this.result = result;
	}


}
