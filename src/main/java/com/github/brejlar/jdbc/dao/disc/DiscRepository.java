package com.github.brejlar.jdbc.dao.disc;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.brejlar.model.Disc;

@Repository
public interface DiscRepository extends CrudRepository<Disc, Long> {
	List<Disc> findByOwnerId(String ownerId);
}