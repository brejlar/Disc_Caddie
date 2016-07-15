package com.github.brejlar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.brejlar.jdbc.dao.disc.DiscDao;
import com.github.brejlar.model.Disc;

@RestController
public class DiscController {

	private static final String PATH = "/discs";
	
	@Autowired
	private DiscDao discDao;
	
    @RequestMapping(PATH)
    public String discs() {
        return "Discs page";
    }
    
    @RequestMapping("/{playerId}" + PATH)
    public ResponseEntity<List<Disc>> getDiscsByPlayerId(@PathVariable String playerId) {
    	List<Disc> discs = discDao.getAllDiscs(playerId);
    	return new ResponseEntity<List<Disc>>(discs, HttpStatus.OK); 
    }
    
    @RequestMapping("/{playerId}" + PATH + "/{discId}")
    public ResponseEntity<Disc> getDiscByPlayerIdandDiscId(@PathVariable String playerId, @PathVariable String discId) {
    	Disc disc = discDao.getSingleDisc(playerId, discId);
    	return new ResponseEntity<Disc>(disc, HttpStatus.OK);  
    }
    
    @RequestMapping(value="/{playerId}" + PATH, method=RequestMethod.POST)
    public ResponseEntity<Disc> addDisc(@RequestBody Disc disc) {
    	int result = discDao.insertDisc(disc);
    	if(result == 0) {
    		return new ResponseEntity<Disc>(new Disc(), HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	return new ResponseEntity<Disc>(disc, HttpStatus.OK); 
    }
	
    @RequestMapping(value="/{playerId}" + PATH + "/{discId}", method=RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteDisc(@PathVariable String playerId, @PathVariable String discId) {
    	int result = discDao.deleteDisc(playerId, discId);
    	return new ResponseEntity<Integer>(result, HttpStatus.OK); 
    }
}
