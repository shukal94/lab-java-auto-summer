package com.solvd.lab.v2.automation.classes.c16.bo;

public class Car {
    private String color;
    private String type;

    public Car() {
        this("black", "taxi");
    }

    public Car(String color, String type) {
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "{\"color\":\""+ color +"\",\"type\":\""+ type +"\"}";
    }
}
