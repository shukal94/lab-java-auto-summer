package com.solvd.lab.v2.automation.classes.c16.interaction;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.solvd.lab.v2.automation.classes.c16.bo.Car;
import com.solvd.lab.v2.automation.classes.c16.unmarshaller.JSONUnmarshaller;
import com.solvd.lab.v2.automation.io.exception.UnableToReadException;
import com.solvd.lab.v2.automation.io.impl.file.TextFileReader;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Server {
    private static final Logger LOGGER = Logger.getLogger(Server.class);

    public static void main(String[] args) throws IOException, InterruptedException {

        while(true) {
            try {
                if (!noContent()) {
                    Car car = new JSONUnmarshaller().readCar("src/main/resources/car.json");
                    LOGGER.info(car);
                    Thread.sleep(10000);
                }
            } catch (MismatchedInputException ignored) {

            }

        }
    }

    private static boolean noContent() {
        try {
            TextFileReader r = new TextFileReader("src/main/resources/car.json");
            return r.read() == null;
        } catch (UnableToReadException e) {
            e.printStackTrace();
            return true;
        }
    }

    private static boolean isContentEqual(Car car) {
        try {
            TextFileReader r = new TextFileReader("src/main/resources/car.json");
            return r.read().equals(car.toString());
        } catch (UnableToReadException e) {
            e.printStackTrace();
            return true;
        }
    }
}
