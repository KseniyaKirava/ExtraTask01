package by.htp.kirova.task1.dao;


import by.htp.kirova.task1.entity.News;
import by.htp.kirova.task1.entity.criteria.Criteria;
import by.htp.kirova.task1.service.ServiceException;

import java.util.List;

public interface CatalogDAO {
	List<News> find(Criteria criteria) throws DAOException;
	News add(Criteria criteria) throws DAOException;
}
