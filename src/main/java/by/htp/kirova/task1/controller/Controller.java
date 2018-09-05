package by.htp.kirova.task1.controller;

import by.htp.kirova.task1.entity.Catalog;
import by.htp.kirova.task1.entity.News;
import by.htp.kirova.task1.entity.criteria.Criteria;
import by.htp.kirova.task1.entity.criteria.SearchCriteria;
import by.htp.kirova.task1.service.CatalogService;
import by.htp.kirova.task1.service.JAXBService;
import by.htp.kirova.task1.service.ServiceException;
import by.htp.kirova.task1.service.ServiceFactory;
import by.htp.kirova.task1.view.PrintNews;

import java.util.List;


public class Controller {
    public static void main(String[] args) throws ControllerException {
        //чтение/запись XML с помощью JAXB
        ServiceFactory factory = ServiceFactory.getInstance();
        JAXBService jaxbService = factory.getJaxbService();
        Catalog catalog = null;
        try {
            catalog = jaxbService.readXml();
        } catch (ServiceException e) {
            System.out.println("Operation readXml failed");
            throw new ControllerException("Operation readXml failed", e);
        }
        try {
            jaxbService.saveXml(catalog);
        } catch (ServiceException e) {
            System.out.println("Operation saveXml failed");
            throw new ControllerException("Operation saveXml failed", e);
        }


        CatalogService service = factory.getCatalogService();


        //поиск по 2м критериям
        Criteria criteria = new Criteria();
        criteria.addCriteria(SearchCriteria.News.NAME, "The One TRUE Flash is Coming To DC Comics");
        criteria.addCriteria(SearchCriteria.News.PROVIDER, "Iris West-Allen");
        List<News> news = null;
        try {
            news = service.find(criteria);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
        PrintNews.print(news);
        System.out.println("________________________________________________________________________________________");

        //поиск по категории
        Criteria criteria2 = new Criteria();
        criteria2.addCriteria(SearchCriteria.News.CATEGORY_NAME, "Movie");
        List<News> news2 = null;
        try {
            news2 = service.find(criteria2);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
        PrintNews.print(news2);
        System.out.println("======================================================================================");



        //добавление новости
        Criteria addNews = new Criteria();
        addNews.addCriteria(SearchCriteria.News.NAME, "Bla bla bla");
        addNews.addCriteria(SearchCriteria.News.PROVIDER, "Jodie K.");
        addNews.addCriteria(SearchCriteria.News.DATE_OF_ISSUE, "2018-05-09");
        addNews.addCriteria(SearchCriteria.News.NEWS_BODY, "Bla bla bla bla bla bla, bla bla");
        addNews.addCriteria(SearchCriteria.News.CATEGORY_NAME, "Movie");
        addNews.addCriteria(SearchCriteria.News.SUBCATEGORY_NAME, "Action");
        try {
            service.add(addNews);
        } catch (ServiceException e) {
            throw new ControllerException("Add news failed", e);
        }
        System.out.println("________________________________________________________________________________________");

        //добавление новости с "некорректной" категорией, категории добавлять нельзя (согласно условию таска)
        Criteria addNews2 = new Criteria();
        addNews2.addCriteria(SearchCriteria.News.NAME, "Bla bla bla");
        addNews2.addCriteria(SearchCriteria.News.PROVIDER, "Jodie K.");
        addNews2.addCriteria(SearchCriteria.News.DATE_OF_ISSUE, "15.12.2018");
        addNews2.addCriteria(SearchCriteria.News.NEWS_BODY, "Bla bla bla bla bla bla, bla bla");
        addNews2.addCriteria(SearchCriteria.News.CATEGORY_NAME, "Movigggggge");
        addNews2.addCriteria(SearchCriteria.News.SUBCATEGORY_NAME, "Action");
        try {
            service.add(addNews2);
        } catch (ServiceException e) {
            throw new ControllerException("Add news failed", e);
        }
    }
}
