-- ========================================
-- Fees Management System - Database Setup Script
-- Vidyalankar Polytechnic
-- Author: Prem Hanchate
-- Version: 2.0
-- Database: Apache Derby
-- ========================================

-- ========================================
-- 1. CREATE DATABASE
-- ========================================
-- Run this command in ij tool or NetBeans Services:
-- CREATE DATABASE fee_management;
-- CONNECT 'jdbc:derby://localhost:1527/fee_management;user=root;password=root';

-- ========================================
-- 2. CREATE TABLES
-- ========================================

-- Drop tables if they exist (for fresh installation)
DROP TABLE IF EXISTS fees_details;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS payment_methods;
DROP TABLE IF EXISTS signup;
DROP TABLE IF EXISTS audit_log;

-- User Authentication Table
CREATE TABLE signup (
    id INTEGER NOT NULL PRIMARY KEY,
    firstname VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    contact VARCHAR(20),
    email VARCHAR(100),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE,
    user_role VARCHAR(20) DEFAULT 'USER',
    CONSTRAINT chk_username_length CHECK (LENGTH(username) >= 3),
    CONSTRAINT chk_password_length CHECK (LENGTH(password) >= 6)
);

-- Fee Details Table (Enhanced)
CREATE TABLE fees_details (
    reciept_no INTEGER NOT NULL PRIMARY KEY,
    received_from VARCHAR(200) NOT NULL,
    payment_mode VARCHAR(50) NOT NULL,
    cheque_no VARCHAR(50),
    bank_name VARCHAR(100),
    dd_no VARCHAR(50),
    course_name VARCHAR(200) NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    initial_amount DECIMAL(10,2) NOT NULL,
    cgst DECIMAL(10,2) DEFAULT 0.00,
    sgst DECIMAL(10,2) DEFAULT 0.00,
    amount_in_words VARCHAR(500),
    remarks VARCHAR(500),
    year_1 DECIMAL(10,2) DEFAULT 0.00,
    year_2 DECIMAL(10,2) DEFAULT 0.00,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    gstin VARCHAR(50),
    created_by VARCHAR(100),
    updated_date TIMESTAMP,
    is_cancelled BOOLEAN DEFAULT FALSE,
    CONSTRAINT chk_amount_positive CHECK (total_amount > 0),
    CONSTRAINT chk_payment_mode CHECK (payment_mode IN ('Cash', 'Cheque', 'DD', 'Card', 'UPI', 'Net Banking'))
);

-- Courses Master Table
CREATE TABLE courses (
    course_id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    course_code VARCHAR(20) NOT NULL UNIQUE,
    course_name VARCHAR(200) NOT NULL,
    course_duration INTEGER NOT NULL, -- in years
    course_fee DECIMAL(10,2) NOT NULL,
    department VARCHAR(100),
    is_active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_duration CHECK (course_duration > 0),
    CONSTRAINT chk_fee CHECK (course_fee > 0)
);

-- Payment Methods Table
CREATE TABLE payment_methods (
    method_id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    method_name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(200),
    is_active BOOLEAN DEFAULT TRUE,
    requires_bank_details BOOLEAN DEFAULT FALSE,
    requires_reference_no BOOLEAN DEFAULT FALSE
);

-- Audit Log Table
CREATE TABLE audit_log (
    log_id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    username VARCHAR(100),
    action VARCHAR(100) NOT NULL,
    table_name VARCHAR(50),
    record_id INTEGER,
    old_value VARCHAR(1000),
    new_value VARCHAR(1000),
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ip_address VARCHAR(50)
);

-- ========================================
-- 3. CREATE INDEXES
-- ========================================

-- Index on signup table
CREATE INDEX idx_signup_username ON signup(username);
CREATE INDEX idx_signup_contact ON signup(contact);

-- Index on fees_details table
CREATE INDEX idx_fees_date ON fees_details(transaction_date);
CREATE INDEX idx_fees_mode ON fees_details(payment_mode);
CREATE INDEX idx_fees_course ON fees_details(course_name);
CREATE INDEX idx_fees_received_from ON fees_details(received_from);

-- Index on courses table
CREATE INDEX idx_course_code ON courses(course_code);
CREATE INDEX idx_course_active ON courses(is_active);

