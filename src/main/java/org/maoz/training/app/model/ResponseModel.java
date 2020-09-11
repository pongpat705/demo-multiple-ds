package org.maoz.training.app.model;

public class ResponseModel<T> {

    private T data;
    private int responseCode;
    private String responseMessage;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
