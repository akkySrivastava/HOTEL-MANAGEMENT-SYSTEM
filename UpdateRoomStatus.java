/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author akky
 */
public class UpdateRoomStatus extends JFrame implements ActionListener{
    JLabel l,label,l1,l2,l3,l4,l5;
    JTextField t,t1;
    JTextField c,c1,c2;
    JButton b1,b2,b3;
    Font font=new Font("Serif",Font.BOLD,18);
    Font f=new Font("monospaced",Font.BOLD,15);
    
    UpdateRoomStatus()
    {
        setLayout(null);
        setLocation(400,200);
        getContentPane().setBackground(Color.white);
        setSize(800,350);
        
        ImageIcon I=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/room.jpg"));
        Image i=I.getImage().getScaledInstance(410,250,Image.SCALE_DEFAULT);
        ImageIcon i1=new ImageIcon(i);
        l=new JLabel(i1);
        l.setBounds(420,30,385,250);
        
        label=new JLabel("MODIFY ROOM DETAILS");
        label.setBounds(470,10,310,30);
        label.setFont(new Font("Algerian",Font.BOLD,25));
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
        
        b3=new JButton("",new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/cancel.png")));
        b3.setBounds(402,30,15,30);
        add(b3);
        
        l2=new JLabel("Avalilability");
        l2.setBounds(30,70,180,30);
        l2.setFont(font);
        add(l2);
        
        c=new JTextField();
        c.setFont(f);
        c.setBounds(220,70,180,30);
        add(c);
        
        l3=new JLabel("Cleaning Status");
        l3.setBounds(30,110,180,30);
        l3.setFont(font);
        add(l3);
        
        c1=new JTextField();
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
        
        c2=new JTextField();
        c2.setFont(f);
        c2.setBounds(220,190,180,30);
        add(c2);
        
        b1=new JButton("UPDATE");
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
        b3.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            
            try{
                    connection conn=new connection();
                    conn.s.executeUpdate("update roomdetails set room_no='"+Integer.parseInt(t.getText())+"',availability='"+c.getText()+"',clean_status='"+c1.getText()+"',price='"+Float.parseFloat(t1.getText())+"',bed_type='"+c2.getText()+"' where room_no='"+t.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Room Updated Successfully");
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
            new Reception().setVisible(true);
        }
        if(ae.getSource()==b3)
        {
            connection con=new connection();
            ResultSet res;
            try {
                res = con.s.executeQuery("select * from roomdetails where room_no='"+Integer.parseInt(t.getText())+"'");
                if(res.next()){
                String ssp=String.valueOf(res.getFloat("price"));
                t1.setText(ssp);
                c.setText(res.getString("availability"));
                c1.setText(res.getString("clean_status"));
                c2.setText(res.getString("bed_type"));
                }
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateRoomStatus.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    public static void main(String[] args){
        new UpdateRoomStatus().setVisible(true);
    } 
    
}
