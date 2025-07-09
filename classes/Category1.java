package classes;


import java.awt.*;


import javax.swing.*;


import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Category1 extends JFrame implements ActionListener {


    private Container c;


    private JButton rice;

    private JButton oil;

    private JButton juice;


    private JButton back;

    private JButton order;


    private JLabel nmrice;

    private JLabel prrice;

    private JLabel nmoil;

    private JLabel proil;

    private JLabel nmjuice;

    private JLabel prjuice;


    private JLabel banner;


    private JButton crice;

    private JButton coil;

    private JButton cjuice;


    private JCheckBox rrice;

    private JCheckBox roil;

    private JCheckBox rjuice;


    private JComboBox<String> brice;

    private JComboBox<String> boil;

    private JComboBox<String> bjuice;


    private String a[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    private String b[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    private String d[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


    private String f;


    public Category1(String user) {
        ImageIcon framelogo     = new ImageIcon("icons/shoppingcartlogo.png");
        setIconImage(framelogo.getImage());

        f = user;


        Icon bicon = new ImageIcon("icons/banner.png");

        Icon ricei = new ImageIcon("icons/rice.png");

        Icon oili = new ImageIcon("icons/oil.png");

        Icon juicei = new ImageIcon("icons/juice.png");


        setTitle("Groceries");

        setBounds(0, 0, 900, 600);

        setLayout(null);

        setResizable(false);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);


        c = getContentPane();

        c.setLayout(null);

        //c.setBackground(Color.CYAN);


        back = new JButton("Back");

        back.setBounds(145, 500, 150, 50);

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


        banner = new JLabel(bicon);

        banner.setBounds(0, 0, 900, 150);

        c.add(banner);


        rice = new JButton(ricei);

        rice.setBounds(120, 175, 200, 200);

        rice.addActionListener(this);

        c.add(rice);


        rrice = new JCheckBox("Chinigura Rice");

        rrice.setBounds(120, 385, 200, 30);

        rrice.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        c.add(rrice);


        prrice = new JLabel("150 Tk");

        prrice.setBounds(150, 415, 150, 20);

        prrice.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        c.add(prrice);


        brice = new JComboBox<String>(a);

        brice.setBounds(120, 445, 70, 20);

        c.add(brice);


        nmrice = new JLabel("Kg");

        nmrice.setBounds(200, 445, 50, 20);

        nmrice.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        c.add(nmrice);


        oil = new JButton(oili);

        oil.setBounds(350, 175, 200, 200);

        oil.addActionListener(this);

        c.add(oil);


        roil = new JCheckBox("Soyabean Oil");

        roil.setBounds(350, 385, 200, 30);

        roil.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        c.add(roil);


        proil = new JLabel("200 Tk");

        proil.setBounds(380, 415, 150, 20);

        proil.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        c.add(proil);


        boil = new JComboBox<String>(b);

        boil.setBounds(350, 445, 70, 20);

        c.add(boil);


        nmoil = new JLabel("Liter");
        nmoil.setBounds(430, 445, 50, 20);
        nmoil.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        c.add(nmoil);


        juice = new JButton(juicei);
        juice.setBounds(600, 175, 200, 200);
        juice.addActionListener(this);
        c.add(juice);


        rjuice = new JCheckBox("Mango Juice (2 Liter)");
        rjuice.setBounds(600, 385, 200, 30);
        rjuice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        c.add(rjuice);


        prjuice = new JLabel("200 Tk");
        prjuice.setBounds(630, 415, 150, 20);
        prjuice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        c.add(prjuice);


        bjuice = new JComboBox<String>(b);
        bjuice.setBounds(600, 445, 70, 20);
        c.add(bjuice);


        nmjuice = new JLabel("Peice");
        nmjuice.setBounds(680, 445, 150, 20);
        nmjuice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        c.add(nmjuice);


        setVisible(true);


    }


    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {

            new BeyondBasics(f);

            setVisible(false);
        } else if (e.getSource() == order) {
            double totalAmount = 0;
            double riceAmount = 0;
            double oilAmount = 0;
            double juiceAmount = 0;
            int a = 0;
            int b = 0;
            int c = 0;


            if (rrice.isSelected() == true) {
                a = (brice.getSelectedIndex()) + 1;
                riceAmount = a * 150;
            }
            if (roil.isSelected() == true) {
                b = boil.getSelectedIndex() + 1;
                oilAmount = b * 200;
            }
            if (rjuice.isSelected() == true) {
                c = bjuice.getSelectedIndex() + 1;
                juiceAmount = c * 200;
            }

            totalAmount = riceAmount +
                    oilAmount +
                    juiceAmount;
            if (totalAmount != 0) {
                int x = JOptionPane.showConfirmDialog(null, "Your Bill = " + totalAmount + " tk. Confirm Order?", " Conformation of Oder", 0);
                if (x == 0) {
                    setVisible(false);
                    new Payment(totalAmount, "Category1", f);

                    try {
                        File newfile = new File("data\\Last.txt");
                        newfile.createNewFile();
                        FileWriter file = new FileWriter("data\\Last.txt");

                        file.write("Rice--- " + a + " KG----" + riceAmount + " tk."
                                + "\nOil----" + b + " Litre---" + oilAmount + " tk."
                                + "\nJuice---" + c + " Piece---" + juiceAmount + " tk."
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