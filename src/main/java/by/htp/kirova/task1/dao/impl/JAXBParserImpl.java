package by.htp.kirova.task1.dao.impl;

import by.htp.kirova.task1.dao.DAOException;
import by.htp.kirova.task1.dao.JAXBParser;
import by.htp.kirova.task1.entity.Catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class JAXBParserImpl implements JAXBParser {

    @Override
    public Catalog readXml() throws DAOException {
        JAXBContext jaxbContext = null;
        String xmlSource = System.getProperty("user.dir") + "/src/main/resources/Catalog.xml";
        Catalog catalog = null;
        Unmarshaller unmarshaller;
        try {
            jaxbContext = JAXBContext.newInstance(Catalog.class);
            unmarshaller = jaxbContext.createUnmarshaller();
            catalog = (Catalog) unmarshaller.unmarshal(new File(xmlSource));
        } catch (JAXBException e) {
            throw new DAOException("JAXB readXml exception", e);
        }
        return catalog;
    }

    @Override
    public void saveXml(Catalog catalog) throws DAOException {
        JAXBContext jaxbContext = null;
        String xmlTarget = System.getProperty("user.dir") + "/src/main/resources/Catalog.xml";
        try (OutputStream outputStream = new FileOutputStream(xmlTarget)){
            jaxbContext = JAXBContext.newInstance(Catalog.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //marshaller.marshal(catalog, System.out);
            marshaller.marshal(catalog, outputStream);
        } catch (JAXBException | IOException e ) {
            throw new DAOException("JAXB saveXml exception", e);
        }
    }


}




