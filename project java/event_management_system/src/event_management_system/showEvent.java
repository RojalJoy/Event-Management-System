package event_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class showEvent extends JFrame {
    private JPanel contentPane;
    private JTextField idTextField;

    showEvent() {
        setTitle("Event Details");
        setBounds(50, 50, 1000, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        // Panel for displaying events
        JPanel eventsPanel = new JPanel();
        eventsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        contentPane.add(eventsPanel, BorderLayout.CENTER);

        try {
            conn c = new conn();
            String query = "SELECT * FROM event";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                String type = rs.getString("type");
                String venue = rs.getString("venue");
                String caterer = rs.getString("caterer");
                String photographer = rs.getString("photographer");
                String date = rs.getString("date");
                String username = rs.getString("username");
                int eventId = rs.getInt("id");

                // Create a block for each event
                JPanel eventPanel = createEventPanel(type, venue, caterer, photographer, date, username, eventId);
                eventsPanel.add(eventPanel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Panel for ID input and delete button
        JPanel deletePanel = new JPanel();
        deletePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel idLabel = new JLabel("Enter ID to Delete: ");
        idTextField = new JTextField(10);
        
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEvent();
            }
        });

        deletePanel.add(idLabel);
        deletePanel.add(idTextField);
        deletePanel.add(deleteButton);

        // Add Back button
        JButton backButton = new JButton("Back");
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        contentPane.add(deletePanel, BorderLayout.SOUTH);
        contentPane.add(backButton, BorderLayout.NORTH);

        setVisible(true);
    }

    private JPanel createEventPanel(String type, String venue, String caterer, String photographer, String date, String username, int eventId) {
        JPanel eventPanel = new JPanel();
        eventPanel.setLayout(new BoxLayout(eventPanel, BoxLayout.Y_AXIS));

        JLabel typeLabel = new JLabel("Type: " + type);
        JLabel venueLabel = new JLabel("Venue: " + venue);
        JLabel catererLabel = new JLabel("Caterer: " + caterer);
        JLabel photographerLabel = new JLabel("Photographer: " + photographer);
        JLabel dateLabel = new JLabel("Date: " + date);
        JLabel usernameLabel = new JLabel("Username: " + username);
        JLabel eventIdLabel = new JLabel("Event ID: " + eventId);

        eventPanel.add(typeLabel);
        eventPanel.add(venueLabel);
        eventPanel.add(catererLabel);
        eventPanel.add(photographerLabel);
        eventPanel.add(dateLabel);
        eventPanel.add(usernameLabel);
        eventPanel.add(eventIdLabel);

        eventPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        eventPanel.setPreferredSize(new Dimension(300, 150));

        return eventPanel;
    }

    private void deleteEvent() {
        try {
            int idToDelete = Integer.parseInt(idTextField.getText());
            conn c = new conn();
            String query = "DELETE FROM event WHERE id = " + idToDelete;
            int rowsAffected = c.s.executeUpdate(query);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Event with ID " + idToDelete + " deleted successfully.");
                dispose();
                new showEvent(); // Refresh the display after deletion
            } else {
                JOptionPane.showMessageDialog(this, "Event with ID " + idToDelete + " not found.");
            }

        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID input. Please enter a valid numeric ID.");
        }
    }

    public static void main(String[] args) {
        new showEvent();
    }
}
