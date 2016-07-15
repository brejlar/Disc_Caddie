package com.github.brejlar.jdbc.dao.disc;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.github.brejlar.jdbc.dao.mapper.row.DiscRowMapper;
import com.github.brejlar.jdbc.dao.mapper.table.DiscTableMapper;
import com.github.brejlar.jdbc.dao.statments.prepared.InsertDiscPreparedStatement;
import com.github.brejlar.model.Disc;

@Component
public class DiscDaoImpl implements DiscDao {

	private final String GET_ALL_DISCS = "SELECT * FROM DISCS WHERE OWNER_ID='%s'";
	private final String GET_DISC = "SELECT * FROM DISCS WHERE DISC_ID='%s' AND OWNER_ID='%s'";
	private final String DELETE_DISC = "DELETE FROM DISCS WHERE DISC_ID='%s' AND OWNER_ID='%s'";
	private final String INSERT_DISC = "INSERT INTO DISCS VALUES(:disc_id,:model,:owner_id)";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DiscDaoImpl.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public int insertDisc(Disc disc) {
    	LOGGER.info("DiscDAO insertDisc: " + disc);
    	Integer result = (Integer) new NamedParameterJdbcTemplate(dataSource).execute(INSERT_DISC, new DiscTableMapper().getMapForTableValues(disc), new InsertDiscPreparedStatement());
    	LOGGER.info("DiscDAO insertDisc result: " + result);
    	return result == null ? 0 : result;
	}

	@Override
	public int deleteDisc(String playerId, String discId) {
		LOGGER.info("deleteDisc: playerId[" + playerId + "] discId[" + discId + "]");
    	String query = String.format(DELETE_DISC, discId, playerId);
    	LOGGER.info("deleteDisc query: " + query);
    	int result = new JdbcTemplate(dataSource).update(query);
    	return result;
	}

	@Override
	public Disc getSingleDisc(String playerId, String discId) {
		String query = String.format(GET_DISC, discId, playerId);
		LOGGER.info("DiscDAO getSingleDisc: " + query);
		Disc disc = new JdbcTemplate(dataSource).query(query, new DiscRowMapper()).get(0);
		return disc;
	}

	@Override
	public List<Disc> getAllDiscs(String playerId) {
		String query = String.format(GET_ALL_DISCS, playerId);
		LOGGER.info("DiscDAO getAllDiscs query: " + query);
		List<Disc> discs = new JdbcTemplate(dataSource).query(query, new DiscRowMapper());
		return discs;
		
	}

}
