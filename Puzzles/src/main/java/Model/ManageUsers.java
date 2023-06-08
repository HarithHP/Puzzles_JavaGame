/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.Home;
import View.SignIn;
import View.SignUp;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;






/**
 *
 * @author Hadaragama
 */

public class ManageUsers {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String uname;
    String upwd;
    String uemail;
    int userid;
    
    String answer;
    
    public ManageUsers(){
    con = SqlConnection.myCon();        
    }
    public void setInputSignIn(String uname,String upwd ){
         this.uname=uname;
         this.upwd=upwd;
         SignIn();
        }
    public void setInputSignUp(String uname,String uemail, String upwd ){
         this.uname=uname;
         this.uemail = uemail;
         this.upwd=upwd;
         SignUp();
        }
    private void SignIn(){   
        try{String query = "select * from user where uname = ?";
            pst=con.prepareCall(query);
            pst.setString(1,uname);
            rs=pst.executeQuery();
            if(rs.next()){
            checkUserPassword();
            }else{
            JOptionPane.showMessageDialog(null, "There isn't an account for this user name.","Error",JOptionPane.ERROR_MESSAGE);
            }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Sql connection Error.","Error",JOptionPane.ERROR_MESSAGE);      
            }            
    }
    
    public void checkUserPassword(){
         try{String query = "select * from user where upwd = ?";
            pst=con.prepareCall(query);
            pst.setString(1,upwd);
            rs=pst.executeQuery();
            if(rs.next()){ 
                getNameID();
                Home h = new Home(userid,uname);
                h.setVisible(true);
            }else{
            JOptionPane.showMessageDialog(null, "Your Password Incorrect");
            //new SignIn().setVisible(true);
            }
    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sql connection Error.","Error",JOptionPane.ERROR_MESSAGE);
            } 
    }
    public void SignUp(){
        try{ String query = "INSERT INTO `user`(`uname`, `uemail`, `upwd`) VALUES(?,?,?)"; 
           pst = con.prepareStatement(query);
           pst.setString(1,uname);
           pst.setString(2,uemail);
           pst.setString(3,upwd);
           pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "User Register Successfully");
             new SignIn().setVisible(true);
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex);
             new SignUp().setVisible(true);
         }
    }
    public void getNameID(){
        try{
           String query = "SELECT `uid` FROM `user` WHERE uname = ? AND upwd = ?"; 
           pst = con.prepareStatement(query);
           pst.setString(1,uname);
           pst.setString(2,upwd);
           rs =pst.executeQuery();
           if(rs.next()){
               userid=rs.getInt("uid");
               
           }           
       }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex);  
       }
    }
    
    
    
    

    
}
