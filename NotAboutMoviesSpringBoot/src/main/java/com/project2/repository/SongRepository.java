package com.project2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project2.model.Song;

@Repository(value="songRepository")
public interface SongRepository extends JpaRepository<Song, Integer> {

	public <S extends Song> S save(Song s);
	
	public List<Song> findAll();
}
