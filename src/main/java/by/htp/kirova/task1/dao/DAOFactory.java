package by.htp.kirova.task1.dao;


import by.htp.kirova.task1.dao.impl.CatalogDAOImpl;
import by.htp.kirova.task1.dao.impl.JAXBParserImpl;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private DAOFactory() {}

	public static DAOFactory getInstance() {
		return instance;
	}





	private final CatalogDAO catalogDAO = new CatalogDAOImpl();

	public CatalogDAO getCatalogDAO() {
		return catalogDAO;
	}





	private final JAXBParser jaxbParser = new JAXBParserImpl();

	public JAXBParser getJaxbParser() {
		return jaxbParser;
	}

}
