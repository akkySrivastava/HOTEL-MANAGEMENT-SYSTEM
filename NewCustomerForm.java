/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author akky
 */
public class NewCustomerForm extends JFrame implements ActionListener {
    JLabel l,label,l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JComboBox c,c1;
    JTextField t1,t2,t3,t4,t5;
    JRadioButton rb1,rb2;
    JButton b1,b2;
    Font f=new Font("Serif",Font.BOLD,18);
    Font f1=new Font("monospaced",Font.BOLD,15);
    NewCustomerForm()
    {
        getContentPane().setBackground(Color.white);
        setLocation(400,200);
        setSize(800,500);
        setLayout(null);
       
        label=new JLabel("ADD CUSTOMER");
        label.setFont(new Font("Algerian",Font.BOLD,32));
        label.setBounds(490,3,300,30);
        label.setForeground(Color.red);
        add(label);
        
        ImageIcon I=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/unnamed.png"));
        Image i=I.getImage().getScaledInstance(420,350,Image.SCALE_DEFAULT);
        ImageIcon i1=new ImageIcon(i);
        l=new JLabel(i1);
        l.setBounds(410,100,420,350);
        add(l);
        
        l1=new JLabel("ID");
        l1.setBounds(30,30,180,30);
        l1.setFont(f);
        add(l1);
        
        c=new JComboBox();
        c.addItem("Passport");
        c.addItem("Aadhar Card");
        c.addItem("Driving License");
        c.addItem("PAN");
        c.addItem("Voter I-Card");
        c.addItem("Other");
        c.setBounds(220,30,180,30);
        c.setBackground(Color.white);
        c.setBackground(Color.white);
        c.setFont(f1);
        add(c);
        
        
        l2=new JLabel("Number");
        l2.setBounds(30,70,180,30);
        l2.setFont(f);
        add(l2);
        
        t1=new JTextField();
        t1.setBounds(220,70,180,30);
        t1.setFont(f1);
        add(t1);
        
        l3=new JLabel("Name");
        l3.setBounds(30,110,180,30);
        l3.setFont(f);
        add(l3);
        
        t2=new JTextField();
        t2.setBounds(220,110,180,30);
        t2.setFont(f1);
        add(t2);
        
        l4=new JLabel("Gender");
        l4.setBounds(30,150,180,30);
        l4.setFont(f);
        add(l4);
        
        rb1=new JRadioButton("Male");
        rb1.setFont(f1);
        rb1.setBounds(220,150,80,30);
        rb1.setBackground(Color.white);
        add(rb1);
        
        
        
        rb2=new JRadioButton("Female");
        rb2.setFont(f1);
        rb2.setBackground(Color.white);
        rb2.setBounds(320,150,80,30);
        add(rb2);
        
        l5=new JLabel("Country");
        l5.setBounds(30,190,180,30);
        l5.setFont(f);
        add(l5);
        
        t3=new JTextField();
        t3.setBounds(220,190,180,30);
        t3.setFont(f1);
        add(t3);
        
        l6=new JLabel("Allocated Room No.");
        l6.setBounds(30,230,180,30);
        l6.setFont(f);
        add(l6);
        
        c1=new JComboBox();
        c1.setBounds(220,230,180,30);
        c1.setBackground(Color.white);
        c1.setFont(f1);
        
        try{
                    connection conn=new connection();
                    ResultSet rs=conn.s.executeQuery("select room_no, availability from roomdetails where availability='Available' and clean_status='Cleaned'");
                    while(rs.next())
                    {
                        c1.addItem(rs.getInt("room_no"));
                    }
                    
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        add(c1);
        
        l7=new JLabel("Checked-In At");
        l7.setBounds(30,270,180,30);
        l7.setFont(f);
        add(l7);
        
        t4=new JTextField();
        t4.setBounds(220,270,180,30);
        t4.setText(new java.util.Date().toString());
        t4.setEditable(false);
        t4.setFont(f1);
        add(t4);
        
        l8=new JLabel("Deposit");
        l8.setBounds(30,310,180,30);
        l8.setFont(f);
        add(l8);
        
        t5=new JTextField();
        t5.setBounds(220,310,180,30);
        t5.setFont(f1);
        add(t5);
        
        b1=new JButton("ADD");
        b1.setBounds(30,375,180,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setFont(f);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(220,375,180,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setFont(f);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String s=c.getSelectedItem().toString();
            String s1=t1.getText();
            String s2=t2.getText();
            String s3;
            if(rb1.isSelected())
            {
                s3=rb1.getText();
            }
            else
            {
                s3=rb2.getText();
            }
            String s4=t3.getText();
            int s5=Integer.parseInt(c1.getSelectedItem().toString());
            String s6=t4.getText();
            Float s7=Float.parseFloat(t5.getText());
            try{
                    connection css=new connection();
                    css.s.executeUpdate("insert into customerdetails values('"+s+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')");
                    css.s.executeUpdate("update roomdetails set availability='Occupied' where room_no='"+s5+"'");
                    JOptionPane.showMessageDialog(null,"Customer Added Successfully\nAllocated Room No. "+c1.getSelectedItem()+"\nProvide Key to the Customer");
                    this.setVisible(false);
                    new AllCustomerInfo().setVisible(true);
            }
            catch(SQLException e)
            {
                
                e.getMessage();
            }
        }
        if(ae.getSource()==b2)
        {
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new NewCustomerForm().setVisible(true);
    }
}
