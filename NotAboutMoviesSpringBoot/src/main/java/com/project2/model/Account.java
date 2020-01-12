package com.project2.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
//This is the clas for user of app
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userpk", columnDefinition = "serial")
	private int id;
	@Column
	private String name;
	@Column
	private String username;
	@Column
	private String password;
	@OneToMany(mappedBy="account", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonManagedReference
//	@JoinColumn
	private List<Playlist> playlist = new ArrayList<>();

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public Account(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public Account(int id, String name, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Playlist> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<Playlist> playlist) {
		this.playlist = playlist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Account other = (Account) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
	
}
