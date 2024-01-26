
package event_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard2 extends JFrame {
    Dashboard2(){
        setSize(1000,700);

        
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
        JMenu jm1 = new JMenu("EVENTS");
        jm1.setForeground(Color.RED);
	menuBar.add(jm1);

        
        JMenuItem a1 = new JMenuItem("Book an event");
	jm1.add(a1);
        a1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                setVisible(false);
                    new addevent().setVisible(true);
                
                
                }catch(Exception e ){}
            }
        });
            
        JMenuItem a2 = new JMenuItem("Caterers");
        a2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                try {
                    new viewdetails("catering").setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        );
	jm1.add(a2);
        
        
                JMenuItem b2 = new JMenuItem("Back");
	b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    setVisible(false);
                    new Event_Management_System().setVisible(true);
                
                
                }catch(Exception e ){}
                
    }
        }
        );
	
	jm1.add(b2);
        
    JMenu eventManagementMenu = new JMenu("SERVICES");
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
                new viewdetails("catering").setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
        
        

        setLayout(null);
        ImageIcon background = new ImageIcon("event_management_system/src/event_management_system/Dashboard.jpg");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 1000, 700);
        add(backgroundLabel);
        
        setVisible(true);
        getContentPane().setPreferredSize(new Dimension(100, 100));
        
}
    public static void main(String args[]){
        Dashboard2 d = new Dashboard2();
        
    }
}
