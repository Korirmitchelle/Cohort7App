package com.example.mitchelle.cohort7.utils;

/**
 * Created by mitchelle on 9/2/16.
 */
public class APIError {
    private int statusCode;
    private String message;


    public APIError(){}
    public int status(){
        return statusCode;
    }

    public String message(){
        return message;
    }
}
