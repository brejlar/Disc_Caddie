package com.github.brejlar.jdbc.dao.mapper.row;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.github.brejlar.model.Disc;

public class DiscRowMapper implements RowMapper<Disc> {

	@Override
	public Disc mapRow(ResultSet rs, int rowNum) throws SQLException {
		Disc disc = new Disc();
		disc.setDiscId(rs.getString("disc_id"));
		disc.setModel(rs.getString("model"));
		disc.setOwnerId(rs.getString("owner_id"));

		return disc;
	}

}
