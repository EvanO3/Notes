package com.Notes.demo.Exceptions;

public class APIExceptions extends RuntimeException {
    private String message;


    public APIExceptions(){

    }

    public APIExceptions(String message){
        super(message);
    }
}
