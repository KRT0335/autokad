package com.project2.model;

public class Song {
	
	private boolean success;
	private SongResult result;
	private String artist;
	private String song;
	
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Song(boolean success, SongResult result, String artist, String song) {
		super();
		this.success = success;
		this.result = result;
		this.artist = artist;
		this.song = song;
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

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((song == null) ? 0 : song.hashCode());
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
		Song other = (Song) obj;
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
		if (song == null) {
			if (other.song != null)
				return false;
		} else if (!song.equals(other.song))
			return false;
		if (success != other.success)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Song [succes=" + success + ", result=" + result + ", artist=" + artist + ", song=" + song + "]";
	}
	

}
