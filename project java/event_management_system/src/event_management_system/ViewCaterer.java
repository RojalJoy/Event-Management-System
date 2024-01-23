package event_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewCaterer extends JFrame {
    private JPanel contentPane;

    ViewCaterer() {
        setTitle("Caterer Details");
        setBounds(50, 50, 1000, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        try {
            conn c = new conn();
            String query = "SELECT * FROM catering";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                int catererId = rs.getInt("id");
                String catererName = rs.getString("caterer");
                String menu = rs.getString("menu");
                double budget = rs.getDouble("budget");

                // Create a block for each caterer
                JPanel catererPanel = createCatererPanel(catererId, catererName, menu, budget);
                contentPane.add(catererPanel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add Book Event button
        JButton bookEventButton = new JButton("Book Event");
        bookEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addevent();
                dispose();
            }
        });
        contentPane.add(bookEventButton);

        // Add Back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        new ViewCaterer();
    }
}
