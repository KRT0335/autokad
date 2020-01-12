package com.project2.model;

import java.util.ArrayList;
import java.util.List;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@JsonBackReference
	private List<Playlist> playlists = new ArrayList<>();

	
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Song(String songname, String artist, String lyrics) {
		super();
		this.songname = songname;
		this.artist = artist;
		this.lyrics = lyrics;
	}
	public Song(int songid, String songname, String artist, String lyrics) {
		super();
		this.songid = songid;
		this.songname = songname;
		this.artist = artist;
		this.lyrics = lyrics;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((lyrics == null) ? 0 : lyrics.hashCode());
		result = prime * result + ((playlists == null) ? 0 : playlists.hashCode());
		result = prime * result + songid;
		result = prime * result + ((songname == null) ? 0 : songname.hashCode());
		return result;
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

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (lyrics == null) {
			if (other.lyrics != null)
				return false;
		} else if (!lyrics.equals(other.lyrics))
			return false;
		if (playlists == null) {
			if (other.playlists != null)
				return false;
		} else if (!playlists.equals(other.playlists))
			return false;
		if (songid != other.songid)
			return false;
		if (songname == null) {
			if (other.songname != null)
				return false;
		} else if (!songname.equals(other.songname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Song [songid=" + songid + ", songname=" + songname + ", artist=" + artist + ", lyrics=" + lyrics
				+ ", playlists=" + playlists + "]";
	}
	
	

	
}
