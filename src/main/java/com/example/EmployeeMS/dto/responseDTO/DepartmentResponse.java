package com.example.EmployeeMS.dto.responseDTO;

import com.example.EmployeeMS.Model.JPA.Employee;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentResponse {

    String departmentID;

    String departmentName;

    Date createdAt;

    Date updatedAt;

}
