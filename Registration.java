package cse_project;

import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;

public class Registration implements ActionListener {

    JTextField t1, t2, t3;
    JLabel a1, a2, a3, a4, a5, a6,a7;
    JButton b1,b2;
    JFrame f = new JFrame("S K Y  C A S H");

    public Registration() {
        
        
        

        // logo and name
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\project hasanf.png");
        f.setIconImage(icon);

        // panel picture  
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("C:\\Users\\User\\Downloads\\hasan.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(JExercise.class.getName()).log(Level.SEVERE, null, ex);
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panel.add(picLabel);
        
        a6 = new JLabel("REGISTRATION FORM");
        a6.setBounds(565, 225, 300, 40);
        a6.setForeground(Color.WHITE);
        a6.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(a6);

       

        t1 = new JTextField();
        t1.setBounds(550, 305, 250, 30);
        t1.addActionListener(this);
        f.add(t1);;

        a1 = new JLabel("NAME:");
        a1.setBounds(440, 300, 90, 40);
        a1.setForeground(Color.WHITE);
        a1.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(a1);
        

        t2 = new JTextField();
        t2.setBounds(550, 370, 250, 30);
        t2.addActionListener(this);
        f.add(t2);

        a2 = new JLabel("Email:");
        a2.setBounds(440, 365, 90, 40);
        a2.setForeground(Color.WHITE);
        a2.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(a2);

        t3 = new JTextField();
        t3.setBounds(550, 440, 250, 30);
        t3.addActionListener(this);
        f.add(t3);

        a3 = new JLabel("PASS:");
        a3.setBounds(440, 435, 70, 40);
        a3.setForeground(Color.WHITE);
        a3.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(a3);

        b1 = new JButton("SIGN UP");
        b1.setBounds(620, 525, 120, 30);
        b1.setFont(new Font("Monospaced", Font.BOLD, 20));
        b1.setForeground(Color.RED);
        f.add(b1);
        b1.addActionListener(this);
        
        
         b2 = new JButton("DASHBOARD");
        b2.setBounds(1000,90,200,60);
        b2.setOpaque(true);
        b2.setContentAreaFilled(false);
        b2.setBorderPainted(false);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(b2);
        b2.addActionListener(this);
        
        

        /* f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            f.getContentPane().add(b1);

            b1.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    
                }
            }); */
        // add button
        f.add(panel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1370, 790);
        f.setVisible(true);
        f.setResizable(false);

    }

    public void actionPerformed(ActionEvent e)  {

        String name = t1.getText();
        String email= t2.getText();
        String pass = t3.getText();
        
        

        if (e.getSource() == b1) {
            Connectorr s1 = new Connectorr(name,email,pass);
            f.dispose();
            try {
               
                new Login();
                JOptionPane.showMessageDialog(null, "Registration Succecfully");
            } catch (IOException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
            
        }
        
        if(e.getSource()==b2)
        {
            f.dispose();
            try {
                new Admin();
            } catch (IOException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
