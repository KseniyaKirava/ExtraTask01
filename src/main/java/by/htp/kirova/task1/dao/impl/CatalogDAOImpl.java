package by.htp.kirova.task1.dao.impl;

import by.htp.kirova.task1.dao.CatalogDAO;
import by.htp.kirova.task1.dao.DAOException;
import by.htp.kirova.task1.entity.*;
import by.htp.kirova.task1.entity.criteria.Criteria;
import by.htp.kirova.task1.entity.criteria.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CatalogDAOImpl implements CatalogDAO {

    @Override
    public List<News> find(Criteria criteria) throws DAOException {
        JAXBParserImpl jaxbdaoImpl = new JAXBParserImpl();
        Catalog catalog = jaxbdaoImpl.readXml();
        List<News> result = new ArrayList<>();
        for (Category category : catalog.getCategory()) {
            if (!isValidName(category, criteria, SearchCriteria.News.CATEGORY_NAME))
                continue;
            for (SubCategory subCategory : category.getSubCategory()) {
                if (!isValidName(subCategory, criteria, SearchCriteria.News.SUBCATEGORY_NAME))
                    continue;

                for (News item : subCategory.getNews()) {
                    if (isValidNews(item, criteria)) {
                        result.add(item);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public News add(Criteria criteria) throws DAOException {
        JAXBParserImpl jaxbdaoImpl = new JAXBParserImpl();
        Catalog catalog = jaxbdaoImpl.readXml();
        List<Category> category = catalog.getCategory();

        Category targetCategory = getFirstItem(category,
                criteria, SearchCriteria.News.CATEGORY_NAME);
        if (targetCategory == null) {
            return null;
        }

        SubCategory targetSubCategory = getFirstItem(targetCategory.getSubCategory(),
                criteria, SearchCriteria.News.SUBCATEGORY_NAME);
        if (targetSubCategory == null) {
            return null;
        }
        News result = new News();

        for (Map.Entry<SearchCriteria.News, Object> c :
                criteria.getCriteria().entrySet()) {
            switch (c.getKey()) {
                case NAME:
                    result.setName((String) c.getValue());
                    break;
                case PROVIDER:
                    result.setProvider((String) c.getValue());
                    break;
                case NEWS_BODY:
                    result.setNewsBody((String) c.getValue());
                    break;
                case DATE_OF_ISSUE:
                    result.setDateOfIssue((String) c.getValue());
                    break;
            }
        }


        int indexOfCategory = category.indexOf(targetCategory);
        int indexOfSubCategory = category.get(indexOfCategory).getSubCategory().indexOf(targetSubCategory);
        category.get(indexOfCategory).getSubCategory().get(indexOfSubCategory).getNews().add(0, result);
        jaxbdaoImpl.saveXml(catalog);
        System.out.println("News successfully added");
        return result;
    }





    private boolean isValidName(BaseEntity item, Criteria criteria, SearchCriteria.News nameKey) {
        if (criteria.getCriteria().containsKey(nameKey)) {
            Object value = criteria.getCriteria().get(nameKey);
            return item.getName().equals(value);
        }
        return true;
    }

    private boolean isValidNews(News item, Criteria criteria) {
        for (Map.Entry<SearchCriteria.News, Object> cr :
                criteria.getCriteria().entrySet()) {
            switch (cr.getKey()) {
                case NAME:
                    if (!item.getName().equals(cr.getValue())) {
                        return false;
                    }
                    break;
                case PROVIDER:
                    if (!item.getProvider().equals(cr.getValue())) {
                        return false;
                    }
                    break;
                case NEWS_BODY:
                    if (!item.getNewsBody().equals(cr.getValue())) {
                        return false;
                    }
                    break;
                case DATE_OF_ISSUE:
                    if (!item.getDateOfIssue().equals(cr.getValue())) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }



    private <T extends BaseEntity> T getFirstItem(List<T> items, Criteria criteria,
                                          SearchCriteria.News nameKey) {
        Map<SearchCriteria.News, Object> searchCriteria = criteria.getCriteria();
        if (!searchCriteria.containsKey(nameKey)) {
            return null;
        }
        Object targetCategoryName = searchCriteria.get(nameKey);
        for (T item : items) {
            if (item.getName().equals(targetCategoryName)) {
                return item;
            }
        }
        return null;
    }


}


