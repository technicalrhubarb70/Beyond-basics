package classes;
import Interface.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Payment extends JFrame implements ActionListener,IPayment{

    private JFrame frame;
    private JLabel cyp;
    private JLabel wao2;
    private JLabel pfuycd;
    private JLabel noc;
    private JLabel cn;
    private JLabel vn;
    private JLabel cvvc;
    private JLabel pay;

    private JTextField tfUName;
    private JTextField tfcn;
    private JTextField tfvo;
    private JPasswordField pfcvvc;

    private JButton cpB;
    private JButton exitButton;
    private JButton previous;

    private double z;

    private String Category;
    private String f;

    public Payment(double amount, String name, String user) {

        ImageIcon framelogo     = new ImageIcon("icons/shoppingcartlogo.png");
        setIconImage(framelogo.getImage());


        f= user;

        Category= name;

        z=amount;
        frame = new JFrame("Payment");



        cyp = new JLabel("Complete Your Payment");
        cyp.setForeground(Color.BLACK);
        cyp.setFont(new Font("Times New Roman", Font.PLAIN, 34));
        cyp.setBounds(700, 100, 500, 50);
        frame.add(cyp);


        Icon ipay  = new ImageIcon("icons/ipay.png");
        ImageIcon waoIcon2 = new ImageIcon("icons/wao2.png");
        wao2= new JLabel(waoIcon2);
        wao2.setBounds(480, 80, 500, 50);
        frame.add(wao2);



        pfuycd = new JLabel("Please Fillup Your Card Details Below---");
        pfuycd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        pfuycd.setBounds(700, 150, 400, 50);
        frame.add(pfuycd);


        noc = new JLabel("Name On Card :");
        noc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        noc.setBounds(700, 220, 150, 50);
        frame.add(noc);


        cn = new JLabel("Card Number :");
        cn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        cn.setBounds(700, 290, 500, 50);
        frame.add(cn);


        vn = new JLabel("Valid On: ");
        vn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        vn.setBounds(700, 360, 500, 50);
        frame.add(vn);

        cvvc = new JLabel("CVV Code: ");
        cvvc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        cvvc.setBounds(910, 360, 500, 50);
        frame.add(cvvc);


        tfUName = new JTextField();
        tfUName.setBounds(850, 235, 240, 23);
        tfUName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tfUName.setToolTipText("Your name?");
        tfUName.setVisible(true);
        frame.add(tfUName);


        tfcn = new JTextField();
        tfcn.setBounds(850, 305, 240, 23);
        tfcn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tfcn.setToolTipText("Your card number?");
        tfcn.setVisible(true);
        frame.add(tfcn);


        tfvo = new JTextField();
        tfvo.setBounds(790, 380, 100, 23);
        tfvo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tfvo.setToolTipText("Your card validity date?");
        tfvo.setVisible(true);
        frame.add(tfvo);


        pfcvvc = new JPasswordField();
        pfcvvc.setBounds(1020, 380, 100, 23);
        pfcvvc.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        pfcvvc.setToolTipText("Your CVV code?");
        pfcvvc.setEchoChar('*');
        pfcvvc.setVisible(true);
        frame.add(pfcvvc);


        cpB= new JButton("Confirm Payment");
        cpB.setBounds(870, 420, 200, 30);
        cpB.setFocusable(false);
        cpB.setBackground(Color.decode("#FAAB78"));
        cpB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        cpB.setBorder(BorderFactory.createEmptyBorder());
        cpB.addActionListener(this);
        cpB.setVisible(true);
        frame.add(cpB);


        exitButton = new JButton("Exit");
        exitButton.setBounds(1050, 460, 100, 30);
        exitButton.setFocusable(false);
        exitButton.setForeground(Color.black);
        exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        exitButton.setBackground(Color.decode("#FAAB78"));
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.addActionListener(this);
        frame.add(exitButton);


        previous = new JButton ("Previous");
        previous.setBounds(790, 460, 130, 30);
        previous.setFocusable(false);
        previous.setBackground(Color.decode("#FAAB78"));
        previous.setForeground(Color.black);
        previous.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        previous.setBorder(BorderFactory.createEmptyBorder());
        previous.addActionListener(this);
        previous.setVisible(true);
        frame.add(previous);

        pay = new JLabel(ipay);
        pay.setBounds(0,0,1280,720);
        frame.add(pay);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(Color.decode("#F2F2F2"));
        frame.setResizable(false);
        frame.setLayout (null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==previous)
        {
            if(Category=="Category1")
            {
                frame.setVisible(false);
                new Category1(f);
            }
            else if(Category=="Category2")
            {
                frame.setVisible(false);
                new Category2(f);
            }
            else if(Category=="Category3")
            {
                frame.setVisible(false);
                new Category3(f);
            }


        }
        else if(e.getSource()==exitButton)
        {
            int a = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", 0);
            if(a==0)
            {
                System.exit(0);
            }
        }

        else if(e.getSource()==cpB)
        {
            String a = tfUName.getText();
            String b = tfcn.getText();
            String c = tfvo.getText();
            String d = pfcvvc.getText();
            if (a.isEmpty()|| b.isEmpty() || c.isEmpty() || d.isEmpty())
            {
                JOptionPane.showInternalMessageDialog(null, "Please fill up all the necessary details");
            }
            else
            {
                try
                {
                    long m = Long.parseLong(b);
                    long n = Long.parseLong(d);

                    if(b.length()>16)
                    {
                        JOptionPane.showMessageDialog(null, "Card number should't have more than 16 digit ", "Alert!", 0);
                    }

                    else if (d.length()!=3)
                    {
                        JOptionPane.showMessageDialog(null, "CVV code number should have 3 digit ", "Alert!", 0);
                    }

                    else if(b.length()<=16 && d.length()==3)
                    {
                        frame.setVisible(false);
                        new PaymentSuccess(z,f);
                    }
                    try
                    {
                        File newfile = new File("data\\Last2.txt");
                        newfile.createNewFile();
                        FileWriter writeFile = new FileWriter("data\\Last2.txt");

                        writeFile.write("Name on Card : "+a+".\nCard Number :"+b+
                                ".\nValid On : "+c+".\nCVV Code : "+d+".");
                        writeFile.close();

                    }

                    catch(IOException io)
                    {
                        JOptionPane.showMessageDialog(null, "An error Occured while writting file");
                        io.printStackTrace();
                    }

                }


                catch(InputMismatchException a1)
                {
                    JOptionPane.showMessageDialog(null, "Please enter valid card no or code!", "Alert!", 0);
                }
                catch(NumberFormatException a2)
                {
                    JOptionPane.showMessageDialog(null, "Please enter valid information!", "Alert!", 0);
                }

            }
        }

    }

}
