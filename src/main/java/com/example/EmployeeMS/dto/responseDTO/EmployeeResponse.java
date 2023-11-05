package com.example.EmployeeMS.dto.responseDTO;

import com.example.EmployeeMS.Model.Mongo.Department;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponse {

    long id;

    String firstName;

    String lastName;



    String email;

    Date createdAt;

    Date updatedAt;

    Department department;
}
