package classes;
import Interface.*;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;


public class CustomerSignIn implements ActionListener,ICustomerSignIn{

    private JFrame  frame;
    private JLabel  title;
    private JLabel logo;
    private JButton loginButton;
    private JButton signUpButton1;
    private JButton exitButton;
    private JButton adminButton;
    private JButton previous0;
    private JButton frgtpass;
    private JButton admin;
    private JLabel  userName;
    private JLabel  userPass;
    private JLabel  confirmUserPass;
    private JLabel su;
    private JTextField tfUName;
    private JPasswordField pfUPass;
    private JPasswordField cpfUPass;
    private ImageIcon on;
    private ImageIcon off;
    private JToggleButton toggleButton;

    public CustomerSignIn()
    {
        frame = new JFrame("Beyond Basics");
        frame.setSize(800, 550);


        ImageIcon icon=new ImageIcon("icons/shoppingcartlogo.png");
        ImageIcon framelogo= new ImageIcon("icons/shoppingcartlogo.png");


        title = new JLabel("Sign In");
        title.setForeground(Color.decode("#54000E"));
        title.setFont(new Font("Times New Roman",Font.PLAIN,50));
        title.setBounds(550, 50, 250, 75);
        frame.add(title);
        title.setVisible(true);




//        shortNote = new JLabel(" Products of your Choice ");
//        shortNote.setForeground(Color.decode("#2A261F"));
//        shortNote.setFont(new Font("Harlow Solid Italic",Font.PLAIN,17));
//        shortNote.setBounds(420, 60, 380, 60);
//        frame.add(shortNote);

//        loginAlert = new JLabel ("Please Login to Continue....");
//        // loginAlert.setForeground(Color.LIGHT_GRAY);
//        loginAlert.setForeground(Color.decode("#808000"));
//        loginAlert.setFont(new Font("Algerian",Font.PLAIN,17));
//        loginAlert.setBounds(540, 300, 380, 60);
//        frame.add(loginAlert);





        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Times New Roman", 1, 19));
        loginButton.setBounds(585, 320, 80, 30);
        loginButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        loginButton.setBackground(Color.decode("#F0DC37"));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        frame.add(loginButton);




        signUpButton1 = new JButton("Sign Up");
        signUpButton1.setFont(new Font("Times New Roman", 1, 18));
        signUpButton1.setBounds(700, 380, 80, 30);
        signUpButton1.setBorder(new LineBorder(new Color(99, 215, 210), 2));
        signUpButton1.setBackground(Color.decode("#F0DC37"));
        signUpButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUpButton1.addActionListener(this);
        signUpButton1.setFocusable(false);
        signUpButton1.setContentAreaFilled(false);
        signUpButton1.setBorderPainted(false);
        signUpButton1.setForeground(new Color(158,82,1));
        frame.add(signUpButton1);



        su = new JLabel("Don't have an Account?");
        su.setFont(new Font("Times New Roman", 1, 17));
        su.setBounds(505,380,200, 30);
        frame.add(su);



        admin = new JButton("ADMIN");
        admin.setFont(new Font("Times New Roman", 1, 12));
        admin.setBounds(715, 0, 70, 20);
        admin.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        admin.setBackground(Color.decode("#FF6347"));
        admin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        admin.addActionListener(this);
        admin.setFocusable(false);
        frame.add(admin);



//        frgtpass = new JButton("FogotPassword");
//        frgtpass.setFont(new Font("Segoe UI", 1, 19));
//        frgtpass.setBounds(550, 440, 170, 30);
//        frgtpass.setBorder(new LineBorder(new Color(6, 90, 215), 2));
//        frgtpass.setBackground(Color.decode("#37f9f8"));
//        frgtpass.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        frgtpass.addActionListener(this);
//        frgtpass.setFocusable(false);
//        frgtpass.setVisible(false);
//        frame.add(frgtpass);




        exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Times New Roman", 1, 18));
        exitButton.setBounds(585, 450, 80, 30);
        exitButton.setBackground(Color.decode("#F9C700"));
        exitButton.setBorder(new LineBorder(new Color(6, 90, 215), 2));
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        frame.add(exitButton);


        userName = new JLabel("Username: ");
        userName.setBounds(550, 140, 200, 30);
        userName.setFont(new Font("Times New Roman", 1, 16));
        //userName.setIcon(userNameImage);
        // userName.setForeground(Color.decode("#FFFF00"));
        userName.setVisible(true);
        frame.add(userName);


        userPass = new JLabel("Password: ");
        userPass.setBounds(550, 220, 200, 30);
        userPass.setFont(new Font("Times New Roman", 1, 16));
        //userPass.setIcon(UserPassImage);
        // userPass.setForeground(Color.decode("#FFFF00"));
        userPass.setVisible(true);
        frame.add(userPass);


        confirmUserPass = new JLabel("Confirm Password: ");
        confirmUserPass.setBounds(180, 260, 180, 30);
        confirmUserPass.setFont(new Font("Times New Roman",Font.BOLD,16));
        confirmUserPass.setForeground(Color.decode("#FFFF00"));
        //confirmUserPass.setIcon(UserPassImage);
        confirmUserPass.setVisible(false);
        frame.add(confirmUserPass);


        tfUName = new JTextField();
        tfUName.setBounds(550, 180, 140, 23);
        tfUName.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
        tfUName.setToolTipText("Enter your name here");
        tfUName.setVisible(true);
        frame.add(tfUName);


        pfUPass = new JPasswordField();
        pfUPass.setBounds(550, 260, 140, 23);
        pfUPass.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
        pfUPass.setEchoChar('*');
        pfUPass.setToolTipText("Enter your password here");
        pfUPass.setVisible(true);
        frame.add(pfUPass);


        on = new ImageIcon("icons/tg1.png");
        off = new ImageIcon("icons/tg2.png");
        toggleButton = new JToggleButton(off);
        toggleButton.setBounds(700, 260, 40, 22);
        toggleButton.setBackground(new Color(143,188,143));
        toggleButton.setForeground(new Color(173,255,47));
        toggleButton.setOpaque(true);
        toggleButton.setBorder(BorderFactory.createEmptyBorder());
        toggleButton.setFocusable(false);
        toggleButton.setToolTipText("Show Password");
        toggleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        toggleButton.setVisible(true);
        frame.add(toggleButton);
        toggleButton.addActionListener(this);




        cpfUPass = new JPasswordField();
        cpfUPass.setBounds(350, 260, 140, 23);
        cpfUPass.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
        cpfUPass.setEchoChar('*');
        cpfUPass.setToolTipText("Re-write your password here");
        cpfUPass.setVisible(false);
        frame.add(cpfUPass);



        logo =new JLabel(icon);
        logo.setBounds(20,20,450,450);
        frame.add(logo);



        // frame.setUndecorated(true);
        frame.setIconImage(framelogo.getImage());
        frame.setResizable(false);
        frame.setLayout (null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {



        if (e.getSource() == toggleButton) {
            if (toggleButton.isSelected()) {
                toggleButton.setIcon(on);
                pfUPass.setEchoChar((char) 0);
            } else {
                toggleButton.setIcon(off);
                pfUPass.setEchoChar('*');
            }
        }



        if(e.getSource()==signUpButton1)
        {

            new CustomerSignUp();
            frame.setVisible(false);

        }
        else if (e.getSource()==previous0)
        {
            //loginAlert.setVisible(true);
            loginButton.setVisible(true);
            //loginButton2.setVisible(false);
            //frgtpass.setVisible(false);
            userName.setVisible(false);
            userPass.setVisible(false);
            tfUName.setVisible(false);
            pfUPass.setVisible(false);
            previous0.setVisible(false);
            signUpButton1.setVisible(true);
            toggleButton.setVisible(false);
        }

        else if(e.getSource()==exitButton)
        {
            System.exit(0);
        }


        else if(e.getSource()==loginButton)
        {
            String user = tfUName.getText();
            String pass = pfUPass.getText();
            if (user.isEmpty()|| pass.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            }


            else {

                try {
                    String userNameS = "User Name : " + user;
                    String passwordS = "Password : " + pass;
                    BufferedReader reader = new BufferedReader(new FileReader("data\\.user_data.txt"));

                    int totalLines = 0;
                    while (reader.readLine() != null)
                        totalLines++;
                    reader.close();

                    for (int i = 0; i <= totalLines; i++) {
                        String line = Files.readAllLines(Paths.get("data\\.user_data.txt")).get(i);
                        if (line.equals(userNameS)) {
                            String line2 = Files.readAllLines(Paths.get("data\\.user_data.txt")).get((i + 1));
                            if (line2.equals(passwordS)) {
                                frame.setVisible(false);
                                new BeyondBasics(user);
                                break;
                            }
                        }
                    }
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }

        }
        else if(e.getSource()==admin)
        {
            new AdminSignIn();
            frame.setVisible(false);
        }


    }

}
