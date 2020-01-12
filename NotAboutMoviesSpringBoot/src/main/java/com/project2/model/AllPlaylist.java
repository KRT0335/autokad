package com.project2.model;

public class AllPlaylist {

	private Integer userpk;
	private String username;
	private Integer playlistid;
	private String playlistname;
	private Integer songid;
	private String songname;
	private String artist;
	private String lyrics;
	
	public AllPlaylist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AllPlaylist(Integer userpk, String username, Integer playlistid, String playlistname, Integer songid,
			String songname, String artist, String lyrics) {
		super();
		this.userpk = userpk;
		this.username = username;
		this.playlistid = playlistid;
		this.playlistname = playlistname;
		this.songid = songid;
		this.songname = songname;
		this.artist = artist;
		this.lyrics = lyrics;
	}
	public Integer getUserpk() {
		return userpk;
	}
	public void setUserpk(Integer userpk) {
		this.userpk = userpk;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getPlaylistid() {
		return playlistid;
	}
	public void setPlaylistid(Integer playlistid) {
		this.playlistid = playlistid;
	}
	public String getPlaylistname() {
		return playlistname;
	}
	public void setPlaylistname(String playlistname) {
		this.playlistname = playlistname;
	}
	public Integer getSongid() {
		return songid;
	}
	public void setSongid(Integer songid) {
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
	public Song getSong() {
		return new Song(songid, songname, artist, lyrics);
	}
	public Account getAccount() {
		return new Account(userpk, username);
	}
//	public Playlist getPlaylist() {
//		return new Playlist(playlistid, playlistname);
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((lyrics == null) ? 0 : lyrics.hashCode());
		result = prime * result + ((playlistid == null) ? 0 : playlistid.hashCode());
		result = prime * result + ((playlistname == null) ? 0 : playlistname.hashCode());
		result = prime * result + ((songid == null) ? 0 : songid.hashCode());
		result = prime * result + ((songname == null) ? 0 : songname.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((userpk == null) ? 0 : userpk.hashCode());
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
		AllPlaylist other = (AllPlaylist) obj;
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
		if (playlistid == null) {
			if (other.playlistid != null)
				return false;
		} else if (!playlistid.equals(other.playlistid))
			return false;
		if (playlistname == null) {
			if (other.playlistname != null)
				return false;
		} else if (!playlistname.equals(other.playlistname))
			return false;
		if (songid == null) {
			if (other.songid != null)
				return false;
		} else if (!songid.equals(other.songid))
			return false;
		if (songname == null) {
			if (other.songname != null)
				return false;
		} else if (!songname.equals(other.songname))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (userpk == null) {
			if (other.userpk != null)
				return false;
		} else if (!userpk.equals(other.userpk))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AllPlaylist [userpk=" + userpk + ", username=" + username + ", playlistid=" + playlistid
				+ ", playlistname=" + playlistname + ", songid=" + songid + ", songname=" + songname + ", artist="
				+ artist + ", lyrics=" + lyrics + "]";
	}
	
	
}
