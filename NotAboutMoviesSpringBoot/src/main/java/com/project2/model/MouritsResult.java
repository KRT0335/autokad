package com.project2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MouritsResult {

	private boolean success;
	private SongResult result;
	private String artist;
	private String songname;
	
	
	public MouritsResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MouritsResult(boolean success, SongResult result, String artist, String songname) {
		super();
		this.success = success;
		this.result = result;
		this.artist = artist;
		this.songname = songname;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public SongResult getResult() {
		return result;
	}
	public void setResult(SongResult result) {
		this.result = result;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getSongname() {
		return songname;
	}
	public void setSongname(String songname) {
		this.songname = songname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((songname == null) ? 0 : songname.hashCode());
		result = prime * result + (success ? 1231 : 1237);
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
		MouritsResult other = (MouritsResult) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (songname == null) {
			if (other.songname != null)
				return false;
		} else if (!songname.equals(other.songname))
			return false;
		if (success != other.success)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MouritsResult [success=" + success + ", result=" + result + ", artist=" + artist + ", songname="
				+ songname + "]";
	}
	
	
}
