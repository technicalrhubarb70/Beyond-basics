package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeyondBasics extends JFrame implements ActionListener {

    private Container c;
    private JLabel title, lcat1, lcat3, lcat4, token,lprofile;
    private JButton lgout, profile, bcat1,  bcat3, bcat4,back;
    private String f;
    private JPanel p;
    private JLabel mb;

    public BeyondBasics(String user) {
        ImageIcon framelogo     = new ImageIcon("icons/shoppingcartlogo.png");
        setIconImage(framelogo.getImage());

        f=user;

        Icon icon = new ImageIcon("icons/groceriesi.png");
        Icon icon3 = new ImageIcon("icons/gadgeti.png");
        Icon icon4 = new ImageIcon("icons/fashioni.png");
        Icon iconl = new ImageIcon("icons/logout.png");
        Icon iconp = new ImageIcon("icons/profile.png");
        Icon micon = new ImageIcon("icons/mbanner.png");

        setTitle("BeyondBasics");
        setBounds(0, 0, 900, 600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //c.setBackground(Color.CYAN);


        c = getContentPane();
        c.setLayout(null);


        //for Emart
        title = new JLabel("BeyondBasics");
        title.setBounds(350, 5, 500, 50);
        title.setFont(new Font("forte", Font.PLAIN, 40));
        c.add(title);



        mb = new JLabel(micon);
        mb.setBounds(0, 70, 900, 210);
        c.add(mb);



        lgout = new JButton(iconl);
        lgout.setBounds(750, 5, 60, 60);
        lgout.addActionListener(this);
        //lgout.setVisible(false);
        c.add(lgout);

        profile = new JButton(iconp);
        profile.setBounds(820, 5, 60, 60);
        profile.addActionListener(this);
        // profile.setVisible(false);
        c.add(profile);


        lprofile = new JLabel (user);
        lprofile.setBounds(50, 10, 60, 30);
        lprofile.setForeground(Color.decode("#FFEFD6"));
        lprofile.setBackground(Color.decode("#006400"));
        lprofile.setHorizontalAlignment(JLabel.CENTER);
        lprofile.setOpaque(true);
        c.add(lprofile);


        bcat1 = new JButton(icon);
        bcat1.setBounds(50, 300, 200, 200);
        bcat1.addActionListener(this);
        //bcat1.setVisible(false);
        c.add(bcat1);

        lcat1 = new JLabel("Groceries");
        lcat1.setBounds(80, 520, 120, 30);
        lcat1.setFont(new Font("Arial", Font.PLAIN, 20));
        //lcat1.setVisible(false);
        c.add(lcat1);


        bcat3 = new JButton(icon3);
        bcat3.setBounds(350, 300, 200, 200);
        bcat3.addActionListener(this);
        //bcat3.setVisible(false);
        c.add(bcat3);

        lcat3 = new JLabel("Gadget");
        lcat3.setBounds(380, 520, 150, 30);
        lcat3.setFont(new Font("Arial", Font.PLAIN, 20));
        //lcat3.setVisible(false);
        c.add(lcat3);

        bcat4 = new JButton(icon4);
        bcat4.setBounds(650, 300, 200, 200);
        bcat4.addActionListener(this);
        //bcat4.setVisible(false);
        c.add(bcat4);

        lcat4 = new JLabel("Fashion");
        lcat4.setBounds(680, 520, 150, 30);
        lcat4.setFont(new Font("Arial", Font.PLAIN, 20));
        // lcat4.setVisible(false);
        c.add(lcat4);

        p = new JPanel();
        p.setBounds(0,0, 900, 70);
        p.setBackground(Color.decode("#3373C4"));
        c.add(p);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==bcat1){
            new Category1(f);
            setVisible(false);
        }
        else if(e.getSource()==bcat3){
            new Category2(f);
            setVisible(false);
        }
        else if(e.getSource()==bcat4){
            new Category3(f);
            setVisible(false);
        }
        else if (e.getSource()==lgout){
            new CustomerSignIn();
            setVisible(false);
        }
        else if(e.getSource()==profile){
            setVisible(false);
            new UProfile(f);
        }
    }


}

