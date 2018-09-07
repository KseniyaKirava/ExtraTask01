package by.htp.kirova.task1.dao;

import by.htp.kirova.task1.entity.Catalog;

public interface JAXBParser {

    Catalog readXml() throws DAOException;
    void saveXml(Catalog catalog) throws DAOException;
}
