package classes;


import java.awt.*;


import javax.swing.*;


import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Category2 extends JFrame implements ActionListener {



    private Container c;
    private JButton laptop;
    private JButton mobile;
    private JButton monitor;
    private JButton back;

    private JButton order;
    private JLabel nmlaptop;
    private JLabel prlaptop;
    private JLabel nmmobile;
    private JLabel prmobile;
    private JLabel nmmonitor;

    private JLabel prmonitor;

    private JLabel banner;
    private JButton crice;

    private JButton cmobile;

    private JButton cmonitor;

    private JCheckBox rlaptop;

    private JCheckBox rmobile;

    private JCheckBox rmonitor;

    private JComboBox<String> blaptop;

    private JComboBox<String> bmobile;

    private JComboBox<String> bmonitor;

    private String a []= {"1","2","3","4","5","6","7","8","9","10"};

    private String b []= {"1","2","3","4","5","6","7","8","9","10"};

    private String d []= {"1","2","3","4","5","6","7","8","9","10"};


    private String f;

    public Category2(String user){

        ImageIcon framelogo     = new ImageIcon("icons/shoppingcartlogo.png");
        setIconImage(framelogo.getImage());

        f=user;


        Icon bicon = new ImageIcon("icons/banner2.png");
        Icon ricei = new ImageIcon("icons/laptop.png");
        Icon mobilei = new ImageIcon("icons/mobile.png");
        Icon monitori = new ImageIcon("icons/monitor.png");





        setTitle("Gadget");
        setBounds(0,0,900,600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        c = getContentPane();
        c.setLayout(null);


        back = new JButton("Back");
        back.setBounds(145,500, 150, 50);
        back.setBackground(Color.RED);
        back.setOpaque(true);
        back.addActionListener(this);
        c.add(back);



        order = new JButton("Place Order");
        order.setBounds(625, 500, 150, 50);
        order.setBackground(Color.orange);
        order.setOpaque(true);
        order.addActionListener(this);
        c.add(order);



        banner = new JLabel( bicon);
        banner.setBounds(0, 0, 900, 150);
        c.add(banner);


        laptop = new JButton(ricei);
        laptop.setBounds(120,175,200,200);
        laptop.addActionListener(this);
        c.add(laptop);


        rlaptop = new JCheckBox("Mackbook Air M1");
        rlaptop.setBounds(120,385, 200, 30);
        rlaptop.setFont(new Font("Times New Roman",Font.PLAIN,15));
        c.add(rlaptop);



        prlaptop = new JLabel("100000 Tk");
        prlaptop.setBounds(150,415,150,20);
        prlaptop.setFont(new Font("Times New Roman",Font.PLAIN,15));
        c.add(prlaptop);





        blaptop = new JComboBox<String>(a);
        blaptop.setBounds(120,445,70,20);
        c.add(blaptop);



        nmlaptop =new JLabel("Peice");
        nmlaptop.setBounds(200,445,50,20);
        nmlaptop.setFont(new Font("Times New Roman",Font.PLAIN,15));
        c.add(nmlaptop);











        mobile = new JButton(mobilei);
        mobile.setBounds(350,175,200,200);
        mobile.addActionListener(this);
        c.add(mobile);



        rmobile = new JCheckBox("Iphone 14 pro max");
        rmobile.setBounds(350,385,200,30);
        rmobile.setFont(new Font("Times New Roman",Font.PLAIN,15));
        c.add(rmobile);



        prmobile = new JLabel("120000 Tk");
        prmobile.setBounds(380,415,150,20);
        prmobile.setFont(new Font("Times New Roman",Font.PLAIN,15));
        c.add(prmobile);



        bmobile = new JComboBox<String>(b);
        bmobile.setBounds(350,445,70,20);
        c.add(bmobile);



        nmmobile =new JLabel("Peice");
        nmmobile.setBounds(430,445,50,20);
        nmmobile.setFont(new Font("Times New Roman",Font.PLAIN,15));
        c.add(nmmobile);


        monitor = new JButton(monitori);
        monitor.setBounds(600,175,200,200);
        monitor.addActionListener(this);
        c.add(monitor);



        rmonitor = new JCheckBox("LG Ultragear");
        rmonitor.setBounds(600,385, 200, 30);
        rmonitor.setFont(new Font("Times New Roman",Font.PLAIN,15));
        c.add(rmonitor);



        prmonitor = new JLabel("80000 Tk");
        prmonitor.setBounds(630,415,150,20);
        prmonitor.setFont(new Font("Times New Roman",Font.PLAIN,15));
        c.add(prmonitor);



        bmonitor = new JComboBox<String>(b);
        bmonitor.setBounds(600,445,70,20);
        c.add(bmonitor);



        nmmonitor =new JLabel("Peice");
        nmmonitor.setBounds(680,445,150,20);
        nmmonitor.setFont(new Font("Times New Roman",Font.PLAIN,15));
        c.add(nmmonitor);




        setVisible(true);


    }


    @Override

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== back){

            new BeyondBasics(f);

            setVisible(false);

        }
        else if (e.getSource() == order) {
            double totalAmount = 0;
            double laptopamount = 0;
            double mobileamount = 0;
            double monitoramount = 0;
            int a = 0;
            int b = 0;
            int c = 0;


            if (rlaptop.isSelected() == true) {
                a = (blaptop.getSelectedIndex()) + 1;
                laptopamount = a * 100000;
            }
            if (rmobile.isSelected() == true) {
                b = bmobile.getSelectedIndex() + 1;
                mobileamount = b * 120000;
            }
            if (rmonitor.isSelected() == true) {
                c = bmonitor.getSelectedIndex() + 1;
                monitoramount = c * 80000;
            }

            totalAmount = laptopamount +
                    mobileamount +
                    monitoramount;
            if (totalAmount != 0) {
                int x = JOptionPane.showConfirmDialog(null, "Your Bill = " + totalAmount + " tk. Confirm Order?", " Conformation of Oder", 0);
                if (x == 0) {
                    setVisible(false);
                    new Payment(totalAmount, "Category2", f);

                    try {
                        File newfile = new File("data\\Last.txt");
                        newfile.createNewFile();
                        FileWriter file = new FileWriter("data\\Last.txt");

                        file.write("Laptop--- " + a + " Piece----" + laptopamount + " tk."
                                + "\n Mobile----" + b + " Piece---" + mobileamount + " tk."
                                + "\n Monitor---" + c + " Piece---" + monitoramount + " tk."
                                + "\n" + totalAmount + " tk Total.");
                        file.close();

                    } catch (IOException io) {
                        JOptionPane.showMessageDialog(null, "An error Occured and failed to create the file");
                        io.printStackTrace();
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select something before placing order!", "Message", 0);
            }
        }





    }





}