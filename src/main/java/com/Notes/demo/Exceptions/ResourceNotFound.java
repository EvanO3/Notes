package com.Notes.demo.Exceptions;

public class ResourceNotFound extends RuntimeException {
    private String message;



    public ResourceNotFound(){

    }
    
    public ResourceNotFound(String message){
        super(message);
    }


}
