/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.SignIn;
import View.SignUp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Hadaragama
 */
public class MinimumConnectorsSql {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    int userid;
    String userName;
    String disBetCities;
    int startpoint;
    String uswerAnswer;
    int totalDistance;

    public MinimumConnectorsSql(int userid, String userName, String disBetCities, int startpoint, String uswerAnswer, int totalDistance) {
        con = SqlConnection.myCon(); 
        this.userid = userid;
        this.userName = userName;
        this.disBetCities = disBetCities;
        this.startpoint = startpoint;
        this.uswerAnswer = uswerAnswer;
        this.totalDistance = totalDistance;
        
//            System.out.println("User ID : "+userid);
//            System.out.println("User Name : "+userName);
//            System.out.println("City Connections  : "+disBetCities);
//            System.out.println("City Connections Legnth  : "+disBetCities.length());
//            System.out.println("Start Point  : "+startpoint);
//            System.out.println("User Answer : "+ uswerAnswer);
//            System.out.println("User Answer for total distance: "+totalDistance);
    }
    public void saveAnswers(){
        try{ String query = "INSERT INTO "
                + "`minimumconnectorsanswers`(`uid`, `uname`, "
                + "`disBetCities`, `startPoint`, `uanswer`, `uTotDis`) VALUES (?,?,?,?,?,?)"; 
           pst = con.prepareStatement(query);
           pst.setInt(1,userid);
           pst.setString(2,userName);
           pst.setString(3,disBetCities);
           pst.setInt(4,startpoint);
           pst.setString(5,uswerAnswer);
           pst.setInt(6,totalDistance);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "Your Answer is Correct."
                   + "","Congragulations!",JOptionPane.INFORMATION_MESSAGE);
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex);
             
         }
    }
    
    
}
