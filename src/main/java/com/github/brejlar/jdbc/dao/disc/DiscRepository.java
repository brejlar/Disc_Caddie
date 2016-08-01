package com.github.brejlar.jdbc.dao.disc;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.brejlar.model.Disc;

public interface DiscRepository extends CrudRepository<Disc, Long> {
	
	List<Disc> findByOwnerId(String ownerId);
}