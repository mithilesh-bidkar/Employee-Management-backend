package com.example.EmployeeMS;

import com.example.EmployeeMS.Config.MongoDBConfig;
import com.example.EmployeeMS.Config.PostgreSQLConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@Import({MongoDBConfig.class, PostgreSQLConfig.class})
@EnableMongoAuditing
public class EmployeeMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMsApplication.class, args);
	}

}
