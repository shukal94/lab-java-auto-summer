package com.solvd.lab.v2.automation.classes.c16.unmarshaller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.lab.v2.automation.classes.c16.bo.Car;

import java.io.File;
import java.io.IOException;

public class JSONUnmarshaller {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public Car readCar(String pathTo) throws IOException {
        return MAPPER.readValue(new File(pathTo).getAbsoluteFile(), Car.class);
    }
}
