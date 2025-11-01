/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fees_management_system;

import java.sql.*;

/**
 *
 * @author admin
 */
public class DBConnection {
    public static Connection getConnection()
    {
        Connection con = null;
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         con = DriverManager.getConnection("jdbc:derby://localhost:1527/fee_management", "root","root");
         
        }catch(ClassNotFoundException | SQLException e){
        }
        return con;
    }
}
