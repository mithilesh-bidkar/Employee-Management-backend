package com.example.EmployeeMS.dto.requestDTO;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRequest {

    String firstName;

    String lastName;

    String email;

    String departmentName;
}
