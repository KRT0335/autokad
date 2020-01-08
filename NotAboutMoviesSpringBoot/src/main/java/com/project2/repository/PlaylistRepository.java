package com.project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.model.Playlist;

@Repository(value = "playlistRepository")
public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{

	default <S extends Playlist> S save(Playlist p) {
		// TODO Auto-generated method stub
		return null;
	}
}
