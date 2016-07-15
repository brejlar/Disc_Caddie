package com.github.brejlar.jdbc.dao.disc;

import java.util.List;

import com.github.brejlar.model.Disc;

public interface DiscDao {

	public int insertDisc(Disc disc);
	public int deleteDisc(String playerId, String discId);
	public Disc getSingleDisc(String playerId, String discId);
	public List<Disc> getAllDiscs(String playerId);
	
}
