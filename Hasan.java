
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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hasan {

    JTextField t1, t2, t3;
    JLabel a1, a2, a3, a4, a5, a6,a7;
    JButton b1,b2,b3;
    JFrame f = new JFrame("S K Y  C A S H");
    public Hasan() {
        
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
        
        
        a6 = new JLabel("DEVELOPER INFORMATION");
        a6.setBounds(110, 180, 300, 40);
        a6.setForeground(Color.WHITE);
        a6.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(a6);
        
        a5 = new JLabel("-----------------------------");
        a5.setBounds(110, 200, 300, 40);
        a5.setForeground(Color.WHITE);
        a5.setFont(new Font("Monospaced", Font.BOLD, 15));
        f.add(a5);
        
        a1 = new JLabel("NAME: MD.MAHMUDUL HASAN");
        a1.setBounds(110, 260, 300, 40);
        a1.setForeground(Color.WHITE);
        a1.setFont(new Font("Monospaced", Font.BOLD, 15));
        f.add(a1);
        
        a2 = new JLabel("EMAIL: mmdhasan150@gmail.com");
        a2.setBounds(110, 310, 300, 40);
        a2.setForeground(Color.WHITE);
        a2.setFont(new Font("Monospaced", Font.BOLD, 15));
        f.add(a2);
        
        a3 = new JLabel("NUMBER: 01700862929");
        a3.setBounds(110, 360, 300, 40);
        a3.setForeground(Color.WHITE);
        a3.setFont(new Font("Monospaced", Font.BOLD, 15));
        f.add(a3);
        
        a2 = new JLabel("GREEN UNIVERSITY OF BANGLADESH");
        a2.setBounds(50, 470, 400, 40);
        a2.setForeground(Color.WHITE);
        a2.setFont(new Font("Monospaced", Font.BOLD, 20));
        f.add(a2);
        
        b3 = new JButton("<-BACK");
        b3.setBounds(0,10,150,60);
        b3.setOpaque(true);
        b3.setContentAreaFilled(false);
        b3.setBorderPainted(false);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("DialogInput", Font.BOLD, 16));
        f.add(b3);
        
        
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            f.getContentPane().add(b3);

            b3.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    
                    f.dispose();
                    try {
                        new Admin();
                    } catch (IOException ex) {
                        Logger.getLogger(Hasan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            });
        
        
        
        f.add(panel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 700);
        f.setVisible(true);
        f.setResizable(false);
    }
    
}
