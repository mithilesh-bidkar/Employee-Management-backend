package com.example.EmployeeMS.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.EmployeeMS.repository.Mongo")
public class MongoDBConfig {

    @Bean
    public MongoTemplate mongoTemplate(){
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        return new MongoTemplate(mongoClient,"departmentDB");
    }
}
