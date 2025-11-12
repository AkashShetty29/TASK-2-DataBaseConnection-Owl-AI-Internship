package doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DatabaseConfig;
import entity.Student;

public class StudentDao {
	
    // Get database connection
	private Connection getConnection() throws SQLException {
	    try {
	        Class.forName(DatabaseConfig.DRIVER);
	    } catch (ClassNotFoundException e) {
	        throw new SQLException("MySQL JDBC Driver not found", e);
	    }
	    
	    // Use properties to avoid SSL warnings
	    return DriverManager.getConnection(
	        DatabaseConfig.URL, 
	        DatabaseConfig.getConnectionProperties()
	    );
	}
    
    // Retrieve all students using PreparedStatement
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(DatabaseConfig.SELECT_ALL);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Student student = extractStudentFromResultSet(rs);
                students.add(student);
            }
            System.out.println("Retrieved " + students.size() + " students from database.");
            
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } finally {
            closeResources(connection, pstmt, rs);
        }
        return students;
    }
    
    // Retrieve student by ID using PreparedStatement
    public Student getStudentById(int id) {
        Student student = null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(DatabaseConfig.SELECT_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                student = extractStudentFromResultSet(rs);
                System.out.println("Found student with ID: " + id);
            } else {
                System.out.println("No student found with ID: " + id);
            }
            
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } finally {
            closeResources(connection, pstmt, rs);
        }
        return student;
    }
    
    // Retrieve students by course using PreparedStatement
    public List<Student> getStudentsByCourse(String course) {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(DatabaseConfig.SELECT_BY_COURSE);
            pstmt.setString(1, course);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Student student = extractStudentFromResultSet(rs);
                students.add(student);
            }
            System.out.println("Found " + students.size() + " students in course: " + course);
            
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } finally {
            closeResources(connection, pstmt, rs);
        }
        return students;
    }
    
    // Test database connection
    public boolean testConnection() {
        Connection connection = null;
        try {
            connection = getConnection();
            System.out.println("Database connection successful!");
            System.out.println("Database: " + connection.getMetaData().getDatabaseProductName());
            return true;
        } catch (Exception e) {
            System.err.println("Database connection failed: " + e.getMessage());
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Ignoring close exceptions
                }
            }
        }
    }
    
    // Helper method to extract Student from ResultSet
    private Student extractStudentFromResultSet(ResultSet rs) throws SQLException {
        return new Student(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getInt("age"),
            rs.getString("course")
        );
    }
    
    // Proper resource closing method
    private void closeResources(Connection connection, PreparedStatement stmt, ResultSet rs) {
        // Close in reverse order: ResultSet -> Statement -> Connection
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // Ignore
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                // Ignore
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Ignore
            }
        }
    }

}
