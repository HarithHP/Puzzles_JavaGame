/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Hadaragama
 */
public class DijkstraMapSql {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    int userid;
    String userName;
    String disBetCities;
    String startpoint;
    String uswerAnswer;

    public DijkstraMapSql(int userid, String userName, String disBetCities, String startpoint,String uswerAnswer) {
        con = SqlConnection.myCon(); 
        this.userid = userid;
        this.userName = userName;
        this.disBetCities = disBetCities;
        this.startpoint = startpoint;
        this.uswerAnswer=uswerAnswer;
        
//        System.out.println("" + userid); 
//        System.out.println("" + userName); 
//        System.out.println("" + disBetCities); 
//        System.out.println("" + startpoint); 
//        System.out.println("" + uswerAnswer);     
    }
    public void saveAnswers(){
        try{ String query = "INSERT INTO `shortestpathanswers`"
                + "(`uid`, `uname`, `disBetCities`, `startPoint`,"
                + " `uanswer`) VALUES  (?,?,?,?,?)"; 
           pst = con.prepareStatement(query);
           pst.setInt(1,userid);
           pst.setString(2,userName);
           pst.setString(3,disBetCities);
           pst.setString(4,startpoint);
           pst.setString(5,uswerAnswer);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "Your Answer is "
                   + "Correct.","Congragulations!",JOptionPane.INFORMATION_MESSAGE);
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex);
             
         }
    }

}
