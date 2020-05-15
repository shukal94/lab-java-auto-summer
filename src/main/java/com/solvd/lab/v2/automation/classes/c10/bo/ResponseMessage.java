package com.solvd.lab.v2.automation.classes.c10.bo;

public class ResponseMessage extends Package {
    private String resp;
    private int code;

    public ResponseMessage(String host, int port, String token, String resp, int code) {
        super(host, port, token);
        this.resp = resp;
        this.code = code;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%d", super.toString(), this.resp, this.code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
