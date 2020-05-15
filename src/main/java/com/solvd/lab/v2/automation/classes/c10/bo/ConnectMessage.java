package com.solvd.lab.v2.automation.classes.c10.bo;

public class ConnectMessage extends Package {
    private String message;

    public ConnectMessage(String host, int port, String token, String message) {
        super(host, port, token);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return String.format("%s:%s", super.toString(), this.message);
    }
}
