package com.example.EmployeeMS.repository.Mongo;

import com.example.EmployeeMS.Model.Mongo.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends MongoRepository<Department,String> {

}
