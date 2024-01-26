package event_management_system;

import javax.swing.*;
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

public class Photographer extends JFrame {
    private JPanel contentPane;
    private JLabel backgroundLabel;

    public Photographer(String selectedName) {
        setTitle("Photographer Details");
        setBounds(50, 50, 800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

      
            
        
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        

        conn c = new conn();
        JScrollPane sb = new JScrollPane();

        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 450, 150, 30);

        
        String q = "select * from photographer where name ='" + selectedName + "'";
        try {
            ResultSet rs = c.s.executeQuery(q);
            while (rs.next()) {
                int photographerId = rs.getInt("id");
                String photographerName = rs.getString("name");
                String contactId = rs.getString("contact_id");
                double price = rs.getDouble("price");
                int duration = rs.getInt("duration");

                // Create a block for each photographer
                JPanel photographerPanel = createPhotographerPanel(photographerId, photographerName, contactId, price, duration);
                contentPane.add(photographerPanel);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Photographer.class.getName()).log(Level.SEVERE, null, ex);
        }

   

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new viewdetails("photographer");
                dispose();
            }
        });
        contentPane.add(backButton);
        ImageIcon background = new ImageIcon("event_management_system/src/event_management_system/Photographer.jpg");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1000, 700);
        contentPane.add(backgroundLabel); 
        setSize(800, 600);
        setVisible(true);
    }

    private JPanel createPhotographerPanel(int photographerId, String photographerName, String contactId, double price, int duration) {
        JPanel photographerPanel = new JPanel();
        photographerPanel.setLayout(new BoxLayout(photographerPanel, BoxLayout.Y_AXIS));

        JLabel idLabel = new JLabel("Photographer ID: " + photographerId);
        JLabel nameLabel = new JLabel("Photographer Name: " + photographerName);
        JLabel contactLabel = new JLabel("Contact ID: " + contactId);
        JLabel priceLabel = new JLabel("Price: $" + price);
        JLabel durationLabel = new JLabel("Duration: " + duration + " hours");

        photographerPanel.add(idLabel);
        photographerPanel.add(nameLabel);
        photographerPanel.add(contactLabel);
        photographerPanel.add(priceLabel);
        photographerPanel.add(durationLabel);

        photographerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        photographerPanel.setPreferredSize(new Dimension(200, 100));

        return photographerPanel;
    }

    public static void main(String[] args) {
        new Photographer(""); 
    }
}
