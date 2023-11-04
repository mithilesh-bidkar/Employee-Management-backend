package com.example.EmployeeMS.Config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.EmployeeMS.repository.JPA")
public class PostgreSQLConfig<EntityManagerFactory extends jakarta.persistence.EntityManagerFactory> {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setPackagesToScan("com.example.EmployeeMS.Model.JPA");

        // Specify the JPA persistence provider
        entityManagerFactory.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);

        // Additional JPA properties
        // entityManagerFactory.setJpaProperties(jpaProperties());

        return entityManagerFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    // Additional JPA properties can be defined here
    // private Properties jpaProperties() {
    //     Properties properties = new Properties();
    //     properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    //     // Add other JPA properties here
    //     return properties;
    // }
}
