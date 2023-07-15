/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee_Management;

import java.sql.*;
public class ConnectionClass {
    Connection conn;
    Statement stmt;
    String url="jdbc:mysql://localhost:3306/employee_management";
    String username="root";
    String password="123456";
    ConnectionClass()
    {
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          conn = DriverManager.getConnection(url,username,password);
          stmt = conn.createStatement();
         
          
        }
        catch(Exception ex)
        {
          System.out.println(ex);
        }
    }
    
   /* public static void main(String args[])
    {
        new ConnectionClass();
    }  */
}
