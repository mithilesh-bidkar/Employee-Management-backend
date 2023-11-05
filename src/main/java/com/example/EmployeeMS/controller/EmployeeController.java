package com.example.EmployeeMS.controller;

import com.example.EmployeeMS.dto.requestDTO.EmployeeRequest;
import com.example.EmployeeMS.dto.responseDTO.DepartmentResponse;
import com.example.EmployeeMS.dto.responseDTO.EmployeeResponse;
import com.example.EmployeeMS.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody EmployeeRequest employeeRequest){

        try {
            String response = employeeService.addEmployee(employeeRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity getEmployee(@RequestParam("email") String email){

        try {
            EmployeeResponse response = employeeService.getEmployee(email);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateEmployeeMail(@RequestParam("old") String oldEmail, @RequestParam("new") String newEmail){

        try {
            String response = employeeService.updateEmployeeMail(oldEmail,newEmail);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteByMail")
    public ResponseEntity deleteByMail(@RequestParam("email") String email){


        try {
            String response = employeeService.deleteByMail(email);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
