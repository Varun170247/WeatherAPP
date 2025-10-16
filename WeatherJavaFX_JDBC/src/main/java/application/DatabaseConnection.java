package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
// Update these with your DB credentials
private static final String URL = "jdbc:mysql://localhost:3306/weatherdb?useSSL=false&serverTimezone=UTC";
private static final String USER = "root";
private static final String PASSWORD = "your_password";


public static Connection getConnection() throws SQLException {
// Driver loading is automatic for modern JDBC, but keep for clarity
try {
Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
System.err.println("MySQL driver not found: " + e.getMessage());
}
return DriverManager.getConnection(URL, USER, PASSWORD);
}
}