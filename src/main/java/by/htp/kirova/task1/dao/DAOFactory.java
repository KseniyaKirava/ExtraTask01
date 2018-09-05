package by.htp.kirova.task1.dao;


import by.htp.kirova.task1.dao.impl.CatalogDAOImpl;
import by.htp.kirova.task1.dao.impl.JAXBDAOImpl;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();

	private final CatalogDAO catalogDAO = new CatalogDAOImpl();
	
	private DAOFactory() {}

	public CatalogDAO getCatalogDAO() {
		return catalogDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	private final JAXBDAO jaxbDAO = new JAXBDAOImpl();

	public JAXBDAO getJaxbDAO() {
		return jaxbDAO;
	}

}
