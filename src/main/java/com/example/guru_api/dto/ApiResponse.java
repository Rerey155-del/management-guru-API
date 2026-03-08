package com.example.guru_api.dto;

public class ApiResponse<T> {

    private boolean status;
    private String message;
    private T data;

    public ApiResponse(boolean status, String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus(){
        return status;
    }

    public String getMessage(){
        return message;
    }

    public T getData(){
        return data;
    }
    
}
