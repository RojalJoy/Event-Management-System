// package event_management_system;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.sql.*;

// public class AddCaterer extends JFrame {
//     private JTextField catererNameField;
//     private JTextField menuField;
//     private JTextField budgetField;
//     private conn connection;

//     public AddCaterer() {
//         setTitle("Catering Data Entry");
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(null);

//         JLabel catererNameLabel = new JLabel("Caterer Name:");
//         catererNameLabel.setBounds(100, 100, 50, 100);
//         catererNameField = new JTextField();
//         catererNameField.setBounds(400, 100, 50, 20);
//         JLabel menuLabel = new JLabel("Menu:");
//         menuLabel.setBounds(100, 150, 50, 100);
//         menuField = new JTextField();
//         menuField.setBounds(400, 150, 50, 20);
//         JLabel budgetLabel = new JLabel("Budget:");
//         budgetLabel.setBounds(100, 200, 50, 100);
//         budgetField = new JTextField();
//         budgetField.setBounds(400, 200, 100, 20);

//         JButton submitButton = new JButton("Submit");
//         submitButton.setBounds(250, 250, 100, 20);
//         submitButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 insertCatererData();
//             }
//         });

//         add(catererNameLabel);
//         add(catererNameField);
//         add(menuLabel);
//         add(menuField);
//         add(budgetLabel);
//         add(budgetField);
//         add(new JLabel()); // Empty label for spacing
//         add(submitButton);

//         pack();
//         setLocationRelativeTo(null);
//         setVisible(true);
//         setBounds(50,50,1000, 700);
//         // Initialize connection object
//         connection = new conn();
//     }

//     private void insertCatererData() {
//         try {
//             String insertQuery = "INSERT INTO catering (caterer, menu, budget) VALUES (?, ?, ?)";

//             try (PreparedStatement preparedStatement = connection.connection.prepareStatement(insertQuery)) {
//                 preparedStatement.setString(1, catererNameField.getText());
//                 preparedStatement.setString(2, menuField.getText());
//                 preparedStatement.setDouble(3, Double.parseDouble(budgetField.getText()));

//                 int rowsAffected = preparedStatement.executeUpdate();

//                 if (rowsAffected > 0) {
//                     JOptionPane.showMessageDialog(this, "Caterer added successfully!");
//                     clearFields();
//                 } else {
//                     JOptionPane.showMessageDialog(this, "Failed to add caterer.");
//                 }
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     private void clearFields() {
//         catererNameField.setText("");
//         menuField.setText("");
//         budgetField.setText("");
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(new Runnable() {
//             @Override
//             public void run() {
//                 new AddCaterer();
//             }
//         });
//     }
// }
