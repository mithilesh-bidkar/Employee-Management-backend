package com.example.EmployeeMS.controller;

import com.example.EmployeeMS.Model.Mongo.Department;
import com.example.EmployeeMS.dto.responseDTO.DepartmentResponse;
import com.example.EmployeeMS.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

        final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/add")
    public ResponseEntity addDepartment(@RequestParam("name") String departmentName){



        try {
            String response = departmentService.addDepartment(departmentName);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/get")
    public ResponseEntity getDepartment(@RequestParam("name") String departmentName){

        try {
            DepartmentResponse response = departmentService.getDepartment(departmentName);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateDepartmentName(@RequestParam("old") String oldDepartmentName, @RequestParam("new") String newDepartmentName){

        try {
         DepartmentResponse response = departmentService.updateDepartment(oldDepartmentName,newDepartmentName);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteDepartment(@RequestParam("name") String departmentName){


        try {
            String response = departmentService.deleteDepartment(departmentName);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
