# 💰 Fees Management System

[![Version](https://img.shields.io/badge/version-2.0.0-blue.svg)](https://github.com/Prem-Hanchate/Fees-Management)
[![Java](https://img.shields.io/badge/Java-8%2B-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](LICENSE)
[![NetBeans](https://img.shields.io/badge/IDE-NetBeans-red.svg)](https://netbeans.apache.org/)

A comprehensive, professional-grade desktop application for managing student fees at **Vidyalankar Polytechnic**. This system provides a user-friendly interface for recording, tracking, and managing fee payments with advanced features like receipt generation, GST calculation, and comprehensive reporting.

## 📋 Project Overview

| Property | Details |
|----------|---------|
| **Developer** | Prem Hanchate |
| **Version** | 2.0.0 |
| **Project Type** | Micro-Project (Advanced Java Programming) |
| **Institution** | Vidyalankar Polytechnic |
| **Platform** | Java Swing Desktop Application |
| **Database** | Apache Derby (Embedded) |
| **License** | MIT License |

## ✨ Features

### 🎯 Version 2.0 Enhancements

#### 🔧 **Enhanced Architecture**
- **Improved Database Connection Manager** with connection pooling and error handling
- **Configuration Management System** for centralized settings
- **Comprehensive Utility Library** for common operations
- **Professional logging and debugging** capabilities
- **Better error handling** with user-friendly messages

#### 📝 **New Features**
- **Advanced validation** for all inputs (email, phone, names, amounts)
- **Configurable GST rates** through properties file
- **Enhanced receipt numbering** with customizable prefix
- **Audit logging** for tracking all operations
- **Multiple payment methods** support (Cash, Cheque, DD, Card, UPI, Net Banking)
- **Course master data** management
- **User role management** (Admin/User)

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
├── Core Application Files
│   ├── Login.java                      # Enhanced login with validation
│   ├── Signup_Page.java                # User registration
│   ├── home.java                       # Dashboard/Home screen
│   ├── Addfees.java                    # Add fee records
│   ├── Editfees.java                   # Edit fee records
│   ├── PrintReciept.java              # Receipt generation and printing
│   ├── Fees_Management_System.java    # Main entry point
│
├── Enhanced Core Components (New in v2.0)
│   ├── DBConnection.java              # Enhanced database connection manager
│   ├── ConfigManager.java             # Configuration management system
│   ├── AppUtils.java                  # Comprehensive utility library
│   ├── NumberToWordsConverter.java    # Amount to words conversion
│
├── Configuration & Setup
│   ├── config.properties              # Application configuration
│   ├── database_setup.sql             # Complete database setup script
│   ├── .gitignore                     # Git ignore rules
│
├── Documentation
│   ├── README.md                      # This file
│   ├── CHANGELOG.md                   # Version history
│   ├── CONTRIBUTING.md                # Contribution guidelines
│   ├── LICENSE                        # MIT License
│
├── NetBeans Forms
│   ├── Login.form
│   ├── home.form
│   ├── Addfees.form
│   ├── Editfees.form
│   ├── PrintReciept.form
│
└── Resources
    └── images/                        # UI icons and images
        ├── vp_logo.png
        ├── plus.png
        ├── edit.png
        └── [30+ UI icons]
```

## 🛠️ Technology Stack

| Component | Technology | Version |
|-----------|-----------|---------|
| **Language** | Java | 8+ |
| **GUI Framework** | Java Swing with NetBeans Form Designer | - |
| **Database** | Apache Derby (Embedded) | 10.14+ |
| **JDBC Driver** | `org.apache.derby.jdbc.EmbeddedDriver` | - |
| **IDE** | NetBeans IDE (recommended) | 8.0+ |
| **Layout** | NetBeans AbsoluteLayout | - |
| **Build Tool** | NetBeans Ant / Maven (optional) | - |
| **Version Control** | Git & GitHub | - |

### New in Version 2.0
- ✅ Singleton Design Pattern (Database & Configuration)
- ✅ Properties-based Configuration Management
- ✅ Advanced Logging System (Java Util Logging)
- ✅ Comprehensive Input Validation
- ✅ Enhanced Error Handling

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
   
   Use the enhanced database setup script provided:

   **Option A: Using NetBeans SQL Editor**
   - Open `database_setup.sql` in NetBeans
   - Execute the script section by section

   **Option B: Using ij tool**
   ```sql
   -- Connect to database
   connect 'jdbc:derby://localhost:1527/fee_management;user=root;password=root';
   
   -- Run the setup script
   run 'database_setup.sql';
   ```

   The script will create:
   - ✅ Enhanced `signup` table with validation constraints
   - ✅ Improved `fees_details` table with additional fields
   - ✅ New `courses` master table
   - ✅ New `payment_methods` table
   - ✅ New `audit_log` table for tracking
   - ✅ Useful views for reporting
   - ✅ Sample data (admin user and courses)
   - ✅ Database indexes for performance

   **Default Admin Credentials:**
   - Username: `admin`
   - Password: `admin123`

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

### Version 2.1 (Planned)
- [ ] PDF export for receipts using iText library
- [ ] Email notification system with JavaMail API
- [ ] Advanced search and filter with multiple criteria
- [ ] Payment reminder system
- [ ] Bulk operations (import/export)
- [ ] Data validation improvements

### Version 2.2 (Planned)
- [ ] Analytics dashboard with charts (JFreeChart)
- [ ] Comprehensive report generation (daily/monthly/yearly)
- [ ] Excel export functionality (Apache POI)
- [ ] Automated database backup system
- [ ] Multi-user role management with permissions
- [ ] SMS notifications integration

### Version 3.0 (Future)
- [ ] Web-based version using Spring Boot
- [ ] RESTful API for mobile apps
- [ ] Mobile application (Android/iOS)
- [ ] Payment gateway integration (Razorpay/PayU)
- [ ] Cloud database support (MySQL/PostgreSQL)
- [ ] Real-time notifications with WebSocket
- [ ] Microservices architecture

## 📚 Additional Resources

### Documentation Files

| File | Description |
|------|-------------|
| `README.md` | Complete project documentation (this file) |
| `CHANGELOG.md` | Version history and release notes |
| `CONTRIBUTING.md` | Guidelines for contributors |
| `LICENSE` | MIT License details |
| `database_setup.sql` | Complete database setup script |
| `config.properties` | Application configuration |

### Key Classes Documentation

#### DBConnection.java
Enhanced database connection manager with:
- Singleton pattern for resource management
- Connection validation and testing
- Safe resource cleanup methods
- Comprehensive error handling
- Logging capabilities

#### ConfigManager.java
Configuration management system with:
- Properties file support
- Type-safe getters for all data types
- Default configuration fallback
- Runtime configuration reload
- Convenience methods for common settings

#### AppUtils.java
Comprehensive utility library providing:
- Date/time formatting utilities
- Currency and number formatting
- Input validation (email, phone, name, etc.)
- UI helper methods (dialogs, messages)
- String manipulation utilities
- GST calculation helpers
- Receipt number generation

### Database Schema

For complete database schema including:
- Table structures with constraints
- Indexes for performance
- Useful views for reporting
- Sample data scripts

Please refer to `database_setup.sql`

## 🤝 Contributing

We welcome contributions! Please see our [Contributing Guidelines](CONTRIBUTING.md) for details on:
- How to report bugs
- How to suggest enhancements
- Code style guidelines
- Pull request process
- Areas for contribution

## 📝 Version History

See [CHANGELOG.md](CHANGELOG.md) for detailed version history and release notes.

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

**Academic Integrity Notice:** Students using this code must provide proper attribution. Use as a learning reference, not as a direct submission.

## 🤝 Contributing

Contributions are welcome! Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

## 👨‍💻 Developer

**Prem Hanchate**  
Vidyalankar Polytechnic  
Advanced Java Programming - Micro Project

📧 Contact: Via GitHub Issues  
🔗 Repository: [github.com/Prem-Hanchate/Fees-Management](https://github.com/Prem-Hanchate/Fees-Management)

## 🙏 Acknowledgments

- Vidyalankar Polytechnic for project guidance
- NetBeans IDE team for excellent development tools
- Apache Derby team for the embedded database
- Java Swing community for UI resources
- All contributors and supporters

## 📞 Support

For any queries or issues:
1. Check the [Documentation](#-additional-resources)
2. Review [Troubleshooting](#-troubleshooting) section
3. Search [existing issues](https://github.com/Prem-Hanchate/Fees-Management/issues)
4. Create a [new issue](https://github.com/Prem-Hanchate/Fees-Management/issues/new) if needed

## ⭐ Show Your Support

If you find this project useful:
- ⭐ Star the repository
- 🐛 Report bugs
- 💡 Suggest new features
- 🤝 Contribute code improvements
- 📢 Share with others

---

<div align="center">

**Built with ❤️ for Education**

**Version 2.0.0** | **November 2025**

[Report Bug](https://github.com/Prem-Hanchate/Fees-Management/issues) · [Request Feature](https://github.com/Prem-Hanchate/Fees-Management/issues) · [View Documentation](README.md)

</div>
