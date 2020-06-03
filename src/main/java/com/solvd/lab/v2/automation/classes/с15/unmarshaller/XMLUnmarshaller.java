package com.solvd.lab.v2.automation.classes.с15.unmarshaller;

import com.solvd.lab.v2.automation.classes.с15.bo.Book;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileReader;
import java.io.IOException;

public class XMLUnmarshaller {
    public Book unmarshallBook(String pathTo) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Book.class);
        return (Book) context.createUnmarshaller()
                .unmarshal(new FileReader(pathTo));
    }
}
