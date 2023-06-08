/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hadaragama 
 */
public class SqlConnection {
    public static Connection myCon(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/puzzles","root","");
            return con;
            
        } catch (ClassNotFoundException | SQLException e) {
            
            System.err.println(e);
            return null;
        }
    
}
    
}
 