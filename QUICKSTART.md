# 🚀 Quick Start Guide - Fees Management System

Get up and running in 5 minutes!

## ⚡ Fastest Way to Run

### Prerequisites Check
- ✅ NetBeans IDE installed
- ✅ Java 8+ installed
- ✅ Apache Derby available

### 3-Step Quick Start

#### Step 1: Open in NetBeans (30 seconds)
```
File → Open Project → Select this folder → Open
```

#### Step 2: Setup Database (2 minutes)
```
1. Services tab (Ctrl + 5)
2. Databases → Right-click → Create Database
3. Database Name: fee_management
4. Username: root
5. Password: root
6. OK → Connect
7. Right-click on connection → Execute Command
8. Open database_setup.sql
9. Execute (Ctrl + Shift + E)
```

#### Step 3: Run Application (10 seconds)
```
Right-click on Login.java → Run File (Shift + F6)
```

🎉 **Done!** The login window should appear.

---

## 🔑 Default Login Credentials

After running the database setup script:

```
Username: admin
Password: admin123
```

---

## 📱 First Time Use

### 1. Login as Admin
Use the default credentials above.

### 2. OR Create New Account
Click "Signup" button and fill in:
- First Name
- Last Name
- Username (unique)
- Password (min 6 characters)
- Confirm Password
- Contact Number (10 digits)

### 3. Add Your First Fee Record
1. Click "Add Fees" from home screen
2. Fill in student details
3. Select course and payment mode
4. Enter amount
5. Click Save
6. Print receipt if needed

---

## 🛠️ Common Setup Issues & Quick Fixes

### ❌ Database Connection Error

**Error:** "Cannot connect to database"

**Fix:**
```
1. Ensure Derby server is running:
   Services → Databases → Java DB → Start Server
   
2. Check connection details in config.properties:
   db.url=jdbc:derby://localhost:1527/fee_management
   db.username=root
   db.password=root
```

### ❌ Compilation Errors

**Error:** "Package org.netbeans.lib.awtextra does not exist"

**Fix:**
```
Use NetBeans IDE - it includes required libraries automatically
```

### ❌ Database Not Found

**Error:** "Database 'fee_management' not found"

**Fix:**
```
1. Create database (see Step 2 above)
2. Run database_setup.sql script
```

### ❌ Admin Login Not Working

**Error:** "Wrong username or password"

**Fix:**
```
1. Check database_setup.sql was executed
2. Verify signup table has admin user:
   SELECT * FROM signup WHERE username='admin';
   
3. If not found, run:
   INSERT INTO signup VALUES 
   (1, 'Admin', 'User', 'admin', 'admin123', '9876543210', 
    'admin@vp.edu.in', CURRENT_TIMESTAMP, NULL, TRUE, 'ADMIN');
```

---

## 🎯 Quick Feature Tour

### Feature 1: Add Fees
```
Home → Add Fees → Fill Details → Save → Print
Time: 1 minute
```

### Feature 2: View/Edit Records
```
Home → Edit Fees → Select Record → Modify → Save
Time: 30 seconds
```

### Feature 3: Print Receipt
```
After adding fees → Click Print button
Time: 10 seconds
```

---

## 📋 Keyboard Shortcuts

| Action | Shortcut |
|--------|----------|
| Run Project | F6 |
| Run File | Shift + F6 |
| Build Project | F11 |
| Clean & Build | Shift + F11 |
| Execute SQL | Ctrl + Shift + E |
| Services Window | Ctrl + 5 |

---

## 🔧 Configuration (Optional)

Edit `config.properties` to customize:

```properties
# Change GST rates
tax.cgst.rate=9.0
tax.sgst.rate=9.0

# Change receipt prefix
receipt.prefix=VPFMS

# Add your GSTIN
receipt.gstin=27AABCU9603R1ZM
```

---

## 📊 Sample Data for Testing

After setup, the database includes:

**Sample Courses:**
- Computer Engineering
- Mechanical Engineering
- Civil Engineering
- Electrical Engineering
- Information Technology
- Electronics & Telecommunication

**Default Admin:**
- Username: admin
- Password: admin123
- Role: ADMIN

---

## 🎓 Learning Path

### Beginner
1. ✅ Setup and run the application
2. ✅ Create a user account
3. ✅ Add a fee record
4. ✅ Print a receipt

### Intermediate
1. ✅ Explore database structure
2. ✅ Modify configuration settings
3. ✅ Understand code structure
4. ✅ Add new payment methods

### Advanced
1. ✅ Extend functionality
2. ✅ Add new features
3. ✅ Integrate with other systems
4. ✅ Deploy in production

---

## 📱 Testing Checklist

Before using in production, test:

- [ ] User signup and login
- [ ] Add fee record (all payment modes)
- [ ] Edit existing record
- [ ] Print receipt
- [ ] Database backup
- [ ] Error handling
- [ ] Input validation
- [ ] GST calculations
- [ ] Number to words conversion
- [ ] Receipt numbering

---

## 🆘 Getting Help

1. **Documentation**
   - [README.md](README.md) - Complete documentation
   - [BUILD.md](BUILD.md) - Build instructions
   - [CONTRIBUTING.md](CONTRIBUTING.md) - Contribution guide

2. **Community**
   - GitHub Issues - Report bugs
   - GitHub Discussions - Ask questions

3. **Resources**
   - [NetBeans Documentation](https://netbeans.apache.org/kb/)
   - [Apache Derby Documentation](https://db.apache.org/derby/docs/)
   - [Java Swing Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)

---

## 🎉 You're Ready!

Now you can:
- ✅ Manage student fees
- ✅ Generate receipts
- ✅ Track payments
- ✅ Print professional receipts
- ✅ Calculate GST automatically

**Next Steps:**
1. Explore the application
2. Test all features
3. Customize as needed
4. Add your own enhancements

---

## 💡 Pro Tips

1. **Backup Regularly**
   ```sql
   -- Export data
   SYSCS_UTIL.SYSCS_EXPORT_TABLE (null, 'FEES_DETAILS', 
   'backup.csv', null, null, null);
   ```

2. **Monitor Database**
   ```sql
   -- Check record count
   SELECT COUNT(*) FROM fees_details;
   
   -- View recent transactions
   SELECT * FROM recent_transactions;
   ```

3. **Performance**
   - Close unused database connections
   - Regular database maintenance
   - Keep backups in separate location

4. **Security**
   - Change default admin password
   - Use strong passwords
   - Regular security audits

---

**Happy Fee Managing! 🎓💰**

---

**Version:** 2.0.0  
**Last Updated:** November 2025  
**Author:** Prem Hanchate  
**Institution:** Vidyalankar Polytechnic
