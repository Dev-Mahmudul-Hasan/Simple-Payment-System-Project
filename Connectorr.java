
package cse_project;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class Connectorr  {

    public  Connectorr(String name, String email, String pass) 
    {
         Connection con = null;
        String dbname = "data";
        String mysql_username = "root";
        String mysql_password = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname, mysql_username, mysql_password);
           
        } catch (Exception e) {
            System.out.println("Error: unable to connect to database!");
        }

//insert or write value in database
        

        try {
            String query = "insert into login(name,email,pass) values ('" + name + "','" + email + "','" + pass + "')";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.execute();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

     
    
}
  

     

   
    

