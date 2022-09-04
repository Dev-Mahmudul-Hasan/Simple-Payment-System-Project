package cse_project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Adminpage implements ActionListener {

    JTextField t1, t2, t3, t4;
    JLabel a1, a2, a3, a4, a5, a6;
    JButton b1, b2,b3;
    JTable m1;

    JFrame f = new JFrame("S K Y  C A S H");
    JTextArea textArea = new JTextArea("NAME       EMAIL      PASSWORD");
    JTextArea textArea2 = new JTextArea("STUDENT ID        AMOUNT");
    JTextArea textArea3 = new JTextArea("MOBILE NUMBER       AMOUNT");

    public Adminpage() throws IOException {
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\project hasanf.png");
        f.setIconImage(icon);

        // background and jpg
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\User\\Downloads\\hasan.jpg"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panel.add(picLabel);

        a1 = new JLabel("REGISTRATION INFORMATION");
        a1.setBounds(155, 150, 400, 50);
        a1.setForeground(Color.WHITE);
        a1.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(a1);
        textArea.setBounds(150, 200, 300, 400);
        f.add(textArea);
        b1 = new JButton("CHECK");
        b1.setBounds(230, 650, 100, 30);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(b1);
        b1.addActionListener(this);
        
        

        a2 = new JLabel("STUDENT PAYMENT CHECK");
        a2.setBounds(520, 150, 400, 50);
        a2.setForeground(Color.WHITE);
        a2.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(a2);
        textArea2.setBounds(500, 200, 300, 350);
        f.add(textArea2);
        a2 = new JLabel("STUDENT ID:");
        a2.setBounds(500, 560, 200, 50);
        a2.setForeground(Color.WHITE);
        a2.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(a2);
        t1 = new JTextField();
        t1.setBounds(640, 570, 160, 30);
        f.add(t1);
        t1.addActionListener(this);
        b2 = new JButton("CHECK");
        b2.setBounds(600, 650, 100, 30);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(b2);
        b2.addActionListener(this);
        
        

        a3 = new JLabel("MOBILE PAYMENT CHECK");
        a3.setBounds(885, 150, 400, 50);
        a3.setForeground(Color.WHITE);
        a3.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(a3);
        textArea3.setBounds(850, 200, 300, 350);
        f.add(textArea3);
        a3 = new JLabel("MOBILE NUMBER:");
        a3.setBounds(850, 560, 200, 50);
        a3.setForeground(Color.WHITE);
        a3.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(a3);
        t2 = new JTextField();
        t2.setBounds(1030, 570, 120, 30);
        f.add(t2);
         t2.addActionListener(this);
        b3 = new JButton("CHECK");
        b3.setBounds(970, 650, 100, 30);
        b3.setForeground(Color.BLACK);
        b3.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(b3);
        b3.addActionListener(this);
        
        
        
        

        f.add(panel);
        f.setSize(1370, 790);
        f.setVisible(true);
        f.setResizable(false);

    }

    public void actionPerformed(ActionEvent e) {
        
        String id = t1.getText();
        String number = t2.getText();
        
        
        
            Connection con = null;
            String dbname = "data";
            String mysql_username = "root";
            String mysql_password = "";

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = (Connection) java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname, mysql_username, mysql_password);

            } catch (ClassNotFoundException | SQLException ex) {
                  JOptionPane.showMessageDialog(null, "Database_conenction faild");
            }
            
            
        if (e.getSource() == b1) {
            try {
                Connection conn = con;
                Statement stmt = conn.createStatement();
                java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM `login`");
                textArea.setText("");
                while (rs.next()) {

                    String namee = rs.getString(1);
                    String email = rs.getString(2);
                    String pass = rs.getString(3);

                    textArea.append(namee + "    " + email + "    " + pass + "\n");
                 

                }

                conn.close();
            } catch (Exception ex) {
                System.out.println(e);
            }

        }
        
        if(e.getSource()==b2)
        {
             try  {
            Connection conn = con;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `student` WHERE 1");
         textArea2.setText("");
          while(rs.next())  
          {
                    String name = rs.getString(1);
                    String idd = rs.getString(2);
                    String amount = rs.getString(3);
             
               
              if(rs.getString(2).equals(id))
                {
                    textArea2.append(idd + "           " + amount +"\n");
                    
                }
             
          }
          
          conn.close(); 
        } catch (Exception ex) {
            System.out.println(ex);
        }
            
        }
          if(e.getSource()==b3)
        {
             try  {
            Connection conn = con;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `mobile` WHERE 1");
          textArea3.setText("");
          while(rs.next())  
          {
                    String numberr = rs.getString(1);
                    String amountt = rs.getString(2);
                
             
               
              if(rs.getString(1).equals(number))
                {
                    textArea3.append(numberr + "              " + amountt +"\n");
                    
                }
             
          }
          
          conn.close(); 
        } catch (Exception ex) {
            System.out.println(ex);
        }
            
        }
    }

}
