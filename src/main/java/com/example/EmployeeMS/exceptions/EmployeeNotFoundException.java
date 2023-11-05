package com.example.EmployeeMS.exceptions;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException (String message){
        super(message);
    }
}
