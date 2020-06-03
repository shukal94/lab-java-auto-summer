package com.solvd.lab.v2.automation.classes.с15;

import com.solvd.lab.v2.automation.classes.с15.bo.Book;
import com.solvd.lab.v2.automation.classes.с15.marshaller.XMLMarshaller;
import com.solvd.lab.v2.automation.classes.с15.unmarshaller.XMLUnmarshaller;
import com.solvd.lab.v2.automation.io.exception.UnableToWriteException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// data models (hierarchic)
// format xml (internals, usage) (html vs xml)
// serialization (marshalling/unmarshalling)
// adapters
// schema generation
public class Main {
    public static void main(String[] args) {
        Book b = new Book(23423535L, "LotR", "Tolkien", new Date());
        String pathTo = "src/main/resources/book.xml";
        writeBook(b, pathTo);
        Book b2 = readBook(pathTo);
        System.out.println(b2);

        // xpath
        try {
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder domBuilder = domFactory.newDocumentBuilder();

            Document docExisting = domBuilder.parse(new File(pathTo).getAbsoluteFile());

            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();

            NodeList list = (NodeList) xpath.evaluate(
                    "/book/date",
                    docExisting, XPathConstants.NODESET);
            for (int i = 0; i < list.getLength(); i++)
                System.out.println(list.item(i).getAttributes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Book readBook(String pathTo) {
        try {
            return new XMLUnmarshaller().unmarshallBook(pathTo);
        } catch (IOException | JAXBException ioe) {
            ioe.printStackTrace();
            throw new RuntimeException("Something went wrong while unmarshalling!");
        }

    }

    private static void writeBook(Book b, String pathTo) {
        try {
            new XMLMarshaller().marshall(b, pathTo);
        } catch (UnableToWriteException uwe) {
            uwe.printStackTrace();
            throw new RuntimeException("Bad object type!");
        } catch (JAXBException jaxe) {
            jaxe.printStackTrace();
            throw new RuntimeException("Something went wrong while marshalling!");
        }
    }
}
