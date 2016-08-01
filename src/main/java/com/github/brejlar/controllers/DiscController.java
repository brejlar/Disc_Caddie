package com.github.brejlar.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.brejlar.jdbc.dao.disc.DiscRepository;
import com.github.brejlar.model.Disc;

@RestController
@RequestMapping("/discs")
public class DiscController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DiscController.class);
	
	@Autowired
	private DiscRepository discRepository;
	
	@RequestMapping("/{playerId}")
	public ResponseEntity<List<Disc>> getDiscsByPlayerId(@PathVariable String playerId) {
		List<Disc> discs = discRepository.findByOwnerId(playerId);
		LOGGER.info("BY DISC REPO");
		for(Disc d : discs) {
			LOGGER.info(d.toString());
		}
		
		return new ResponseEntity<List<Disc>>(discs, HttpStatus.OK);
	}

	@RequestMapping("/discs/{discId}")
	public ResponseEntity<Disc> getDiscByDiscIdAnd(@PathVariable Long discId) {
		Disc disc = discRepository.findOne(discId);
		return new ResponseEntity<Disc>(disc, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Disc> addDisc(@RequestBody Disc disc) {
		LOGGER.info("Incoming disc: " + disc);
		Disc result = discRepository.save(disc);
		if (result == null) {
			return new ResponseEntity<Disc>((Disc) null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Disc>(disc, HttpStatus.OK);
	}

	@RequestMapping(value = "/{discId}", method = RequestMethod.DELETE)
	public ResponseEntity<Disc> deleteDisc(@PathVariable String playerId, @PathVariable String discId) {
		Disc target = discRepository.findOne(Long.getLong(discId));
		discRepository.delete(target);
		return new ResponseEntity<Disc>((Disc) null, HttpStatus.OK);
	}
	
}
