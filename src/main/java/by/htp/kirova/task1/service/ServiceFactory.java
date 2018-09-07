package by.htp.kirova.task1.service;

import by.htp.kirova.task1.service.impl.CatalogServiceImpl;
import by.htp.kirova.task1.service.impl.JAXBServiceImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private ServiceFactory() {}

	public static ServiceFactory getInstance() {
		return instance;
	}





	private final CatalogService catalogService = new CatalogServiceImpl();

	public CatalogService getCatalogService() {
		return catalogService;
	}





	private final JAXBService jaxbService = new JAXBServiceImpl();

	public JAXBService getJaxbService() {return jaxbService;}


}
