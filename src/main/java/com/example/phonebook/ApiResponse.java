package com.example.phonebook;

public class ApiResponse {
    private String message;
    private Boolean success;
    private Object data;
    public ApiResponse(String message, Boolean success, Object data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public Object getData() {
        return data;
    }
}
