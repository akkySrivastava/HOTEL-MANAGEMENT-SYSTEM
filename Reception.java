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
public class Reception extends JFrame implements ActionListener {
    JLabel l,l1;
    JButton b,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    Font f=new Font("Monospaced",Font.BOLD,14);
    Reception()
    {
        setTitle("HOTEL MANAGEMENT SYSTEM - RECEPTION PAGE");
        setLocation(300,200);
        setSize(852,480);
        setLayout(null);
        
        ImageIcon I=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/reception.jpg"));
        Image i=I.getImage().getScaledInstance(852,480,Image.SCALE_DEFAULT);
        ImageIcon i1=new ImageIcon(i);
        l=new JLabel(i1);
        l.setBounds(0,0,852,480);
        add(l);
        
        String date=new java.util.Date().toString();
        l1=new JLabel(date);
        l1.setFont(new Font("monospaced",Font.BOLD,15));
        l1.setForeground(Color.BLUE);
        l1.setBounds(575,20,300,30);
        l.add(l1);
        
        b=new JButton("New Customer Form");
        b.setBounds(5,260,180,30);
        b.setFont(f);
        b.setForeground(Color.white);
        b.setBackground(Color.black);
        l.add(b);
        
        b1=new JButton("Room");
        b1.setBounds(5,295,180,30);
        b1.setFont(f);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        l.add(b1);
        
        b2=new JButton("Department");
        b2.setBounds(5,330,180,30);
        b2.setFont(f);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        l.add(b2);
        
        b3=new JButton("All Employee Info");
        b3.setBounds(5,365,180,30);
        b3.setFont(f);
        b3.setForeground(Color.white);
        b3.setBackground(Color.black);
        l.add(b3);
        
        b4=new JButton("All Customer Info");
        b4.setBounds(5,400,180,30);
        b4.setFont(f);
        b4.setForeground(Color.white);
        b4.setBackground(Color.black);
        l.add(b4);
        
        b5=new JButton("Customer Info");
        b5.setBounds(355,260,180,30);
        b5.setFont(f);
        b5.setForeground(Color.white);
        b5.setBackground(Color.black);
        l.add(b5);
        
        b6=new JButton("Manager Info");
        b6.setBounds(355,400,180,30);
        b6.setFont(f);
        b6.setForeground(Color.white);
        b6.setBackground(Color.black);
        l.add(b6);
        
        b7=new JButton("Check Out");
        b7.setBounds(650,260,180,30);
        b7.setFont(f);
        b7.setForeground(Color.white);
        b7.setBackground(Color.black);
        l.add(b7);
        
        b8=new JButton("Update Check Status");
        b8.setBounds(650,295,180,30);
        b8.setFont(new Font("monospaced",Font.BOLD,12));
        b8.setForeground(Color.white);
        b8.setBackground(Color.black);
        l.add(b8);
        
        b9=new JButton("Update Room Status");
        b9.setBounds(650,330,180,30);
        b9.setFont(f);
        b9.setForeground(Color.white);
        b9.setBackground(Color.black);
        l.add(b9);
        
        b10=new JButton("Pick-UP Service");
        b10.setBounds(650,365,180,30);
        b10.setFont(f);
        b10.setForeground(Color.white);
        b10.setBackground(Color.black);
        l.add(b10);
        
        b11=new JButton("Search Room");
        b11.setBounds(650,400,180,30);
        b11.setFont(f);
        b11.setForeground(Color.white);
        b11.setBackground(Color.black);
        l.add(b11);
        
        b12=new JButton("Logout");
        b12.setBounds(650,70,180,30);
        b12.setForeground(Color.RED);
        b12.setFont(f);
        l.add(b12);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b4.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
       
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b)
        {
            new NewCustomerForm().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b1)
        {
            new SearchRoom().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b2)
        {
            new Department().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b3)
        {
            new AllEmployeeInfo().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b4)
        {
            new AllCustomerInfo().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b5)
        {
            new AllCustomerInfo().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b6)
        {
            new ManagerInfo().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b7)
        {
            new AllCustomerInfo().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b8)
        {
            new UpdateCheckStatus().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b9)
        {
            new UpdateRoomStatus().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b10)
        {
            new PickUpService().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b11)
        {
            new SearchRoom().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b12)
        {
            this.setVisible(false);
            JOptionPane.showMessageDialog(null,"Logout Successful "+new java.util.Date().toString());
            new login().setVisible(true);
        }
    }
    public static void main(String [] args){
        try{
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch(Exception e )
        {
            e.getMessage();
        }
        new Reception().setVisible(true);
    }
    
}
