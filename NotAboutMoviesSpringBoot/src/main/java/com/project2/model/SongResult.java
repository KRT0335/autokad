package com.project2.model;

public class SongResult {

	private String lyrics;

	public SongResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SongResult(String lyrics) {
		super();
		this.lyrics = lyrics;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lyrics == null) ? 0 : lyrics.hashCode());
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
		SongResult other = (SongResult) obj;
		if (lyrics == null) {
			if (other.lyrics != null)
				return false;
		} else if (!lyrics.equals(other.lyrics))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Result [lyrics=" + lyrics + "]";
	}
	
}
