package com.github.brejlar.jdbc.dao.statments.prepared;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class InsertDiscPreparedStatement implements PreparedStatementCallback<Object> {

	@Override
	public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
		return ps.executeUpdate();
	}

}
