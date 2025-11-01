/*
 * Configuration Manager for Fees Management System
 * Loads and manages application configuration from properties file
 * 
 * Author: Prem Hanchate
 * Vidyalankar Polytechnic
 */
package fees_management_system;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton Configuration Manager
 * Handles loading and accessing application configuration settings
 * 
 * @author Prem Hanchate
 * @version 2.0
 */
public class ConfigManager {
    
    private static final Logger LOGGER = Logger.getLogger(ConfigManager.class.getName());
    private static ConfigManager instance = null;
    private Properties properties;
    private static final String CONFIG_FILE = "config.properties";
    
    /**
     * Private constructor for singleton pattern
     */
    private ConfigManager() {
        properties = new Properties();
        loadConfiguration();
    }
    
    /**
     * Get singleton instance of ConfigManager
     * 
     * @return ConfigManager instance
     */
    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) {
                    instance = new ConfigManager();
                }
            }
        }
        return instance;
    }
    
    /**
     * Load configuration from properties file
     */
    private void loadConfiguration() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                // Try loading from current directory
                File configFile = new File(CONFIG_FILE);
                if (configFile.exists()) {
                    try (FileInputStream fileInput = new FileInputStream(configFile)) {
                        properties.load(fileInput);
                        LOGGER.log(Level.INFO, "Configuration loaded successfully from: " + CONFIG_FILE);
                    }
                } else {
                    LOGGER.log(Level.WARNING, "Configuration file not found. Using default settings.");
                    loadDefaultConfiguration();
                }
            } else {
                properties.load(input);
                LOGGER.log(Level.INFO, "Configuration loaded successfully");
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error loading configuration file", e);
            loadDefaultConfiguration();
        }
    }
    
    /**
     * Load default configuration if file is not found
     */
    private void loadDefaultConfiguration() {
        // Database defaults
        properties.setProperty("db.driver", "org.apache.derby.jdbc.EmbeddedDriver");
        properties.setProperty("db.url", "jdbc:derby://localhost:1527/fee_management");
        properties.setProperty("db.username", "root");
        properties.setProperty("db.password", "root");
        
        // Application defaults
        properties.setProperty("app.name", "Fees Management System");
        properties.setProperty("app.version", "2.0");
        properties.setProperty("app.institution", "Vidyalankar Polytechnic");
        
        // Tax defaults
        properties.setProperty("tax.cgst.rate", "9.0");
        properties.setProperty("tax.sgst.rate", "9.0");
        
        LOGGER.log(Level.INFO, "Default configuration loaded");
    }
    
    /**
     * Get string property value
     * 
     * @param key Property key
     * @return Property value or null
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    /**
     * Get string property with default value
     * 
     * @param key Property key
     * @param defaultValue Default value if key not found
     * @return Property value or default value
     */
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
    
    /**
     * Get integer property value
     * 
     * @param key Property key
     * @param defaultValue Default value if key not found or invalid
     * @return Property value as integer
     */
    public int getIntProperty(String key, int defaultValue) {
        String value = properties.getProperty(key);
        if (value != null) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "Invalid integer value for key: " + key, e);
            }
        }
        return defaultValue;
    }
    
    /**
     * Get double property value
     * 
     * @param key Property key
     * @param defaultValue Default value if key not found or invalid
     * @return Property value as double
     */
    public double getDoubleProperty(String key, double defaultValue) {
        String value = properties.getProperty(key);
        if (value != null) {
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "Invalid double value for key: " + key, e);
            }
        }
        return defaultValue;
    }
    
    /**
     * Get boolean property value
     * 
     * @param key Property key
     * @param defaultValue Default value if key not found
     * @return Property value as boolean
     */
    public boolean getBooleanProperty(String key, boolean defaultValue) {
        String value = properties.getProperty(key);
        if (value != null) {
            return Boolean.parseBoolean(value);
        }
        return defaultValue;
    }
    
    /**
     * Set property value
     * 
     * @param key Property key
     * @param value Property value
     */
    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
    
    /**
     * Save configuration to file
     * 
     * @return true if saved successfully, false otherwise
     */
    public boolean saveConfiguration() {
        try (FileOutputStream output = new FileOutputStream(CONFIG_FILE)) {
            properties.store(output, "Fees Management System Configuration");
            LOGGER.log(Level.INFO, "Configuration saved successfully");
            return true;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error saving configuration file", e);
            return false;
        }
    }
    
    /**
     * Reload configuration from file
     */
    public void reloadConfiguration() {
        loadConfiguration();
    }
    
    // Convenience methods for commonly used properties
    
    public String getDatabaseDriver() {
        return getProperty("db.driver", "org.apache.derby.jdbc.EmbeddedDriver");
    }
    
    public String getDatabaseURL() {
        return getProperty("db.url", "jdbc:derby://localhost:1527/fee_management");
    }
    
    public String getDatabaseUsername() {
        return getProperty("db.username", "root");
    }
    
    public String getDatabasePassword() {
        return getProperty("db.password", "root");
    }
    
    public String getApplicationName() {
        return getProperty("app.name", "Fees Management System");
    }
    
    public String getApplicationVersion() {
        return getProperty("app.version", "2.0");
    }
    
    public String getInstitutionName() {
        return getProperty("app.institution", "Vidyalankar Polytechnic");
    }
    
    public double getCGSTRate() {
        return getDoubleProperty("tax.cgst.rate", 9.0);
    }
    
    public double getSGSTRate() {
        return getDoubleProperty("tax.sgst.rate", 9.0);
    }
    
    public String getReceiptGSTIN() {
        return getProperty("receipt.gstin", "27AABCU9603R1ZM");
    }
}
