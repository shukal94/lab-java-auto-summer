package com.solvd.lab.v2.automation.classes.c16.interaction;

import com.solvd.lab.v2.automation.classes.c16.bo.Car;
import com.solvd.lab.v2.automation.classes.c16.marshaller.JSONMarshaller;

import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        String pathTo = "src/main/resources/car.json";
        Car car = new Car("red", "sedan");
        writeObj(car, pathTo);
    }

    private static void writeObj(Car car, String pathTo) {
        try {
            new JSONMarshaller().writeObj(car, pathTo);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
