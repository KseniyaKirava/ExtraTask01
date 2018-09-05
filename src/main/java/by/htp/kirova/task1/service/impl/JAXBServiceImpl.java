package by.htp.kirova.task1.service.impl;

import by.htp.kirova.task1.dao.*;
import by.htp.kirova.task1.entity.Catalog;
import by.htp.kirova.task1.service.JAXBService;
import by.htp.kirova.task1.service.ServiceException;

public class JAXBServiceImpl implements JAXBService {

    @Override
    public Catalog readXml() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        JAXBDAO jaxbDAO = daoFactory.getJaxbDAO();
        Catalog catalog = null;
        try {
            catalog = jaxbDAO.readXml();
        } catch (DAOException e) {
            throw new ServiceException("Read xml Jaxb Exception", e);
        }

        return catalog;
    }

    @Override
    public void saveXml(Catalog catalog) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        JAXBDAO jaxbDAO = daoFactory.getJaxbDAO();
        try {
            jaxbDAO.saveXml(catalog);
            System.out.println("Changes in Catalog.xml saved");
        } catch (DAOException e) {
            throw new ServiceException("Save xml Jaxb Exception", e);
        }
    }
}
