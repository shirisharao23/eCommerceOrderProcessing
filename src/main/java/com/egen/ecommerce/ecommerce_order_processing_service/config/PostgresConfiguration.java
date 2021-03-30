package com.egen.ecommerce.ecommerce_order_processing_service.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgresConfiguration {
    
    
    private final String username = "docker";

    
    private final String password = "docker";

   
    private final String url = "jdbc:postgresql://localhost:5432/ecommerce";       
    
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    

}
