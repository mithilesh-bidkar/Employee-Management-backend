package com.example.EmployeeMS.exceptions;

public class DepartmentNotFound extends RuntimeException{

    public DepartmentNotFound(String message){
        super(message);
    }
}
