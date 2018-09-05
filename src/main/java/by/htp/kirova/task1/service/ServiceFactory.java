package by.htp.kirova.task1.service;

import by.htp.kirova.task1.service.impl.CatalogServiceImpl;
import by.htp.kirova.task1.service.impl.JAXBServiceImpl;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final CatalogService catalogService = new CatalogServiceImpl();
	
	private ServiceFactory() {}

	public CatalogService getCatalogService() {
		return catalogService;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	private final JAXBService jaxbService = new JAXBServiceImpl();

	public JAXBService getJaxbService() {return jaxbService;}


}
