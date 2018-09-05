package by.htp.kirova.task1.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

	private Map<SearchCriteria.News, Object> criteria = new HashMap<>();

	public Map<SearchCriteria.News, Object> getCriteria() {
		return criteria;
	}

	public Criteria() {

	}

	public void addCriteria(SearchCriteria.News searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}


}
