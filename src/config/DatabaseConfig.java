package config;

import java.util.Properties;

public class DatabaseConfig {
	
	//Connection parameters
	public static final String URL = "jdbc:mysql://localhost:3306/student_db";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Aakash@2971";
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	//SQL queries for retrieving
    public static final String SELECT_ALL = "SELECT * FROM students ORDER BY id";
    public static final String SELECT_BY_ID = "SELECT * FROM students WHERE id = ?";
    public static final String SELECT_BY_COURSE = "SELECT * FROM students WHERE course = ? ORDER BY name";

    // Connection properties to disable SSL warnings
    public static Properties getConnectionProperties() {
        Properties props = new Properties();
        props.setProperty("user", USERNAME);
        props.setProperty("password", PASSWORD);
        props.setProperty("useSSL", "false");
        props.setProperty("allowPublicKeyRetrieval", "true");
        props.setProperty("serverTimezone", "UTC");
        props.setProperty("verifyServerCertificate", "false");
        return props;
    }
    
}
