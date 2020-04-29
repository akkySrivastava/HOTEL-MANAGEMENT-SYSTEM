/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author akky
 */
public class welcome extends JFrame implements ActionListener {
    JLabel l,l1;
    JMenuBar mb;
    JMenuItem m1,m2,m3,m4;
    JMenu mn1,mn2;
    welcome()
    {
        setTitle("HOTEL MANAGEMENT SYSTEM Ver 2.0.1");
        setLocation(0,0);
        setSize(1900,890);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ImageIcon I=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
        Image i=I.getImage().getScaledInstance(1900,890,Image.SCALE_DEFAULT);
        ImageIcon I1=new ImageIcon(i);
        l=new JLabel(I1);
        l.setBounds(0,0,1900,890);
        add(l);
        
        l1=new JLabel("THE CROWN INN HOTEL WELCOMES YOU");
        l1.setBounds(500,50,800,30);
        l1.setFont(new Font("Algerian",Font.BOLD,32));
        l1.setForeground(Color.yellow);
        l.add(l1);
        
        mb=new JMenuBar();
        mb.setBackground(Color.lightGray);
       
        
        mn1=new JMenu("HOTEL MANAGEMENT");
        mn1.setFont(new Font("Verdana",Font.BOLD,15));
        mn1.setForeground(Color.black);
        mb.add(mn1);
        
        m1=new JMenuItem("Reception");
        m1.setFont(new Font("Aerial",Font.BOLD | Font.ITALIC, 12));
        mn1.add(m1);
        
        mn2=new JMenu("ADMIN");
        mn2.setFont(new Font("Verdana",Font.BOLD,15));
        mn2.setForeground(Color.RED);
        mb.add(mn2);
        
        m2=new JMenuItem("Add Employee");
        m2.setFont(new Font("Aerial",Font.BOLD | Font.ITALIC, 12));
        mn2.add(m2);
        
        m3=new JMenuItem("Add Room");
        m3.setFont(new Font("Aerial",Font.BOLD | Font.ITALIC, 12));
        mn2.add(m3);
        
        m4=new JMenuItem("Add Driver");
        m4.setFont(new Font("Aerial",Font.BOLD | Font.ITALIC, 12));
        mn2.add(m4);
        
        setJMenuBar(mb);
        
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String msg=ae.getActionCommand();
        switch(msg)
        {
            case "Reception"    :
                new Reception().setVisible(true);
                break;
            case "Add Employee" :
                new AddEmployee().setVisible(true);
                break;
            case "Add Room"     :
                    new AddRoom().setVisible(true);
                    break;
            case "Add Driver"   :
                    new AddDriver().setVisible(true);
                    break;
            default: 
                    break;
                
        }
    }
    public static void main(String[] args){
        new welcome().setVisible(true);
    }
    
}
