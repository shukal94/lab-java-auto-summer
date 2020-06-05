package com.solvd.lab.v2.automation.classes.c16;

import com.solvd.lab.v2.automation.classes.c16.bo.Car;
import com.solvd.lab.v2.automation.classes.c16.marshaller.JSONMarshaller;
import com.solvd.lab.v2.automation.classes.c16.unmarshaller.JSONUnmarshaller;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class Main {
    // json
    // mappers
    // refactor
    // intro to web services
    public static void main(String[] args) {
        String pathTo = "src/main/resources/car.json";
        Car car = new Car("peugeot", "blue");
        writeObj(car, pathTo);

        Car car2 = readObj(pathTo);
        Objects.requireNonNull(car2, "Null unmarshalled car!");
        System.out.println(car2);
    }

    private static void writeObj(Car car, String pathTo) {
        try {
            new JSONMarshaller().writeObj(car, pathTo);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static Car readObj(String pathTo) {
        try {
            return new JSONUnmarshaller().readCar(pathTo);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }
}
