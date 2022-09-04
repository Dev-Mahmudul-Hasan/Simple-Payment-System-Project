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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Admin_login implements ActionListener {

    JTextField t1, t2;
    JLabel a1, a2, a3, a4, a5, a6;
    JButton b1, b2;
    JFrame f = new JFrame("S K Y  C A S H");

    public Admin_login() throws IOException {

        //logo and name
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\project hasanf.png");
        f.setIconImage(icon);

        // background and jpg
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\User\\Downloads\\hasan.jpg"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panel.add(picLabel);

        //text and button and label
        //email
        t1 = new JTextField();
        t1.setBounds(550, 305, 250, 30);
        t1.addActionListener(this);
        f.add(t1);

        a1 = new JLabel("Email:");
        a1.setBounds(440, 300, 90, 40);
        a1.setForeground(Color.WHITE);
        a1.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(a1);

        //pass
        t2 = new JTextField();
        t2.setBounds(550, 370, 250, 30);
        t2.addActionListener(this);
        f.add(t2);

        a2 = new JLabel("Pass:");
        a2.setBounds(440, 365, 70, 40);
        a2.setForeground(Color.WHITE);
        a2.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(a2);

        //signup
        // Login button
        b1 = new JButton("LOGIN");
        b1.setBounds(560, 440, 200, 50);
        b1.setOpaque(true);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Monospaced", Font.BOLD, 25));
        f.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("DASHBOARD");
        b2.setBounds(1000, 90, 200, 60);
        b2.setOpaque(true);
        b2.setContentAreaFilled(false);
        b2.setBorderPainted(false);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(b2);
        b2.addActionListener(this);

        a6 = new JLabel("ADMIN LOGIN");
        a6.setBounds(600, 225, 150, 40);
        a6.setForeground(Color.WHITE);
        a6.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(a6);

        // pass 2nd page..
        // pass 3d page..
        /*f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.getContentPane().add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                f.dispose();
                new Home();
            }
        });*/
        // add button and textfield
        f.add(panel);
        f.setSize(1370, 790);
        f.setVisible(true);
        f.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            f.dispose();
            try {
                new Admin();
            } catch (IOException ex) {
                Logger.getLogger(Admin_login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        String name = t1.getText();
       
        String id = t2.getText();
        if (e.getSource() == b1) {

            if (name.equals("") && id.equals("")) {
                f.dispose();
                try {
                    new Adminpage();
                } catch (IOException ex) {
                    Logger.getLogger(Admin_login.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "ADMIN LOGGIN");
            }
            else{
               JOptionPane.showMessageDialog(null, "WRONG EMAIL OR PASSWAORD"); 
            }

        }
    }

}
