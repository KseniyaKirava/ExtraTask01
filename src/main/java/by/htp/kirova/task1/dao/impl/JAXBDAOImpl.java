package by.htp.kirova.task1.dao.impl;

import by.htp.kirova.task1.dao.DAOException;
import by.htp.kirova.task1.dao.JAXBDAO;
import by.htp.kirova.task1.entity.Catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class JAXBDAOImpl implements JAXBDAO {

    @Override
    public Catalog readXml() throws DAOException {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Catalog.class);
        } catch (JAXBException e) {
            throw new DAOException("JAXBContext exception", e);
        }
        String xmlSource = System.getProperty("user.dir") + "/src/main/resources/Catalog.xml";
//      D:\task01\src\main\resources
        Catalog catalog = null;
        Unmarshaller unmarshaller;
        try {
            unmarshaller = jaxbContext.createUnmarshaller();
            catalog = (Catalog) unmarshaller.unmarshal(new File(xmlSource));
        } catch (JAXBException e) {
            throw new DAOException("Unmarshaller error", e);
        }
        return catalog;
    }

    @Override
    public void saveXml(Catalog catalog) throws DAOException {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Catalog.class);
        } catch (JAXBException e) {
            throw new DAOException("JAXBContext exception", e);
        }
        String xmlTarget = System.getProperty("user.dir") + "/src/main/resources/Catalog.xml";
        try {
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //marshaller.marshal(catalog, System.out);
            try (OutputStream outputStream = new FileOutputStream(xmlTarget)) {
                marshaller.marshal(catalog, outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            throw new DAOException("Marshaller error", e);
        }
    }


}




