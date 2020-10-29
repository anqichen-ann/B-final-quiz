package com.example.demo.exception;

public class GroupFailedException extends RuntimeException{

    public GroupFailedException(String message){
        super(message);
    }
}
