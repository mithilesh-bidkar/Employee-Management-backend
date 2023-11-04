package com.example.EmployeeMS.Model.JPA;

import com.example.EmployeeMS.Model.Mongo.Department;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String firstName;

    String lastName;

    int mobileNo;

    String email;

    @CreationTimestamp
    Date createdAt;

    @UpdateTimestamp
    Date updatedAt;

    String departmentID;

}
