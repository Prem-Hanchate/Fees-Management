# Fees Management System

A comprehensive desktop application for managing student fees at **Vidyalankar Polytechnic**. This system provides a user-friendly interface for recording, tracking, and managing fee payments with receipt generation capabilities.

## 📋 Project Overview

**Developer:** Prem Hanchate  
**Project Type:** Micro-Project (Advanced Java Programming)  
**Institution:** Vidyalankar Polytechnic  
**Platform:** Java Swing Desktop Application  
**Database:** Apache Derby (Embedded)

## ✨ Features

### 🔐 User Authentication
- **Login System**: Secure user authentication with username and password
- **Signup Page**: New user registration with validation
- **Session Management**: Secure session handling for authenticated users

### 💰 Fee Management
- **Add Fees**: Record new fee payments with detailed information
  - Multiple payment modes (Cash, Cheque, DD, Card)
  - Course selection and fee calculation
  - GST calculation (CGST & SGST)
  - Automatic receipt number generation
  
- **Edit Fees**: Modify existing fee records
- **View Records**: Display all fee transaction records in tabular format
- **Print Receipt**: Generate and print professional fee receipts

### 📊 Payment Options
- Cash payments
- Cheque payments (with cheque number and bank details)
- Demand Draft (DD) with DD number tracking
- Card payments with bank information

### 🧮 Advanced Features
- **Automatic GST Calculation**: Calculates CGST and SGST automatically
- **Number to Words Conversion**: Converts fee amount to words for receipts
- **Receipt Generation**: Auto-generates unique receipt numbers
- **Date Tracking**: Records transaction dates with GSTIN support

## 🗂️ Project Structure

```
fees_management_system/
│
├── Login.java                    # Login screen and authentication
├── Signup_Page.java              # User registration
├── home.java                     # Dashboard/Home screen
├── Addfees.java                  # Add new fee record
├── Editfees.java                 # Edit existing fee records
├── PrintReciept.java             # Print fee receipts
├── DBConnection.java             # Database connection handler
├── NumberToWordsConverter.java   # Utility for number to words conversion
├── Fees_Management_System.java   # Main entry point
│
├── Login.form                    # NetBeans GUI form files
├── home.form
├── Addfees.form
├── Editfees.form
├── PrintReciept.form
│
└── images/                       # Application resources
    ├── vp_logo.png
    ├── plus.png
    ├── edit.png
    ├── login.png
    ├── logout.png
    ├── printer-.png
    └── [other UI icons]
```

## 🛠️ Technology Stack

- **Programming Language:** Java (JDK 8 or higher)
- **GUI Framework:** Java Swing with NetBeans Form Designer
- **Database:** Apache Derby (Embedded Database)
- **JDBC Driver:** `org.apache.derby.jdbc.EmbeddedDriver`
- **IDE:** NetBeans IDE (recommended)
- **Layout Manager:** NetBeans AbsoluteLayout

## 📦 Prerequisites

### Required Software
1. **Java Development Kit (JDK)** - Version 8 or higher
2. **NetBeans IDE** - Version 8.0 or higher (recommended)
3. **Apache Derby Database** - Embedded with NetBeans
4. **NetBeans AbsoluteLayout Library** - `org.netbeans.lib.awtextra`

### Database Configuration
- **Database Name:** `fee_management`
- **Host:** `localhost`
- **Port:** `1527`
- **Username:** `root`
- **Password:** `root`

## 🚀 Installation & Setup

### Method 1: Using NetBeans IDE (Recommended)

