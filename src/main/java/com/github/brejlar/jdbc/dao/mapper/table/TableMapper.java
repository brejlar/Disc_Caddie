package com.github.brejlar.jdbc.dao.mapper.table;

import java.util.Map;

public interface TableMapper {

	public Map<String, Object> getMapForTableValues(Object object);
	
}
