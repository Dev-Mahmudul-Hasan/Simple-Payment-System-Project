
package cse_project;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


class Student_connector {

    Student_connector(String name, String id, String amount)
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

        try {
            String query = "insert into student(name,id,amount) values ('" + name + "','" + id+ "','" + amount+ "')";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.execute();
            JOptionPane.showMessageDialog(null, "SUCCESSFULLY PAYMENT");
            
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
       
    }

    void Amount(String amount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
