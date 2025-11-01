/*
 * Enhanced Database Connection Manager
 * Fees Management System - Vidyalankar Polytechnic
 * Author: Prem Hanchate
 * 
 * This class manages database connections with improved error handling,
 * connection pooling support, and logging capabilities.
 */
package fees_management_system;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton Database Connection Manager
 * Provides centralized database connection handling with enhanced error management
 * 
 * @author Prem Hanchate
 * @version 2.0
 */
public class DBConnection {
    
    // Logger for tracking database operations
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());
    
    // Database configuration constants
    private static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_URL = "jdbc:derby://localhost:1527/fee_management";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";
    
    // Singleton instance
    private static Connection connection = null;
    
    /**
     * Private constructor to prevent instantiation
     */
    private DBConnection() {
        // Private constructor for singleton pattern
    }
    
    /**
     * Gets database connection with enhanced error handling and logging
     * 
     * @return Connection object or null if connection fails
     */
    public static Connection getConnection() {
        try {
            // Check if existing connection is valid
            if (connection != null && !connection.isClosed()) {
                return connection;
            }
            
            // Load Derby JDBC driver
            Class.forName(DB_DRIVER);
            LOGGER.log(Level.INFO, "Derby JDBC Driver loaded successfully");
            
            // Establish new connection
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            LOGGER.log(Level.INFO, "Database connection established successfully");
            
            return connection;
            
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Derby JDBC Driver not found. Please add derby.jar to classpath", e);
            showErrorMessage("Database Driver Error", 
                "Derby database driver not found.\nPlease ensure Apache Derby is properly installed.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to connect to database", e);
            showErrorMessage("Database Connection Error", 
                "Unable to connect to database.\n" +
                "Please ensure:\n" +
                "1. Derby server is running\n" +
                "2. Database 'fee_management' exists\n" +
                "3. Username and password are correct\n\n" +
                "Error: " + e.getMessage());
        }
        return null;
    }
    
    /**
     * Tests database connection
     * 
     * @return true if connection is successful, false otherwise
     */
    public static boolean testConnection() {
        Connection testCon = null;
        try {
            testCon = getConnection();
            return testCon != null && !testCon.isClosed();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Connection test failed", e);
            return false;
        }
    }
    
    /**
     * Closes database connection safely
     */
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                LOGGER.log(Level.INFO, "Database connection closed successfully");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error closing database connection", e);
        }
    }
    
    /**
     * Closes ResultSet safely
     * 
     * @param rs ResultSet to close
     */
    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error closing ResultSet", e);
        }
    }
    
    /**
     * Closes Statement safely
     * 
     * @param stmt Statement to close
     */
    public static void closeStatement(Statement stmt) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error closing Statement", e);
        }
    }
    
    /**
     * Closes PreparedStatement safely
     * 
     * @param pstmt PreparedStatement to close
     */
    public static void closePreparedStatement(PreparedStatement pstmt) {
        try {
            if (pstmt != null && !pstmt.isClosed()) {
                pstmt.close();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error closing PreparedStatement", e);
        }
    }
    
    /**
     * Display error message to user
     * 
     * @param title Error dialog title
     * @param message Error message
     */
    private static void showErrorMessage(String title, String message) {
        try {
            javax.swing.JOptionPane.showMessageDialog(null, message, title, 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // If GUI is not available, print to console
            System.err.println(title + ": " + message);
        }
    }
    
    /**
     * Get database connection URL
     * 
     * @return Database URL string
     */
    public static String getDatabaseURL() {
        return DB_URL;
    }
    
    /**
     * Get database username
     * 
     * @return Database username
     */
    public static String getDatabaseUsername() {
        return DB_USERNAME;
    }
}
