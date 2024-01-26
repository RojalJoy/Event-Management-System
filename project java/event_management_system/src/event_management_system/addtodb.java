package event_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class addtodb extends JFrame {
    private final JPanel contentPane;
    private final JButton b1, b2;
    private final ArrayList<String> v = new ArrayList<>();
    private final ArrayList<JTextField> t = new ArrayList<>();

    addtodb(String s[], String a) {
        setBounds(50,50,1000, 700);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelType = new JLabel(a);
        labelType.setFont(new Font("Tahoma", Font.BOLD, 18));
        labelType.setBounds(150, 10, 120, 22);
        contentPane.add(labelType);

        int j = 0;

        for (int i = 0; i < s.length; i++) {
            JLabel label = new JLabel(s[i]);
            label.setForeground(new Color(0,0,0));
            label.setFont(new Font("Tahoma", Font.BOLD, 14));
            label.setBounds(300, 70 + j, 102, 22);
            contentPane.add(label);

            JTextField textField = new JTextField();
            textField.setBounds(430, 70 + j, 156, 20);
            contentPane.add(textField);
            j = j + 40;
            t.add(textField);
        }

        b1 = new JButton("Add");
        b1.setBounds(300, 70 + j, 100, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String q = null;
                for (int i = 0; i < s.length; i++) {
                    v.add(t.get(i).getText());
                }
                if (!isValidPhoneNumber(v.get(2))) {
                    JOptionPane.showMessageDialog(null, "Invalid phone number format");
                    reload();
                    return; // Exit the method if phone number is invalid
                }

                if ("venue".equals(a)) {
                    q = "INSERT INTO venue VALUES(" + v.get(0) + ", '" + v.get(1) + "', '" + v.get(2) + "', " +
                            v.get(3) + ", " + v.get(4) + ", '" + v.get(5) + "','" + v.get(6) + "')";
                } else if ("photographer".equals(a)) {
                    q = "INSERT INTO photographer VALUES(" + v.get(0) + ", '" + v.get(1) + "', " + v.get(2) + ", " +
                            v.get(3) + ", " + v.get(4) + ")";
                } else if ("caterer".equals(a)) {
                    q = "INSERT INTO catering VALUES(" + v.get(0) + ", '" + v.get(1) + "', '" + v.get(2) + "', " +
                            v.get(3) + ")";
                }

                try {
                    conn c = new conn();
                    c.s.executeUpdate(q);
                    
                    JOptionPane.showMessageDialog(null, a + " Successfully Added");
                    new Dashboard().setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                    Logger.getLogger(Venue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        b2 = new JButton("Back");
        b2.setBounds(450, 70 + j, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Dashboard().setVisible(true);
            }
        });

          ImageIcon background = new ImageIcon("event_management_system/src/event_management_system/addtodb.jpg");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1000, 700);
        contentPane.add(backgroundLabel);
        contentPane.setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Assuming a valid phone number is 10 digits
        // Modify the regular expression based on your specific requirements
        String regex = "\\d{10}";
        return phoneNumber.matches(regex);
    }
    private void reload() {
        setVisible(false);
        Dashboard newEvent = new Dashboard();
        newEvent.setVisible(true);
    }

    public static void main(String args[]) {
        //String s[] = new String[]{"id", "name", "image_url", "price", "capacity", "facilities", "description"};
        //new addtodb(s, "");
    }
}
