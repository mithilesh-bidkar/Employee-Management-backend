package com.example.EmployeeMS.service;

import com.example.EmployeeMS.dto.responseDTO.DepartmentResponse;


public interface DepartmentService {


    String addDepartment(String departmentName);

    DepartmentResponse getDepartment(String departmentName);

    DepartmentResponse updateDepartment(String oldDepartmentName, String newDepartmentName);

    String deleteDepartment(String departmentName);
}
