
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
        setSize(1000,1000);
        ImageIcon i1 = new ImageIcon("event_management_system/src/event_management_system/image food.jpg");

	JLabel NewLabel = new JLabel(i1);

        add(NewLabel);
        
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
        JMenu jm1 = new JMenu("Reception");
        jm1.setForeground(Color.RED);
	menuBar.add(jm1);

        
        JMenuItem a1 = new JMenuItem("Add an event");
	jm1.add(a1);
        a1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                setVisible(false);
                    new addevent().setVisible(true);
                
                
                }catch(Exception e ){}
            }
        });
            
        JMenuItem a2 = new JMenuItem("Choose your menu");
	jm1.add(a2);
        JMenuItem a3 = new JMenuItem("Update Profile details");
	jm1.add(a3);
        JMenuItem a4 = new JMenuItem("Edit an event");
	jm1.add(a4);
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
        
        
        
        
   setLayout(null);
        
        
        setVisible(true);
        getContentPane().setPreferredSize(new Dimension(100, 100));
        
}
    public static void main(String args[]){
        Dashboard2 d = new Dashboard2();
        
    }
}