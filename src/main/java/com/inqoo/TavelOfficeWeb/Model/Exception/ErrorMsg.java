package com.inqoo.TavelOfficeWeb.Model.Exception;

public class ErrorMsg {
    private String message;
    private Integer httpResponseCode;

    public ErrorMsg(String message, Integer httpResponseCode) {
        this.message = message;
        this.httpResponseCode = httpResponseCode;
    }

    public String getMessage() {
        return message;
    }

    public Integer getHttpResponseCode() {
        return httpResponseCode;
    }
}
