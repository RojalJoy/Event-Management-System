package event_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame {

    Dashboard() {
        super("Event MANAGEMENT SYSTEM");
        setBounds(50,50,1000, 700);

        ImageIcon i1 = new ImageIcon("event_management_system/src/event_management_system/image food.jpg");

        JLabel backgroundLabel = new JLabel(i1);
        backgroundLabel.setBounds(0, 0, 1000, 700);
        add(backgroundLabel);

        JLabel eventManagementLabel = new JLabel("Event Management System.");
        eventManagementLabel.setForeground(Color.WHITE);
        eventManagementLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        eventManagementLabel.setBounds(200, 60, 500, 50);
        backgroundLabel.add(eventManagementLabel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu receptionMenu = new JMenu("Reception");
        receptionMenu.setForeground(Color.RED);
        menuBar.add(receptionMenu);

        JMenuItem adminMenuItem = new JMenuItem("Admin");
        receptionMenu.add(adminMenuItem);

        JMenuItem addVenueMenuItem = new JMenuItem("Add Venue");
        receptionMenu.add(addVenueMenuItem);
        addVenueMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String s[] = new String[]{"id", "name", "image_url", "price", "capacity", "facilities", "description"};
                    setVisible(false);
                    new addtodb(s, "venue").setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem addPhotographerMenuItem = new JMenuItem("Add Photographer");
        receptionMenu.add(addPhotographerMenuItem);
        addPhotographerMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String s[] = new String[]{"id", "name", "contact_id", "price", "duration"};
                    setVisible(false);
                    new addtodb(s, "photographer").setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem addCatererMenuItem = new JMenuItem("Add Caterer");
        receptionMenu.add(addCatererMenuItem);
        addCatererMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String s[] = new String[]{"id", "Caterer", "Menu", "Budget/Plate"};
                    setVisible(false);
                    new addtodb(s, "caterer").setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem backMenuItem = new JMenuItem("Back");
        backMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    setVisible(false);
                    new Event_Management_System().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        receptionMenu.add(backMenuItem);

        JMenu eventManagementMenu = new JMenu("Event MANAGEMENT");
        eventManagementMenu.setForeground(Color.BLUE);
        menuBar.add(eventManagementMenu);

        JMenuItem venueMenuItem = new JMenuItem("Venue");
        eventManagementMenu.add(venueMenuItem);
        venueMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new viewdetails("venue").setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem photographerMenuItem = new JMenuItem("Photographer");
        eventManagementMenu.add(photographerMenuItem);
        photographerMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new viewdetails("photographer").setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem catererMenuItem = new JMenuItem("Caterer");
        eventManagementMenu.add(catererMenuItem);
        catererMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new viewdetails("caterer").setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        Dashboard d = new Dashboard();
    }
}
