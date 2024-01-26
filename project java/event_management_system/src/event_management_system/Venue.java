package event_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Venue extends JFrame {
    JLabel l1[] = new JLabel[]{new JLabel("Name"), new JLabel("price"), new JLabel("capacity"), new JLabel("facilities"), new JLabel("description")};
    private String name, image_url, facilities, description, capacity, price;
    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2;
    Choice c1;

    private void is_available() {
        Date_Time dt = new Date_Time();
        String current_date = dt.getdate();
        System.out.print(current_date);
    }

    Venue(String name) {

        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Venues");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(800, 600); // Adjusted size for better visibility
        getContentPane().setLayout(null);

        conn c = new conn();
        JScrollPane sb = new JScrollPane();

        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 450, 150, 30);
      
        String q = "select * from venue where Name ='" + name + "'";
        try {
            ResultSet rs = c.s.executeQuery(q);
            while (rs.next()) {
                name = rs.getString(2);
                image_url = rs.getString(3);
                capacity = rs.getString(4);
                price = rs.getString(5);
                facilities = rs.getString(6);
                description = rs.getString(7);

                JLabel l2[] = new JLabel[]{new JLabel(name), new JLabel(price), new JLabel(capacity), new JLabel(facilities), new JLabel(description)};

                int j = 0;
                for (int i = 0; i < 5; i++) {
                    if (i > 2) {
                        j += 50;
                        l1[i].setBounds(40, 20 + j, 100, 30);
                    } else {
                        l1[i].setBounds(40, 20 + j, 100, 30);
                    }
                    add(l1[i]);

                    j += 50;
                }
                j = 0;
                for (int i = 0; i < 5; i++) {
                    if (i > 2) {
                        j += 50;
                        l2[i].setBounds(150, 20 + j, 500, 30);
                    } else {
                        l2[i].setBounds(150, 20 + j, 500, 30);
                    }
                    add(l2[i]);
                    j += 50;
                }

                try {
                    URL url = new URL(image_url);
                    Image img = ImageIO.read(url);
                    ImageIcon i2 = new ImageIcon(img);
                    Image q1 = i2.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
                    ImageIcon q2 = new ImageIcon(q1);
                    JLabel l3 = new JLabel(q2);
                    l3.setBounds(450, 50, 300, 300);
                    add(l3);
                } catch (IOException ex) {
                    Logger.getLogger(Venue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Venue.class.getName()).log(Level.SEVERE, null, ex);
        }

        add(sb);


        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                new viewdetails("venue"); 
                dispose(); 
            }
        });
        add(backButton);
        setSize(800, 600); // Adjusted size for better visibility
        setVisible(true);
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    void getVenue(int id) {
        conn c = new conn();
        String q = "select * from venue where id ='" + id + "'";
        try {
            ResultSet rs = c.s.executeQuery(q);
            rs.next();
            name = rs.getString(2);
            image_url = rs.getString(3);
            capacity = rs.getString(4);
            price = rs.getString(5);
            facilities = rs.getString(6);
            description = rs.getString(7);

        } catch (SQLException ex) {
            Logger.getLogger(Venue.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void addVenue(String name, String image_url, String capacity, String price, String facilities, String description) {
        conn c = new conn();
        String q = "insert into venue values('" + name + "', '" + image_url + "', " + capacity + ", " + price + ", '" + facilities + "', '" + description + "' )";
        System.out.print(q);

        try {
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Room Successfully Added");
            this.setVisible(false);

        } catch (SQLException ex) {
            Logger.getLogger(Venue.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String args[]) {
        Venue v = new Venue("");
    }
}
