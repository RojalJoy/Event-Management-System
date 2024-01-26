package event_management_system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class viewdetails extends JFrame {
    private JPanel contentPane;

    viewdetails(String tableName) {
        setBounds(450, 200, 1000, 450);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        conn c = new conn();
        try {
            String query = "";
            switch (tableName) {
                case "venue":
                    query = "SELECT Name FROM venue LIMIT 100";
                    break;
                case "photographer":
                    query = "SELECT name FROM photographer LIMIT 100";
                    break;
                case "catering":
                    query = "SELECT caterer FROM catering LIMIT 100";
                    break;
                default:
                    break;
            }

            ArrayList<String> detailsList = new ArrayList<>();
            ResultSet rs = c.s.executeQuery(query);
            int j = 0;

            while (rs.next()) {
                String name = rs.getString(1);
                System.out.println(name);

                JButton button = new JButton(name);
                button.setBackground(Color.BLACK);
                button.setForeground(Color.WHITE);
                button.setBounds(10, 10 + j, 100, 30);
                contentPane.add(button);

                final String selectedName = name;
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            setVisible(false);
                            switch (tableName) {
                                case "venue":
                                    Venue venue = new Venue(selectedName);
                                    venue.setVisible(true);
                                    break;
                                case "photographer":

                                Photographer photographer = new Photographer(selectedName);
                                    photographer.setVisible(true);
                                    break;
                                case "catering":

                                ViewCaterer caterer = new ViewCaterer(selectedName);
                                    caterer.setVisible(true);
                                    break;
                                default:
                                    break;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                j = j + 40;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Venue.class.getName()).log(Level.SEVERE, null, ex);
        }

        contentPane.setBackground(Color.WHITE);
        setVisible(true);
        setSize(436, 900); 
    }

    public static void main(String args[]) {
        viewdetails v = new viewdetails("");
    }
}
