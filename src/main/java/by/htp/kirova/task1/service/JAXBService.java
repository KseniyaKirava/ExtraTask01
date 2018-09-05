package by.htp.kirova.task1.service;

import by.htp.kirova.task1.entity.Catalog;

public interface JAXBService {

    Catalog readXml() throws ServiceException;
    void saveXml(Catalog catalog) throws ServiceException;
}
