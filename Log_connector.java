
package cse_project;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Log_connector {

    public Log_connector(String email, String pass) {
        
        
        // connected database 
        Connection con = null;
        String dbname = "data";
        String mysql_username = "root";
        String mysql_password = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname, mysql_username, mysql_password);
           // System.out.println("Successfully");
        } catch (Exception e) {
            System.out.println("Error: unable to connect to database!");
        }

       
       
        try  {
            Connection conn = con;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `login` WHERE 1");
      
          while(rs.next())  
          {
               
              if(rs.getString(2).equals(email) && rs.getString(3).equals(pass))
                {
                    
                    new Home();
                }
             
          }
          
          conn.close(); 
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
    }

     
    
}
