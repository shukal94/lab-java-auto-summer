package com.solvd.lab.v2.automation.classes.c10.bo;

import com.solvd.lab.v2.automation.io.interfaces.Packable;

import java.io.Serializable;

public abstract class Package implements Packable, Serializable {
    private String host;
    private int port;
    private String token;

    public Package(String host, int port, String token) {
        this.host = host;
        this.port = port;
        this.token = token;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return String.format("%s:%d:%s", this.host, this.port, this.token);
    }
}
