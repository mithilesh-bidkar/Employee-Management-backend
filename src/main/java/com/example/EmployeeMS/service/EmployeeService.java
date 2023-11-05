package com.example.EmployeeMS.service;


import com.example.EmployeeMS.dto.requestDTO.EmployeeRequest;
import com.example.EmployeeMS.dto.responseDTO.EmployeeResponse;

public interface EmployeeService {


    String addEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse getEmployee(String email);

    String updateEmployeeMail(String oldEmail, String newEmail);

    String deleteByMail(String email);
}
