package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "playlist")
public class Playlist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String playListName;
	@Column
	private String songs;
	
	public Playlist() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Playlist(int id, String playListName, String songs) {
		super();
		this.id = id;
		this.playListName = playListName;
		this.songs = songs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayListName() {
		return playListName;
	}

	public void setPlayListName(String playListName) {
		this.playListName = playListName;
	}

	public String getSongs() {
		return songs;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((playListName == null) ? 0 : playListName.hashCode());
		result = prime * result + ((songs == null) ? 0 : songs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Playlist other = (Playlist) obj;
		if (id != other.id)
			return false;
		if (playListName == null) {
			if (other.playListName != null)
				return false;
		} else if (!playListName.equals(other.playListName))
			return false;
		if (songs == null) {
			if (other.songs != null)
				return false;
		} else if (!songs.equals(other.songs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", playListName=" + playListName + ", songs=" + songs + "]";
	}
	
}
