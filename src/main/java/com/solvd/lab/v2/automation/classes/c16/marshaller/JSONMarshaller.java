package com.solvd.lab.v2.automation.classes.c16.marshaller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.lab.v2.automation.classes.c16.bo.Car;

import java.io.File;
import java.io.IOException;

public class JSONMarshaller {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public void writeObj(Car car, String pathTo) throws IOException {
        MAPPER.writeValue(new File(pathTo).getAbsoluteFile(), car);
    }
}
