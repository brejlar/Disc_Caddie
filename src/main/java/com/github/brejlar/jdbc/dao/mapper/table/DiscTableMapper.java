package com.github.brejlar.jdbc.dao.mapper.table;

import java.util.HashMap;
import java.util.Map;

import com.github.brejlar.model.Disc;

public class DiscTableMapper implements TableMapper {

	@Override
	public Map<String, Object> getMapForTableValues(Object object) {
		Map<String, Object> map = new HashMap<String, Object>();
		Disc disc = (Disc) object;
		
		map.put("disc_id", disc.getDiscId());
		map.put("model", disc.getModel());
		map.put("owner_id", disc.getOwnerId());
		
		return map;
	}

}
