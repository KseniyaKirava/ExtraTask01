package by.htp.kirova.task1.service;

import by.htp.kirova.task1.entity.News;
import by.htp.kirova.task1.entity.criteria.Criteria;


import java.util.List;

public interface CatalogService {
	
	List<News> find(Criteria criteria) throws ServiceException;
	News add(Criteria criteria) throws ServiceException;
	
}
