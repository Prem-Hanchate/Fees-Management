# Build Instructions for Fees Management System

## Prerequisites

Before building the project, ensure you have:

1. **Java Development Kit (JDK)** - Version 8 or higher
2. **NetBeans IDE** - Version 8.0 or higher (Recommended)
3. **Apache Derby** - Embedded database
4. **NetBeans AbsoluteLayout Library** - Included with NetBeans

## Building with NetBeans IDE (Recommended)

### Step 1: Open Project in NetBeans

```
1. Launch NetBeans IDE
2. File → Open Project
3. Navigate to project folder
4. Select "fees_management_system"
5. Click "Open Project"
```

### Step 2: Resolve Dependencies

NetBeans will automatically resolve the following dependencies:
- `org.netbeans.lib.awtextra` (AbsoluteLayout)
- Apache Derby JDBC Driver

If dependencies are missing:
```
1. Right-click on Project → Properties
2. Libraries → Add JAR/Folder
3. Add required JARs
```

### Step 3: Build Project

```
Option A: Using Menu
- Right-click on project → Build

Option B: Using Keyboard
- Press F11

Option C: Using Toolbar
- Click the hammer icon (Build Project)
```

Build output will be in: `build/classes/`

### Step 4: Run Project

```
Option A: Run Main Class
- Right-click on Login.java → Run File
- Or press Shift + F6

Option B: Run Project
- Right-click on project → Run
- Or press F6
```

## Building from Command Line

⚠️ **Note:** Command-line build requires NetBeans libraries to be in classpath.

### For Windows (PowerShell)

```powershell
# Set up environment
$JAVA_HOME = "C:\Program Files\Java\jdk1.8.0_xxx"
$NETBEANS_HOME = "C:\Program Files\NetBeans-xxx"
$DERBY_HOME = "C:\Program Files\Java\jdk1.8.0_xxx\db"

# Add NetBeans library to classpath
$CLASSPATH = "$NETBEANS_HOME\platform\modules\org-netbeans-modules-settings.jar;$NETBEANS_HOME\java\modules\org-netbeans-lib-awtextra.jar;$DERBY_HOME\lib\derbyclient.jar"

# Create build directory
New-Item -ItemType Directory -Force -Path build\classes\fees_management_system

# Compile enhanced utility files (no NetBeans dependencies)
javac -d build\classes `
    DBConnection.java `
    ConfigManager.java `
    AppUtils.java `
    NumberToWordsConverter.java

# For full compilation (requires NetBeans libraries)
javac -cp $CLASSPATH -d build\classes *.java

# Run the application
java -cp "$CLASSPATH;build\classes" fees_management_system.Login
```

### For Linux/Mac (Bash)

```bash
#!/bin/bash

# Set up environment
export JAVA_HOME="/usr/lib/jvm/java-8-openjdk"
export NETBEANS_HOME="/opt/netbeans"
export DERBY_HOME="$JAVA_HOME/db"

# Add NetBeans library to classpath
export CLASSPATH="$NETBEANS_HOME/platform/modules/org-netbeans-modules-settings.jar:$NETBEANS_HOME/java/modules/org-netbeans-lib-awtextra.jar:$DERBY_HOME/lib/derbyclient.jar"

# Create build directory
mkdir -p build/classes/fees_management_system

# Compile enhanced utility files
javac -d build/classes \
    DBConnection.java \
    ConfigManager.java \
    AppUtils.java \
    NumberToWordsConverter.java

# For full compilation
javac -cp $CLASSPATH -d build/classes *.java

# Run the application
java -cp "$CLASSPATH:build/classes" fees_management_system.Login
```

## Downloading Required Libraries (Alternative)

If you want to build without NetBeans IDE:

### 1. Download AbsoluteLayout.jar

```
Maven Repository:
https://mvnrepository.com/artifact/org.netbeans.external/AbsoluteLayout

Download link:
https://repo1.maven.org/maven2/org/netbeans/external/AbsoluteLayout/RELEASE180/AbsoluteLayout-RELEASE180.jar
```

