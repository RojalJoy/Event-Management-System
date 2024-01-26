package event_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewCaterer extends JFrame {
    private JPanel contentPane;

    public ViewCaterer(String selectedName) {
        initializeUI();
        populateCaterers(selectedName);
        ImageIcon background = new ImageIcon("event_management_system/src/event_management_system/caterer.jpg");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1000, 700);
        contentPane.add(backgroundLabel); // Add the background label at index 0

        setVisible(true);
    }

    private void initializeUI() {
        setTitle("Caterer Details");
        setBounds(50, 50, 1000, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
    }

    private void populateCaterers(String selectedName) {
        try {
            conn c = new conn();
            String query = "SELECT * FROM catering WHERE caterer = '" + selectedName + "'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                int catererId = rs.getInt("id");
                String catererName = rs.getString("caterer");
                String menu = rs.getString("menu");
                double budget = rs.getDouble("budget");

                JPanel catererPanel = createCatererPanel(catererId, catererName, menu, budget);
                contentPane.add(catererPanel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

   

        // Add Back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new viewdetails("catering"); 
                dispose();
            }
        });
        contentPane.add(backButton);

        setVisible(true);
    }

    private JPanel createCatererPanel(int catererId, String catererName, String menu, double budget) {
        JPanel catererPanel = new JPanel();
        catererPanel.setLayout(new BoxLayout(catererPanel, BoxLayout.Y_AXIS));

        JLabel idLabel = new JLabel("Caterer ID: " + catererId);
        JLabel nameLabel = new JLabel("Caterer Name: " + catererName);
        JLabel menuLabel = new JLabel("Menu: " + menu);
        JLabel budgetLabel = new JLabel("Budget: $" + budget);

        catererPanel.add(idLabel);
        catererPanel.add(nameLabel);
        catererPanel.add(menuLabel);
        catererPanel.add(budgetLabel);

        
        catererPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        catererPanel.setPreferredSize(new Dimension(200, 75));

        return catererPanel;
    }

    public static void main(String[] args) {
        new ViewCaterer(""); // Pass the desired name here
    }
}
