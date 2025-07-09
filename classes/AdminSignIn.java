package classes;
import Interface.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSignIn extends JFrame implements ActionListener,IAdminSignIn {

    private JLabel uname, upass,title,pic;
    private JTextField tname;
    private JPasswordField tpass;
    private JButton signin, back;
    private User u1, u2;
    private User users[];
    private Container c;

    public AdminSignIn() {

        u1 = new User("ayesha", "1234");
        u2 = new User("Faisal", "5678");
        users = new User[4];
        users[0] = u1;
        users[1] = u2;

        ImageIcon framelogo     = new ImageIcon("icons/Screenshot 2023-10-07 163157.png");
        setIconImage(framelogo.getImage());


        ImageIcon icon =new ImageIcon("icons/admin.png");
        pic=new JLabel(icon);
        pic.setBounds(50,50,400,400);
        this.add(pic);




        setTitle("Beyond Basics");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);


        title = new JLabel("Admin Sign In");
        title.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setForeground(new Color(0,0,139));
        title.setOpaque(true);
        title.setLocation(600, 50);
        c.add(title);



        uname = new JLabel("Admin Username");
        uname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        uname.setSize(200, 20);
        uname.setLocation(600, 120);
        c.add(uname);

        tname = new JTextField();
        tname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tname.setSize(200, 40);
        tname.setLocation(600, 150);
        c.add(tname);

        upass = new JLabel("Admin Password");
        upass.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        upass.setSize(200, 20);
        upass.setLocation(600, 210);
        c.add(upass);

        tpass = new JPasswordField();
        tpass.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tpass.setSize(200, 40);
        tpass.setLocation(600, 240);
        c.add(tpass);

        signin = new JButton("Admin In");
        signin.setBackground(Color.ORANGE);
        signin.setOpaque(true);
        signin.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        signin.setSize(150, 50);
        signin.setLocation(625, 290);
        signin.addActionListener(this);
        c.add(signin);

        back = new JButton("Back");
        back.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        back.setSize(100, 40);
        back.setLocation(760, 450);
        back.setBackground(new Color(130, 182, 217));
        back.setOpaque(true);
        back.addActionListener(this);
        c.add(back);



        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signin) {
            String user = tname.getText();
            String pass = tpass.getText();

            int flag = 0;

            if (user.isEmpty() == false && pass.isEmpty() == false) {
                for (int i = 0; i < users.length; i++) {
                    if (users[i] != null) {
                        if (user.equals(users[i].getname()) && pass.equals(users[i].getPassword())) {
                            flag = 1;
                            break;
                            //new Dashboard();
                            //frame.setVisible(false);
                        }
                    }
                }
                if (flag == 1) {
                    User x= this.searchUser(user);
                    new AdminHome(x);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or password!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fill up each field.");
            }
        } else if (e.getSource() == back) {
            new CustomerSignIn();
            setVisible(false);
        }

    }

    public User searchUser(String user)
    {
        User a = null;

        for(int i=0; i<users.length; i++)
        {
            if(users[i]!=null)
            {
                if(users[i].getname().equals(user))
                {
                    a = users[i];
                    break;
                }
            }
        }
        return a;
    }

}
