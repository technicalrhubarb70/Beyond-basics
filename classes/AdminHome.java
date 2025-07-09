package classes;
import Interface.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHome extends JFrame implements ActionListener,IAdminHome {

    private JFrame frame;
    private JLabel label1;
    private JButton userData;
    private JButton previous0;
    private JButton exitButton;
    private JTextArea display;
    private JLabel iad;
    private User x;

    public AdminHome(User a)
    {
        x=a;

        frame = new JFrame("Admin Home");
        ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
        ImageIcon previousImage = new ImageIcon("icons/previous.png");
        Icon iadi =new ImageIcon("icons/admini850.png");


        label1 = new JLabel("Admin Panel");
        label1.setForeground(Color.white);
        label1.setFont(new Font("Times New Roman",Font.PLAIN,50));
        // label1.setIcon(adminImage);
        // label1.setVerticalTextPosition(JLabel.BOTTOM);
        // label1.setHorizontalTextPosition(JLabel.CENTER);
        // label1.setFont(new Font("Imprint MT Shadow",Font.BOLD,25));
        label1.setBounds(290, 00, 400, 80);
        frame.add(label1);




        userData= new JButton("User Data");
        userData.setFont(new Font("Times New Roman", Font.BOLD, 15));
        userData.setBounds(300, 380, 100, 30);
        userData.setFocusable(false);
        userData.setBackground(Color.decode("#4682B4"));
        userData.setCursor(new Cursor(Cursor.HAND_CURSOR));
        userData.setBorder(BorderFactory.createEtchedBorder());
        userData.addActionListener(this);
        frame.add(userData);


        previous0 = new JButton ("Previous");
        previous0.setFont(new Font("Times New Roman", Font.BOLD, 15));
        previous0.setBounds(420, 380, 100, 30);
        previous0.setFocusable(false);
        previous0.setBackground(Color.decode("#4682B4"));
        previous0.setCursor(new Cursor(Cursor.HAND_CURSOR));
        previous0.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        previous0.addActionListener(this);
        previous0.setIcon(previousImage);
        frame.add(previous0);


        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        exitButton.setBounds(360, 440, 100, 30);
        exitButton.setFocusable(false);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.setBackground(Color.decode("#4682B4"));
        exitButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        exitButton.addActionListener(this);
        frame.add(exitButton);


        display = new JTextArea (3, 3);
        display.setBounds(10,20,200,140);
        display.setBackground(Color.decode("#4169E1"));
        display.setForeground(Color.white);
        display.setFont(new Font("Times New Roman",Font.BOLD,19));
        String name= a.getname();
        String pass = a.getPassword();
        display.setText("Admin Name: "+name+"\n\nAdmin Pass: "+pass);
        display.setEditable(false);
        frame.add(display);

        iad = new JLabel(iadi);
        iad.setBounds(0, 0,850, 550);
        frame.add(iad);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 550);
        frame.setIconImage(framelogo.getImage());
        frame.setResizable(false);
        frame.setLayout (null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==exitButton)
        {
            System.exit(0);
        }
        else if (e.getSource()==previous0)
        {
            frame.setVisible(false);
            new AdminSignIn();
        }
        else if (e.getSource()==userData)
        {
            frame.setVisible(false);
            new UserData(x);
        }
    }

}
