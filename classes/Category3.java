package classes;


import java.awt.*;


import javax.swing.*;


import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Category3 extends JFrame implements ActionListener {


    private Container c;


    private JButton shirt;

    private JButton watch;

    private JButton shoes;


    private JButton back;

    private JButton order;


    private JLabel nmshirt;

    private JLabel prshirt;

    private JLabel nmwatch;

    private JLabel prwatch;

    private JLabel nmshoes;

    private JLabel prshoes;


    private JLabel banner;


    private JButton cshirt;

    private JButton cwatch;

    private JButton cshoes;


    private JCheckBox rshirt;

    private JCheckBox rwatch;

    private JCheckBox rshoes;


    private JComboBox<String> bshirt;

    private JComboBox<String> bwatch;

    private JComboBox<String> bshoes;


    private String a[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    private String b[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    private String d[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


    private String f;


    public Category3(String user) {

        ImageIcon framelogo     = new ImageIcon("icons/shoppingcartlogo.png");
        setIconImage(framelogo.getImage());


        f = user;


        Icon bicon = new ImageIcon("icons/banner3.png");

        Icon shirti = new ImageIcon("icons/shirti.png");

        Icon watchi = new ImageIcon("icons/watch.png");

        Icon shoesi = new ImageIcon("icons/shoes.png");


        setTitle("Fashion");

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


        shirt = new JButton(shirti);

        shirt.setBounds(120, 175, 200, 200);

        shirt.addActionListener(this);

        c.add(shirt);


        rshirt = new JCheckBox("Men Shirt");

        rshirt.setBounds(120, 385, 200, 30);

        rshirt.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        c.add(rshirt);


        prshirt = new JLabel("1500 Tk");

        prshirt.setBounds(150, 415, 150, 20);

        prshirt.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        c.add(prshirt);


        bshirt = new JComboBox<String>(a);

        bshirt.setBounds(120, 445, 70, 20);

        c.add(bshirt);


        nmshirt = new JLabel("peice");

        nmshirt.setBounds(200, 445, 50, 20);

        nmshirt.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        c.add(nmshirt);


        watch = new JButton(watchi);

        watch.setBounds(350, 175, 200, 200);

        watch.addActionListener(this);

        c.add(watch);


        rwatch = new JCheckBox("Titan Watch");

        rwatch.setBounds(350, 385, 200, 30);

        rwatch.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        c.add(rwatch);


        prwatch = new JLabel("5000 Tk");

        prwatch.setBounds(380, 415, 150, 20);

        prwatch.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        c.add(prwatch);


        bwatch = new JComboBox<String>(b);

        bwatch.setBounds(350, 445, 70, 20);

        c.add(bwatch);


        nmwatch = new JLabel("Peice");

        nmwatch.setBounds(430, 445, 50, 20);

        nmwatch.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        c.add(nmwatch);


        shoes = new JButton(shoesi);

        shoes.setBounds(600, 175, 200, 200);

        shoes.addActionListener(this);

        c.add(shoes);


        rshoes = new JCheckBox("Men Formal Shoes");

        rshoes.setBounds(600, 385, 200, 30);

        rshoes.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        c.add(rshoes);


        prshoes = new JLabel("2000 Tk");

        prshoes.setBounds(630, 415, 150, 20);

        prshoes.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        c.add(prshoes);


        bshoes = new JComboBox<String>(b);

        bshoes.setBounds(600, 445, 70, 20);

        c.add(bshoes);


        nmshoes = new JLabel("Peice");

        nmshoes.setBounds(680, 445, 150, 20);

        nmshoes.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        c.add(nmshoes);


        setVisible(true);


    }


    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {

            new BeyondBasics(f);

            setVisible(false);

        } else if (e.getSource() == order) {
            double totalAmount = 0;
            double shirtamount = 0;
            double watchamount = 0;
            double shoesamount = 0;
            int a = 0;
            int b = 0;
            int c = 0;


            if (rshirt.isSelected() == true) {
                a = (bshirt.getSelectedIndex()) + 1;
                shirtamount = a * 150;
            }
            if (rwatch.isSelected() == true) {
                b = bwatch.getSelectedIndex() + 1;
                watchamount = b * 200;
            }
            if (rshoes.isSelected() == true) {
                c = bshoes.getSelectedIndex() + 1;
                shoesamount = c * 200;
            }

            totalAmount = shirtamount +
                    watchamount +
                    shoesamount;
            if (totalAmount != 0) {
                int x = JOptionPane.showConfirmDialog(null, "Your Bill = " + totalAmount + " tk. Confirm Order?", " Conformation of Oder", 0);
                if (x == 0) {
                    setVisible(false);
                    new Payment(totalAmount, "Category3", f);

                    try {
                        File newfile = new File("data\\Last.txt");
                        newfile.createNewFile();
                        FileWriter file = new FileWriter("data\\Last.txt");

                        file.write("Shirt--- " + a + " Piece----" + shirtamount + " tk."
                                + "\nWatch----" + b + " Piece---" + watchamount + " tk."
                                + "\nShoes---" + c + " Piece---" + shoesamount + " tk."
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