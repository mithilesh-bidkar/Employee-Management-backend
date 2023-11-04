package com.example.EmployeeMS.Model.Mongo;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department {

    @Id
    String departmentID; // UUID will be generated

    String departmentName;

    @CreatedDate
    Date createdAt;

    @LastModifiedDate
    Date updatedAt;

    @Version
    Long version;

}
