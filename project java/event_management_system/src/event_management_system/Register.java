package event_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Register extends JFrame {
    JLabel l[] = new JLabel[]{new JLabel("ID"), new JLabel("Username"), new JLabel("Phone Number"), new JLabel("Email"), new JLabel("Password")};
    JTextField t[] = new JTextField[4];
    JPasswordField p1;
    JButton b1;
    JLabel background;

    Register() {
  
        ImageIcon backgroundImage = new ImageIcon("event_management_system/src/event_management_system/Register.jpeg");
        background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 1000,700);
        add(background);

        int j = 0;
        for (int i = 0; i < 5; i++) {
            l[i].setBounds(300, 200 + j, 200, 30);
            background.add(l[i]);
            j += 50;
            l[i].setFont(new Font("Arial", Font.BOLD, 14 ));
        }

        j = 0;
        for (int i = 0; i < 5; i++) {
            if (i == 4) {
                p1 = new JPasswordField();
                p1.setBounds(450, 200 + j, 150, 30);
                background.add(p1);
            } else {
                t[i] = new JTextField();
                t[i].setBounds(450, 200 + j, 150, 30);
                background.add(t[i]);
                j += 50;
            }
        }

        b1 = new JButton("Register");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(320, 450, 100, 30);
        background.add(b1);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                conn c = new conn();
                String q = null;
                try {
                    String x = "customer";
                    q = "insert into user values(" + t[0].getText() + ", '" + t[1].getText() + "', "
                            + t[2].getText() + ", '" + t[3].getText() + "','" + x + "','" + p1.getText() + "')";
                    System.out.print(q);
                    setVisible(false);

                    c.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                    setVisible(false);
                    new Register();

                } catch (SQLException ex) {
                    Logger.getLogger(Venue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(470, 450, 100, 30);
        background.add(b2);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    setVisible(false);
                    new Event_Management_System().setVisible(true);

                } catch (Exception e) {
                }
            }
        });

        setLayout(null);
        setBounds(50, 50, 1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        Register r = new Register();
    }
}
