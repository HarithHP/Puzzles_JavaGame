/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.SignIn;
import View.SignUp;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Hadaragama
 */
public class EightQueensSql {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    int userid;
    String uname;
    String answer;
    int count;
    
    public EightQueensSql(int userid,String answer,String uname){
        con = SqlConnection.myCon();  
        this.answer=answer;
        this.userid=userid;
        this.uname=uname;
    }
    
    public void checkCount(){ 
        try{String query = "SELECT COUNT(*) FROM eightqueensanswers";
            pst=con.prepareCall(query);
            rs=pst.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            if(count==92){
                restAnswers();
            }
            }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Sql connection Error.","Error",JOptionPane.ERROR_MESSAGE);      
            }            
    }
    public void restAnswers(){ 
         try{ String query = "DELETE FROM `eightqueensanswers`"; 
           pst = con.prepareStatement(query);
           pst.executeUpdate();
             System.out.println("Reseted Successfully");
         }catch(SQLException | HeadlessException ex){
             JOptionPane.showMessageDialog(null, ex);
         }           
    }
    
    public void checkAnswer(String answer){ 
        this.answer=answer;
        try{String query = "select * from eightqueensanswers where answer = ?";
            pst=con.prepareCall(query);
            pst.setString(1,answer);
            rs=pst.executeQuery();
            if(rs.next()){
            JOptionPane.showMessageDialog(null, "Your answer is correct but it already submit"
                    + " by someone.","Bad Luck",JOptionPane.ERROR_MESSAGE);
            }else{
            inputAnswer();
            }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Sql connection Error.","Error",JOptionPane.ERROR_MESSAGE);      
            }            
    }
    public void inputAnswer(){
        try{ String query = "INSERT INTO `eightqueensanswers`(`uid`,`uname`, `answer`) VALUES (?,?,?)"; 
           pst = con.prepareStatement(query);
           pst.setInt(1,userid);
           pst.setString(2,uname);
           pst.setString(3,answer);
           pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Your answer "
                     + "is correct.","Congradulations",JOptionPane.INFORMATION_MESSAGE);
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex);
         }
    }
    
}
