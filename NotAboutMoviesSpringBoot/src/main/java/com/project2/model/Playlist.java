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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "playlist")
public class Playlist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="playlistid", columnDefinition = "serial")
	private int id;
	@NotNull
	@Column
	private String playlistname;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userpk")
	private Account account;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="playlist_songs", 
				joinColumns = {@JoinColumn(name="playlistid")},
				inverseJoinColumns = {@JoinColumn(name="songid")})
	private Set<Song> songs = new HashSet<>();
//	@Column
//	private String songs;
	
	public Playlist() {
		super();
		// TODO Auto-generated constructor stub
	}
public Playlist(int id, @NotNull String playlistname, Account account) {
	super();
	this.id = id;
	this.playlistname = playlistname;
	this.account = account;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPlayListName() {
	return playlistname;
}
public void setPlayListName(String playListName) {
	this.playlistname = playListName;
}
public Account getAccount() {
	return account;
}
public void setAccount(Account account) {
	this.account = account;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((account == null) ? 0 : account.hashCode());
	result = prime * result + id;
	result = prime * result + ((playlistname == null) ? 0 : playlistname.hashCode());
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
	if (account == null) {
		if (other.account != null)
			return false;
	} else if (!account.equals(other.account))
		return false;
	if (id != other.id)
		return false;
	if (playlistname == null) {
		if (other.playlistname != null)
			return false;
	} else if (!playlistname.equals(other.playlistname))
		return false;
	return true;
}
@Override
public String toString() {
	return "Playlist [id=" + id + ", playListName=" + playlistname + ", account=" + account + "]";
}
		
	
	
}