-- Index on audit_log table
CREATE INDEX idx_audit_username ON audit_log(username);
CREATE INDEX idx_audit_timestamp ON audit_log(timestamp);

-- ========================================
-- 4. INSERT DEFAULT DATA
-- ========================================

-- Insert default admin user (password: admin123)
INSERT INTO signup (id, firstname, lastname, username, password, contact, email, user_role) 
VALUES (1, 'Admin', 'User', 'admin', 'admin123', '9876543210', 'admin@vp.edu.in', 'ADMIN');

-- Insert sample courses
INSERT INTO courses (course_code, course_name, course_duration, course_fee, department) VALUES
('COMP', 'Computer Engineering', 3, 45000.00, 'Engineering'),
('MECH', 'Mechanical Engineering', 3, 42000.00, 'Engineering'),
('CIVIL', 'Civil Engineering', 3, 40000.00, 'Engineering'),
('ELECT', 'Electrical Engineering', 3, 43000.00, 'Engineering'),
('IT', 'Information Technology', 3, 45000.00, 'Engineering'),
('EXTC', 'Electronics & Telecommunication', 3, 44000.00, 'Engineering');

-- Insert payment methods
INSERT INTO payment_methods (method_name, description, requires_bank_details, requires_reference_no) VALUES
('Cash', 'Cash payment at counter', FALSE, FALSE),
('Cheque', 'Payment by cheque', TRUE, TRUE),
('DD', 'Demand Draft payment', TRUE, TRUE),
('Card', 'Credit/Debit card payment', TRUE, FALSE),
('UPI', 'UPI payment', FALSE, TRUE),
('Net Banking', 'Online net banking', TRUE, TRUE);

-- ========================================
-- 5. CREATE VIEWS
-- ========================================

-- View for daily collection summary
CREATE VIEW daily_collection AS
SELECT 
    CAST(transaction_date AS DATE) as collection_date,
    payment_mode,
    COUNT(*) as transaction_count,
    SUM(total_amount) as total_collection
FROM fees_details
WHERE is_cancelled = FALSE
GROUP BY CAST(transaction_date AS DATE), payment_mode;

-- View for course-wise collection
CREATE VIEW course_collection AS
SELECT 
    course_name,
    COUNT(*) as total_students,
    SUM(total_amount) as total_fees_collected,
    AVG(total_amount) as average_fee
FROM fees_details
WHERE is_cancelled = FALSE
GROUP BY course_name;

-- View for recent transactions
CREATE VIEW recent_transactions AS
SELECT 
    reciept_no,
    received_from,
    course_name,
    total_amount,
    payment_mode,
    transaction_date
FROM fees_details
WHERE is_cancelled = FALSE
ORDER BY transaction_date DESC
FETCH FIRST 50 ROWS ONLY;

-- ========================================
-- 6. CREATE SEQUENCES (if needed)
-- ========================================

-- Derby uses IDENTITY columns, so sequences are auto-managed

-- ========================================
-- 7. GRANT PERMISSIONS (if using different users)
-- ========================================

-- GRANT ALL PRIVILEGES ON TABLE signup TO root;
-- GRANT ALL PRIVILEGES ON TABLE fees_details TO root;
-- GRANT ALL PRIVILEGES ON TABLE courses TO root;
-- GRANT ALL PRIVILEGES ON TABLE payment_methods TO root;
-- GRANT ALL PRIVILEGES ON TABLE audit_log TO root;

-- ========================================
-- 8. VERIFICATION QUERIES
-- ========================================

-- Verify tables created
-- SELECT TABLENAME FROM SYS.SYSTABLES WHERE TABLETYPE='T';

-- Verify data inserted
-- SELECT * FROM signup;
-- SELECT * FROM courses;
-- SELECT * FROM payment_methods;

-- ========================================
-- END OF SCRIPT
-- ========================================

-- Notes:
-- 1. Run this script in order from top to bottom
-- 2. Ensure Derby server is running before execution
-- 3. Default admin credentials: username=admin, password=admin123
-- 4. Course fees can be modified as per requirement
-- 5. Add more courses as needed using INSERT statements