### 2. Download Derby JDBC Driver

```
Maven Repository:
https://mvnrepository.com/artifact/org.apache.derby/derbyclient

Download link:
https://repo1.maven.org/maven2/org/apache/derby/derbyclient/10.15.2.0/derbyclient-10.15.2.0.jar
```

### 3. Compile with Downloaded JARs

```bash
# Windows PowerShell
javac -cp "AbsoluteLayout.jar;derbyclient.jar" -d build\classes *.java

# Linux/Mac
javac -cp "AbsoluteLayout.jar:derbyclient.jar" -d build/classes *.java
```

## Build Verification

### Check Compilation Success

```bash
# List compiled classes
ls build/classes/fees_management_system/

# Expected output:
Addfees.class
AppUtils.class
ConfigManager.class
DBConnection.class
Editfees.class
home.class
Login.class
NumberToWordsConverter.class
PrintReciept.class
Signup_Page.class
# ... and related $*.class files
```

### Test Run

```bash
# Start Derby server first
cd $DERBY_HOME/bin
./startNetworkServer

# Run the application
java -cp "path/to/libs/*:build/classes" fees_management_system.Login
```

## Troubleshooting

### Common Build Errors

**Error: Package org.netbeans.lib.awtextra does not exist**
```
Solution: Add AbsoluteLayout.jar to classpath or use NetBeans IDE
```

**Error: Class not found: org.apache.derby.jdbc.EmbeddedDriver**
```
Solution: Add Derby JDBC driver to classpath
```

**Error: Cannot find symbol - class Login/home/etc.**
```
Solution: Ensure all .java files are in the same directory
         Compile all files together
```

### Clean Build

To perform a clean build:

```bash
# NetBeans
Right-click on project → Clean and Build

# Command Line
rm -rf build/
mkdir -p build/classes
javac -cp <classpath> -d build/classes *.java
```

## Creating Executable JAR

### Using NetBeans

```
1. Right-click on project → Properties
2. Build → Packaging
3. Check "Build JAR after Compiling"
4. Check "Copy Dependent Libraries"
5. Set Main Class: fees_management_system.Login
6. Click OK
7. Build Project
```

JAR will be created in: `dist/fees_management_system.jar`

### Run JAR

```bash
java -jar dist/fees_management_system.jar
```

## Continuous Integration

For CI/CD pipelines:

```yaml
# Example GitHub Actions workflow
name: Build and Test

on: [push, pull_request]

jobs:
  build:
    runs-on: ubuntu-latest
    
    steps:
    - uses: actions/checkout@v2
    
    - name: Set up JDK 8
      uses: actions/setup-java@v2
      with:
        java-version: '8'
        distribution: 'adopt'
    
    - name: Download dependencies
      run: |
        wget -O lib/AbsoluteLayout.jar https://repo1.maven.org/maven2/org/netbeans/external/AbsoluteLayout/RELEASE180/AbsoluteLayout-RELEASE180.jar
        wget -O lib/derby.jar https://repo1.maven.org/maven2/org/apache/derby/derbyclient/10.15.2.0/derbyclient-10.15.2.0.jar
    
    - name: Compile
      run: javac -cp "lib/*" -d build/classes *.java
```

## Performance Optimization

For better performance:

1. **Use connection pooling** (already implemented in DBConnection.java)
2. **Enable Derby optimization**:
   ```
   derby.system.durability=test
   derby.language.logStatementText=true
   ```
3. **Increase JVM heap size**:
   ```
   java -Xms256m -Xmx512m -jar app.jar
   ```

## Support

For build issues:
1. Check [README.md](README.md) for setup instructions
2. Review [TROUBLESHOOTING](#troubleshooting) section
3. Create an issue on GitHub

---

**Last Updated:** November 2025  
**Version:** 2.0.0  
**Author:** Prem Hanchate
