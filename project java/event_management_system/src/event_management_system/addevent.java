package event_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class addevent extends JFrame {
    Choice c1;
    JButton b1, b2;
    private JPanel contentPane;
    private JTextField t1;
    private JComboBox comboBox;
    ArrayList<JComboBox> t = new ArrayList<JComboBox>();
    String venue, caterer, photographer, type;

    addevent() {

        conn c = new conn();
        setBounds(50,50,1000, 700);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblReserveRoomNumber = new JLabel("Book The Event :");
        lblReserveRoomNumber.setBounds(50, 5, 140, 50);
        contentPane.add(lblReserveRoomNumber);

        c1 = new Choice();

        ArrayList<ArrayList<String>> lab = new ArrayList<ArrayList<String>>();
        String[] sw = new String[]{"Event Type", "Venue", "Photographer", "Caterer", "Date"};

        ArrayList<String> aList = new ArrayList<String>();
        aList.add("Marriage");
        aList.add("Birthday");
        aList.add("Anniversary");
        aList.add("Break-up Party");
        lab.add(aList);

        String v1 = "SELECT Name FROM venue LIMIT 100";
        String v2 = "SELECT name FROM photographer LIMIT 100";
        String v3 = "SELECT caterer FROM catering LIMIT 100";
        String[] label1 = new String[]{v1, v2, v3};

        for (int i = 0; i < 3; i++) {
            try {
                ArrayList<String> ob = new ArrayList<String>();
                ResultSet rs = c.s.executeQuery(label1[i]);
                while (rs.next()) {
                    String name = rs.getString(1);
                    ob.add(name);
                }
                lab.add(ob);

            } catch (SQLException ex) {
                Logger.getLogger(Venue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        int j = 0;
        Iterator itr = lab.iterator();
        for (int i = 0; i <= 4; i++) {
            JLabel l1 = new JLabel(sw[i]);
            l1.setForeground(new Color(25, 25, 112));
            l1.setFont(new Font("Tahoma", Font.BOLD, 14));
            l1.setBounds(64, 70 + j, 102, 22);
            contentPane.add(l1);

            if (i == 4) {
                t1 = new JTextField();
                t1.setBounds(170, 70 + j, 156, 20);
                contentPane.add(t1);
            } else {
                ArrayList<String> r = new ArrayList<String>();
                r = (ArrayList<String>) itr.next();
                comboBox = new JComboBox(r.toArray());
                comboBox.setBounds(170, 70 + j, 154, 20);
                comboBox.setBackground(Color.BLACK);
                comboBox.setForeground(Color.WHITE);
                contentPane.add(comboBox);
            }
            j += 40;
            t.add(comboBox);
        }

        b1 = new JButton("Add");
        b1.setBounds(64, 70 + j, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    setVisible(false);
                    type = (String) t.get(0).getSelectedItem();
                    venue = (String) t.get(1).getSelectedItem();
                    photographer = (String) t.get(2).getSelectedItem();
                    caterer = (String) t.get(3).getSelectedItem();
                    String date = t1.getText();

                    String str = "INSERT INTO event values( '" + type + "', '" + venue + "', '" + caterer + "','" + photographer + "','" + date + "')";
                    System.out.print(str);
                    conn c = new conn();
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Successfully Added");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error while adding");
                }
            }
        });

        b2 = new JButton("Back");
        b2.setBounds(198, 70 + j, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    setVisible(false);
                    new Dashboard2().setVisible(true);
                } catch (Exception e) {
                }
            }
        });

        contentPane.setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String args[]) {
        addevent w = new addevent();
    }
}
