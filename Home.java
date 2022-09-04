package cse_project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Home implements ActionListener{

    JTextField t1, t2, t3;
    JLabel a1, a2, a3, a4, a5, a6;
    JButton b1, b2, b3, b4;
    Icon icon, icon1, icon2, icon3, icon4;
    JFrame f = new JFrame("S K Y  C A S H");
    public Home() {
        // logo and name
        
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\project hasanf.png");
        f.setIconImage(icon);

        /*t1 = new JTextField("100 TK");
        t1.setBounds(335, 45, 100, 25);
          f.add(t1);*/

        //panel picture  
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

        //icon
        b1 = new JButton("STUDENT PAYMENT");
        b1.setBounds(650, 90, 250, 60);
        b1.setOpaque(true);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("MOBILE BANKING");
        b2.setBounds(950, 90, 250, 60);
        b2.setOpaque(true);
        b2.setContentAreaFilled(false);
        b2.setBorderPainted(false);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(b2);
        b2.addActionListener(this);
        
        
        
        b3 = new JButton("LOGOUT");
        b3.setBounds(50,640,150,70);
        b3.setOpaque(true);
        b3.setContentAreaFilled(false);
        b3.setBorderPainted(false);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Monospaced", Font.BOLD, 25));
        f.add(b3);
        b3.addActionListener(this);
        
        

        //setLayout(new FlowLayout());
        // add button
      
        f.add(panel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationByPlatform(true);
        f.setSize(1370, 790);
        f.setVisible(true);
        f.setResizable(false);

    }
    
      public void actionPerformed(ActionEvent e) 
    {
        
        
        if (e.getSource()==b1)
        {
            f.dispose();
            new Student_bill();
            
        }
        if (e.getSource()==b2)
        {
            f.dispose();
            new Mobile_bangking();
        }
         if (e.getSource()==b3)
        {
            f.dispose();
            try {
                new Admin();
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
