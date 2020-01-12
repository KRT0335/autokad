package com.project2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project2.model.AllPlaylist;
import com.project2.model.Playlist;

@Repository(value = "playlistRepository")
public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{

	public <S extends Playlist> S save(Playlist p);
	public List<Playlist> findAll();
	public Playlist findPlaylistById(int id);
	
//	@Query(value="select distinct a.userpk, a.username, p.playlistid, p.playlistname, s.songid, s.songname, s.artist, s.lyrics " + 
//			"from playlist p, playlist_songs ps, songs s, account a " + 
//			"where ps.playlistid = p.playlistid and p.userpk = a.userpk;",
//			nativeQuery = true)
//	public List<AllPlaylist> findAllAllPlaylist();
}
