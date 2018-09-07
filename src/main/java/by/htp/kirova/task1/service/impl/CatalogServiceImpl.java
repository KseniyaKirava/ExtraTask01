package by.htp.kirova.task1.service.impl;

import by.htp.kirova.task1.dao.CatalogDAO;
import by.htp.kirova.task1.dao.DAOException;
import by.htp.kirova.task1.dao.DAOFactory;
import by.htp.kirova.task1.entity.News;
import by.htp.kirova.task1.entity.criteria.Criteria;
import by.htp.kirova.task1.service.ServiceException;
import by.htp.kirova.task1.service.CatalogService;
import by.htp.kirova.task1.service.validation.Validator;

import java.util.Collections;
import java.util.List;

public class CatalogServiceImpl implements CatalogService {

    @Override
    public List<News> find(Criteria criteria) throws ServiceException {
        if (!Validator.criteriaValidator(criteria)) {
            System.out.println("The entered data does not correspond to the format");
            return Collections.emptyList();
        }

        DAOFactory factory = DAOFactory.getInstance();
        CatalogDAO catalogDAO = factory.getCatalogDAO();

        List<News> news = null;
        try {
            news = catalogDAO.find(criteria);
        } catch (DAOException e) {
            throw new ServiceException("Find operation in xml throw catalogDAO ending with Exception", e);
        }
        return news;
    }

    @Override
    public News add(Criteria criteria) throws ServiceException {
        if (!Validator.criteriaValidator(criteria)) {
            System.out.println("The entered data does not correspond to the format");
            return null;
        }


        DAOFactory factory = DAOFactory.getInstance();
        CatalogDAO catalogDAO = factory.getCatalogDAO();

        News news;

        try {
            news = catalogDAO.add(criteria);
        } catch (DAOException e) {
            throw new ServiceException("Add operation to xml throw catalogDAO ending with Exception", e);
        }

        if (news == null) {
            System.out.println("There are not enough criteria for a specific add-on");
            return null;
        }


        return news;
    }
}

