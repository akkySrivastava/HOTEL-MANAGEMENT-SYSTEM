/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author akky
 */
public class AddRoom extends JFrame implements ActionListener{
    JLabel l,label,l1,l2,l3,l4,l5;
    JTextField t,t1;
    JComboBox c,c1,c2;
    JButton b1,b2;
    Font font=new Font("Serif",Font.BOLD,18);
    Font f=new Font("monospaced",Font.BOLD,15);
    
    AddRoom()
    {
        setLayout(null);
        setLocation(400,200);
        getContentPane().setBackground(Color.white);
        setSize(800,350);
        
        ImageIcon I=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/room.jpg"));
        Image i=I.getImage().getScaledInstance(410,250,Image.SCALE_DEFAULT);
        ImageIcon i1=new ImageIcon(i);
        l=new JLabel(i1);
        l.setBounds(415,30,385,250);
        
        label=new JLabel("ADD ROOM");
        label.setBounds(520,10,180,30);
        label.setFont(new Font("Algerian",Font.BOLD,32));
        label.setForeground(Color.red);
        add(label);
        
        add(l);
        
        l1=new JLabel("Room No.");
        l1.setBounds(30,30,180,30);
        l1.setFont(font);
        add(l1);
        
        t=new JTextField();
        t.setBounds(220,30,180,30);
        t.setFont(f);
        add(t);
        
        l2=new JLabel("Avalilability");
        l2.setBounds(30,70,180,30);
        l2.setFont(font);
        add(l2);
        
        c=new JComboBox();
        c.addItem("Available");
        c.addItem("Occupied");
        c.setFont(f);
        c.setBounds(220,70,180,30);
        add(c);
        
        l3=new JLabel("Cleaning Status");
        l3.setBounds(30,110,180,30);
        l3.setFont(font);
        add(l3);
        
        c1=new JComboBox();
        c1.addItem("Cleaned");
        c1.addItem("Dirty");
        c1.setFont(f);
        c1.setBounds(220,110,180,30);
        add(c1);
        
        l4=new JLabel("Price");
        l4.setBounds(30,150,180,30);
        l4.setFont(font);
        add(l4);
        
        t1=new JTextField();
        t1.setBounds(220,150,180,30);
        t1.setFont(f);
        add(t1);
        
        l5=new JLabel("Bed Type");
        l5.setBounds(30,190,180,30);
        l5.setFont(font);
        add(l5);
        
        c2=new JComboBox();
        c2.addItem("Single Bed");
        c2.addItem("Double Bed");
        c2.setFont(f);
        c2.setBounds(220,190,180,30);
        add(c2);
        
        b1=new JButton("ADD");
        b1.setForeground(Color.white);
        b1.setBackground(Color.BLACK);
        b1.setFont(font);
        b1.setBounds(30,250,180,30);
        add(b1);
        
        b2=new JButton("BACK");
        b2.setForeground(Color.white);
        b2.setBackground(Color.BLACK);
        b2.setFont(font);
        b2.setBounds(230,250,180,30);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            int s=Integer.parseInt(t.getText());
            String s1=c.getSelectedItem().toString();
            String s2=c1.getSelectedItem().toString();
            float s3=Float.parseFloat(t1.getText());
            String s4=c2.getSelectedItem().toString();
            try{
                    connection conn=new connection();
                    conn.s.executeUpdate("insert into roomdetails values('"+s+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"')");
                    JOptionPane.showMessageDialog(null,"Room Added Successfully");
                    this.setVisible(false);
            }
            catch(Exception e)
            {
                    e.getMessage();
            }
            
        }
        if(ae.getSource()==b2)
        {
            this.setVisible(false);
            //new welcome().setVisible(true);
        }
    }
    public static void main(String[] args){
        new AddRoom().setVisible(true);
    }
    
}
