/*
 * Utility Helper Class for Fees Management System
 * Provides common utility functions used across the application
 * 
 * Author: Prem Hanchate
 * Vidyalankar Polytechnic
 */
package fees_management_system;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Utility class with helper methods for the application
 * 
 * @author Prem Hanchate
 * @version 2.0
 */
public class AppUtils {
    
    // Date formatters
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private static final SimpleDateFormat RECEIPT_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    // Number formatter
    private static final DecimalFormat CURRENCY_FORMAT = new DecimalFormat("#,##0.00");
    private static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("#,##0");
    
    // Validation patterns
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[6-9]\\d{9}$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z\\s]{2,50}$");
    
    /**
     * Private constructor to prevent instantiation
     */
    private AppUtils() {
        throw new IllegalStateException("Utility class");
    }
    
    // ========================================
    // Date and Time Utilities
    // ========================================
    
    /**
     * Get current date in standard format (dd-MM-yyyy)
     * 
     * @return Formatted date string
     */
    public static String getCurrentDate() {
        return DATE_FORMAT.format(new Date());
    }
    
    /**
     * Get current date and time
     * 
     * @return Formatted date-time string
     */
    public static String getCurrentDateTime() {
        return DATE_TIME_FORMAT.format(new Date());
    }
    
    /**
     * Get date for receipt (dd/MM/yyyy)
     * 
     * @return Formatted receipt date
     */
    public static String getReceiptDate() {
        return RECEIPT_DATE_FORMAT.format(new Date());
    }
    
    /**
     * Format date object to string
     * 
     * @param date Date object
     * @return Formatted date string
     */
    public static String formatDate(Date date) {
        return DATE_FORMAT.format(date);
    }
    
    // ========================================
    // Number Formatting Utilities
    // ========================================
    
    /**
     * Format number as currency (with 2 decimal places)
     * 
     * @param amount Amount to format
     * @return Formatted currency string
     */
    public static String formatCurrency(double amount) {
        return "₹ " + CURRENCY_FORMAT.format(amount);
    }
    
    /**
     * Format number without decimals
     * 
     * @param number Number to format
     * @return Formatted number string
     */
    public static String formatNumber(long number) {
        return NUMBER_FORMAT.format(number);
    }
    
    /**
     * Parse currency string to double
     * 
     * @param currencyStr Currency string
     * @return Double value or 0.0 if parsing fails
     */
    public static double parseCurrency(String currencyStr) {
        try {
            // Remove currency symbol and commas
            String cleaned = currencyStr.replaceAll("[₹,\\s]", "");
            return Double.parseDouble(cleaned);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
    
    // ========================================
    // Validation Utilities
    // ========================================
    
    /**
     * Validate email address format
     * 
     * @param email Email address to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
    
    /**
     * Validate Indian mobile number
     * 
     * @param phone Phone number to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidPhone(String phone) {
        return phone != null && PHONE_PATTERN.matcher(phone).matches();
    }
    
    /**
     * Validate name (alphabets and spaces only, 2-50 characters)
     * 
     * @param name Name to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidName(String name) {
        return name != null && NAME_PATTERN.matcher(name).matches();
    }
    
    /**
     * Check if string is null or empty
     * 
     * @param str String to check
     * @return true if null or empty, false otherwise
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    
    /**
     * Validate password strength
     * 
     * @param password Password to validate
     * @return true if strong enough, false otherwise
     */
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 6) {
            return false;
        }
        // Can add more complex validation if needed
        return true;
    }
    
    /**
     * Validate numeric input
     * 
     * @param str String to validate
     * @return true if numeric, false otherwise
     */
    public static boolean isNumeric(String str) {
        if (isNullOrEmpty(str)) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // ========================================
    // UI Utilities
    // ========================================
    
    /**
     * Show success message dialog
     * 
     * @param parent Parent component
     * @param message Message to display
     */
    public static void showSuccessMessage(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Success", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Show error message dialog
     * 
     * @param parent Parent component
     * @param message Error message to display
     */
    public static void showErrorMessage(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Show warning message dialog
     * 
     * @param parent Parent component
     * @param message Warning message to display
     */
    public static void showWarningMessage(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Warning", 
            JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * Show confirmation dialog
     * 
     * @param parent Parent component
     * @param message Confirmation message
     * @return true if user confirms, false otherwise
     */
    public static boolean showConfirmDialog(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message, "Confirm", 
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    
    /**
     * Set look and feel to Nimbus
     */
    public static void setNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, use default
            System.err.println("Nimbus Look and Feel not available: " + e.getMessage());
        }
    }
    
    /**
     * Center window on screen
     * 
     * @param window Window to center
     */
    public static void centerWindow(Window window) {
        window.setLocationRelativeTo(null);
    }
    
    // ========================================
    // String Utilities
    // ========================================
    
    /**
     * Capitalize first letter of each word
     * 
     * @param str Input string
     * @return Capitalized string
     */
    public static String capitalizeWords(String str) {
        if (isNullOrEmpty(str)) {
            return str;
        }
        
        String[] words = str.toLowerCase().split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1))
                      .append(" ");
            }
        }
        
        return result.toString().trim();
    }
    
    /**
     * Sanitize input string (remove special characters)
     * 
     * @param str Input string
     * @return Sanitized string
     */
    public static String sanitizeInput(String str) {
        if (isNullOrEmpty(str)) {
            return "";
        }
        return str.trim().replaceAll("[<>\"';]", "");
    }
    
    /**
     * Generate receipt number with prefix
     * 
     * @param sequence Receipt sequence number
     * @return Formatted receipt number
     */
    public static String generateReceiptNumber(int sequence) {
        ConfigManager config = ConfigManager.getInstance();
        String prefix = config.getProperty("receipt.prefix", "VPFMS");
        return String.format("%s-%06d", prefix, sequence);
    }
    
    // ========================================
    // Calculation Utilities
    // ========================================
    
    /**
     * Calculate CGST amount
     * 
     * @param baseAmount Base amount
     * @return CGST amount
     */
    public static double calculateCGST(double baseAmount) {
        ConfigManager config = ConfigManager.getInstance();
        double rate = config.getCGSTRate();
        return (baseAmount * rate) / 100.0;
    }
    
    /**
     * Calculate SGST amount
     * 
     * @param baseAmount Base amount
     * @return SGST amount
     */
    public static double calculateSGST(double baseAmount) {
        ConfigManager config = ConfigManager.getInstance();
        double rate = config.getSGSTRate();
        return (baseAmount * rate) / 100.0;
    }
    
    /**
     * Calculate total with GST
     * 
     * @param baseAmount Base amount
     * @return Total amount including GST
     */
    public static double calculateTotalWithGST(double baseAmount) {
        double cgst = calculateCGST(baseAmount);
        double sgst = calculateSGST(baseAmount);
        return baseAmount + cgst + sgst;
    }
    
    /**
     * Round to 2 decimal places
     * 
     * @param value Value to round
     * @return Rounded value
     */
    public static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
