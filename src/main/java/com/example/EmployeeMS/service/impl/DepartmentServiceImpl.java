package com.example.EmployeeMS.service.impl;

import com.example.EmployeeMS.Model.Mongo.Department;
import com.example.EmployeeMS.dto.responseDTO.DepartmentResponse;
import com.example.EmployeeMS.exceptions.DepartmentNotFound;
import com.example.EmployeeMS.repository.Mongo.DepartmentRepository;
import com.example.EmployeeMS.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    final DepartmentRepository departmentRepository;


    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String addDepartment(String departmentName) {
        List<Department> departmentList = departmentRepository.findAll();

        //check if department already exists or not
        for (Department dep : departmentList){
            String depName = dep.getDepartmentName();

            if (depName.equalsIgnoreCase(departmentName)){

                throw new DepartmentNotFound("Department already Exist !!");
            }
        }
        // creating new department
        Department newDepartment = new Department();
        newDepartment.setDepartmentID(String.valueOf(UUID.randomUUID())); // assigning UUID as primary key

        newDepartment.setDepartmentName(departmentName);

        departmentRepository.save(newDepartment);// saved new department in the database

        return "Department created successfully !!";
    }

    @Override
    public DepartmentResponse getDepartment(String departmentName) {
            //get list of all departments
        List<Department> departmentList = departmentRepository.findAll();

        for (Department dep : departmentList){
            String depName = dep.getDepartmentName();

            if (depName.equalsIgnoreCase(departmentName)){

                // converting model department to department response DTO
                DepartmentResponse departmentResponse = new DepartmentResponse();
                departmentResponse.setDepartmentName(dep.getDepartmentName());
                departmentResponse.setDepartmentID(dep.getDepartmentID());
                departmentResponse.setCreatedAt(dep.getCreatedAt());
                departmentResponse.setUpdatedAt(dep.getUpdatedAt());

                return departmentResponse;
            }
        }
        throw  new DepartmentNotFound("Department Not Found !!");
    }

    @Override
    public DepartmentResponse updateDepartment(String oldDepartmentName, String newDepartmentName) {

        List<Department> departmentList = departmentRepository.findAll();

        // make sure that new department name doen not exist already
        for (Department dep : departmentList){
            String depName = dep.getDepartmentName();

            if (depName.equalsIgnoreCase(newDepartmentName)){

                throw new RuntimeException("The new name already Exist please provide a different name");
            }
        }

        // find old department using name
        for (Department dep : departmentList){
            String depName = dep.getDepartmentName();

            if (depName.equalsIgnoreCase(oldDepartmentName)){

                dep.setDepartmentName(newDepartmentName); // updating the name
               Department savedDep = departmentRepository.save(dep); // saving changes into the database

                DepartmentResponse departmentResponse = new DepartmentResponse();
                departmentResponse.setDepartmentName(dep.getDepartmentName());
                departmentResponse.setDepartmentID(dep.getDepartmentID());
                departmentResponse.setCreatedAt(dep.getCreatedAt());
                departmentResponse.setUpdatedAt(dep.getUpdatedAt());

                return departmentResponse;

            }
        }
        throw  new DepartmentNotFound("Department Not Found !!");
    }

    @Override
    public String deleteDepartment(String departmentName) {

        List<Department> departmentList = departmentRepository.findAll();

        //find department using name
        for (Department dep : departmentList){
            String depName = dep.getDepartmentName();

            if (depName.equalsIgnoreCase(departmentName)){
                    String id = dep.getDepartmentID();

                departmentRepository.deleteById(id); // delete using id
                return "Department Deleted Successfully !!";
            }
        }

        throw new DepartmentNotFound("Department Does Not Exist !!");

    }
}
