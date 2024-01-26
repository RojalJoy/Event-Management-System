package event_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class Login1 extends JFrame {
    JLabel background; // JLabel for the background image
    JLabel l1, l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1, b2;
    String type;

    Login1(String s1) {
        this.type = s1;

        ImageIcon backgroundImage = new ImageIcon("event_management_system/src/event_management_system/login.jpg"); 
        background = new JLabel(backgroundImage);
        background.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        add(background);

        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        l1.setBounds(40, 20, 100, 30);
        l2.setBounds(40, 70, 100, 30);
        background.add(l1);
        background.add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 20, 150, 30);
        background.add(t1);

        p1 = new JPasswordField();
        p1.setBounds(150, 70, 150, 30);
        background.add(p1);

        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40, 120, 100, 30);
        background.add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    conn c1 = new conn();
                    String u = t1.getText();
                    String v = new String(p1.getPassword());
                    ResultSet rs = null;

                    if (type.equals("admin")) {
                        String q = "select * from user where name='" + u + "' and password='" + v + "' and type ='admin'";
                        rs = c1.s.executeQuery(q);
                        System.out.print(q);
                    } else if (type.equals("customer")) {
                        String q = "select * from user where name='" + u + "' and password='" + v + "' and type ='customer'";
                        rs = c1.s.executeQuery(q);
                        System.out.print(q);
                    }

                    if (rs.next()) {
                        if (type.equals("admin"))
                            new Dashboard().setVisible(true);
                        else if (type.equals("customer"))
                            new Dashboard2().setVisible(true);

                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid login");
                        new Event_Management_System().setVisible(true);
                        setVisible(false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(150, 120, 100, 30);
        background.add(b2);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Event_Management_System();
            }
        });

        setLayout(null);
        setBounds(50, 50, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        setVisible(true);

        if (type.equals("customer")) {
            Customer();
        }
    }

    void Customer() {
        JButton b3 = new JButton("Register");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(260, 120, 100, 30);
        background.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Register().setVisible(true);
            }
        });
    }

    public static void main(String args[]) {
        Login1 l = new Login1("customer");
    }
}
