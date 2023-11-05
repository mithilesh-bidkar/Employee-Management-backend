package com.example.EmployeeMS.service.impl;

import com.example.EmployeeMS.Model.JPA.Employee;
import com.example.EmployeeMS.Model.Mongo.Department;
import com.example.EmployeeMS.dto.requestDTO.EmployeeRequest;
import com.example.EmployeeMS.dto.responseDTO.EmployeeResponse;
import com.example.EmployeeMS.exceptions.DepartmentNotFound;
import com.example.EmployeeMS.exceptions.EmployeeNotFoundException;
import com.example.EmployeeMS.repository.JPA.EmployeeRepository;
import com.example.EmployeeMS.repository.Mongo.DepartmentRepository;
import com.example.EmployeeMS.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository employeeRepository;

    final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String addEmployee(EmployeeRequest employeeRequest) {

        Employee employee = employeeRepository.findByEmail(employeeRequest.getEmail());
        if(employee!=null){
            throw new RuntimeException("email already in use by someone else !!");
        }

        // convert employee request DTO to employee model
        Employee newEmployee = new Employee();

        newEmployee.setFirstName(employeeRequest.getFirstName());
        newEmployee.setLastName(employeeRequest.getLastName());
        newEmployee.setEmail(employeeRequest.getEmail());


        // code for assigning appropriate department id according to department name
        List<Department> departmentList = departmentRepository.findAll();
        for(Department dep : departmentList){

            String depName = dep.getDepartmentName();

            if(depName.equalsIgnoreCase(employeeRequest.getDepartmentName())){
                newEmployee.setDepartmentID(dep.getDepartmentID());

                employeeRepository.save(newEmployee);
                return "Employee Added Successfully !!";
            }
        }

        throw new DepartmentNotFound("Department name does not exist !!");
    }

    @Override
    public EmployeeResponse getEmployee(String email) {

        Employee employee = employeeRepository.findByEmail(email);

        if(employee == null){
            throw  new EmployeeNotFoundException("Employee Not Found !!");
        }

        // convert employee to employee response DTO

        EmployeeResponse employeeResponse = new EmployeeResponse();

        employeeResponse.setId(employee.getId());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setFirstName(employee.getFirstName());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setCreatedAt(employee.getCreatedAt());
        employeeResponse.setUpdatedAt(employee.getUpdatedAt());

        Optional<Department> department = departmentRepository.findById(employee.getDepartmentID());
        employeeResponse.setDepartment(department.get());

        return employeeResponse;
    }

    @Override
    public String updateEmployeeMail(String oldEmail, String newEmail) {


        Employee employee = employeeRepository.findByEmail(oldEmail);

        // check for old email
        if(employee == null){
            throw  new EmployeeNotFoundException("Employee Not Found or incorrect mail !!");
        }

        Employee employee2 = employeeRepository.findByEmail(newEmail);
        // check if new email is already  in use
        if(employee2 != null){
            throw  new EmployeeNotFoundException("New Email is already assigned to someone else !! !!");
        }

        employee.setEmail(newEmail);// set new email
        employeeRepository.save(employee); // save updated entity to database

        return "Email updated successfully !!";
    }

    @Override
    public String deleteByMail(String email) {
            // get employee from database using email
        Employee employee = employeeRepository.findByEmail(email);

        // check for email exists or not
        if(employee == null){
            throw  new EmployeeNotFoundException("Employee Not Found or incorrect mail !!");
        }

        employeeRepository.delete(employee); // Delete the employee


        return "Employee deleted successfully !!";
    }
}