1. **Install NetBeans IDE**
   - Download from [netbeans.apache.org](https://netbeans.apache.org/)
   - Ensure Java SE bundle is installed

2. **Open the Project**
   ```
   File → Open Project → Navigate to project folder → Open
   ```

3. **Configure Apache Derby Database**
   - Open Services tab (Ctrl + 5)
   - Right-click on "Databases" → "Create Database"
   - Database Name: `fee_management`
   - Username: `root`
   - Password: `root`
   - Connect to the database

4. **Create Database Tables**
   
   Run the following SQL scripts in Derby database:

   **Signup Table:**
   ```sql
   CREATE TABLE signup (
       id INTEGER PRIMARY KEY,
       firstname VARCHAR(100),
       lastname VARCHAR(100),
       username VARCHAR(100) UNIQUE,
       password VARCHAR(100),
       contact VARCHAR(20)
   )
   ```

   **Fees Details Table:**
   ```sql
   CREATE TABLE fees_details (
       reciept_no INTEGER PRIMARY KEY,
       received_from VARCHAR(200),
       payment_mode VARCHAR(50),
       cheque_no VARCHAR(50),
       bank_name VARCHAR(100),
       dd_no VARCHAR(50),
       course_name VARCHAR(200),
       total_amount FLOAT,
       initial_amount FLOAT,
       cgst FLOAT,
       sgst FLOAT,
       amount_in_words VARCHAR(500),
       remarks VARCHAR(500),
       year_1 FLOAT,
       year_2 FLOAT
   )
   ```

5. **Start Apache Derby Server**
   - In NetBeans Services → Databases
   - Right-click on Derby → Start Server

6. **Run the Application**
   ```
   Right-click on Login.java → Run File
   ```

### Method 2: Command Line Setup

⚠️ **Note:** This project uses NetBeans-specific libraries. Running from command line requires additional setup.

1. **Download Required Libraries**
   - Download `AbsoluteLayout.jar` from Maven Repository
   ```
   https://mvnrepository.com/artifact/org.netbeans.external/AbsoluteLayout
   ```

2. **Set Up Derby Database**
   - Download Apache Derby standalone
   - Start Derby Network Server
   - Create database using ij tool

3. **Compile with Classpath**
   ```bash
   javac -cp ".:derby.jar:AbsoluteLayout.jar" *.java
   ```

4. **Run the Application**
   ```bash
   java -cp ".:derby.jar:AbsoluteLayout.jar" fees_management_system.Login
   ```

## 📖 How to Use

### 1️⃣ First Time Setup
1. Start the application
2. Click **Signup** button on login screen
3. Fill in registration details:
   - First Name
   - Last Name
   - Username (unique)
   - Password
   - Confirm Password
   - Contact Number
4. Click **Signup** to create account

### 2️⃣ Login
1. Enter your username and password
2. Click **Login** button
3. You'll be redirected to the Home screen

### 3️⃣ Add Fee Record
1. From Home screen, click **Add Fees**
2. Fill in the details:
   - Receipt Number (auto-generated)
   - Payment Mode (Cash/Cheque/DD/Card)
   - Student/Received From Name
   - Course Selection
   - Academic Year (Year 1 & Year 2)
   - Initial Amount
   - GST details (CGST & SGST - auto-calculated)
3. For non-cash payments, enter:
   - Cheque/DD Number
   - Bank Name
4. Review the total amount
5. Click **Save** to record the transaction
6. Click **Print** to generate receipt

### 4️⃣ Edit Fee Records
1. From Home screen, click **Edit Fees**
2. View all existing records in table format
3. Select a record to edit
4. Update the necessary fields
5. Save changes

### 5️⃣ Print Receipt
1. After adding fees, click **Print** button
2. Receipt shows:
   - Receipt Number
   - Student Name
   - Course Details
   - Payment Details
   - Amount breakdown (Base + CGST + SGST)
   - Amount in words
   - Institution logo and details

## 💡 Key Functionalities

### Payment Mode Handling
The system dynamically shows/hides fields based on payment mode:
- **Cash**: Only basic details required
- **Cheque**: Cheque number and bank name required
- **DD**: DD number and bank name required
- **Card**: Bank name required

### GST Calculation
- Automatically calculates CGST and SGST based on base amount
- Updates total amount in real-time
- Supports Indian taxation system

### Receipt Number Generation
- Auto-generates unique receipt numbers
- Uses database sequence to ensure no duplicates
- Format: Sequential integer starting from 1

### Amount to Words
- Converts numeric amount to Indian numbering system
- Supports: Units, Tens, Hundreds, Thousands, Lakhs, Crores
- Displays on receipt for clarity

## 🗄️ Database Schema

### Table: `signup`
| Column Name | Data Type    | Constraints |
|-------------|--------------|-------------|
| id          | INTEGER      | PRIMARY KEY |
| firstname   | VARCHAR(100) |             |
| lastname    | VARCHAR(100) |             |
| username    | VARCHAR(100) | UNIQUE      |
| password    | VARCHAR(100) |             |
| contact     | VARCHAR(20)  |             |

### Table: `fees_details`
| Column Name      | Data Type     | Constraints |
|------------------|---------------|-------------|
| reciept_no       | INTEGER       | PRIMARY KEY |
| received_from    | VARCHAR(200)  |             |
| payment_mode     | VARCHAR(50)   |             |
| cheque_no        | VARCHAR(50)   |             |
| bank_name        | VARCHAR(100)  |             |
| dd_no            | VARCHAR(50)   |             |
| course_name      | VARCHAR(200)  |             |
| total_amount     | FLOAT         |             |
| initial_amount   | FLOAT         |             |
| cgst             | FLOAT         |             |
| sgst             | FLOAT         |             |
| amount_in_words  | VARCHAR(500)  |             |
| remarks          | VARCHAR(500)  |             |
| year_1           | FLOAT         |             |
| year_2           | FLOAT         |             |

## 🔧 Configuration

### Database Connection Settings
Edit `DBConnection.java` to modify database settings:
```java
String url = "jdbc:derby://localhost:1527/fee_management";
String username = "root";
String password = "root";
```

### Look and Feel
The application uses **Nimbus** Look and Feel for modern UI appearance.

## ⚠️ Troubleshooting

### Common Issues

**1. Database Connection Error**
```
Error: Cannot connect to database
```
**Solution:** 
- Ensure Derby server is running
- Verify database name, username, and password
- Check if database exists

**2. Compilation Error: Package org.netbeans.lib.awtextra does not exist**
```
Solution: Use NetBeans IDE or add AbsoluteLayout.jar to classpath
```

**3. Class Not Found: org.apache.derby.jdbc.EmbeddedDriver**
```
Solution: Add Derby JDBC driver to project libraries
```

**4. Port Already in Use (1527)**
```
Solution: Stop existing Derby server or change port in DBConnection.java
```

## 🎯 Future Enhancements

- [ ] Add reports generation (PDF/Excel)
- [ ] Fee payment reminder system
- [ ] Student database integration
- [ ] Multi-user role management (Admin, Accountant)
- [ ] Dashboard with analytics
- [ ] Backup and restore functionality
- [ ] Email receipt feature
- [ ] Advanced search and filter options
- [ ] Payment history tracking
- [ ] Installment payment support

## 📝 License

This is an educational project developed as part of Advanced Java Programming coursework.

## 👨‍💻 Developer

**Prem Hanchate**  
Vidyalankar Polytechnic  
Advanced Java Programming - Micro Project

## 🤝 Contributing

This is an academic project. For suggestions or improvements, please contact the developer.

## 📞 Support

For any queries or issues related to this project, please contact:
- Institution: Vidyalankar Polytechnic
- Project Type: AJP Micro-Project

---

**Note:** This application is designed for educational purposes and demonstrates Java Swing GUI development, database connectivity, and transaction management concepts.
