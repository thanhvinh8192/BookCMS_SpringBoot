package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ConnectionConfig {
    @Value("{$database.url}")
    String url;
    @Value("{$database.user}")
    String user;
    @Value("{$database.pass}")
    String password;

    @Bean
    Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println(e);
        }
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("MySQL Database connection to successfully");
        } catch (
                SQLException sqlEx) {
            System.out.println(sqlEx);
        }
        return conn;
    }
}
