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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author akky
 */
public class UpdateCheckStatus extends JFrame implements ActionListener,ItemListener {
    JLabel l,label,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField c1;
    JComboBox c;
    static int day;
    Float fs,help;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JRadioButton rb1,rb2;
    JButton b1,b2,b3,b4;
    Font f=new Font("Serif",Font.BOLD,18);
    Font f1=new Font("monospaced",Font.BOLD,15);
    UpdateCheckStatus()
    {
        getContentPane().setBackground(Color.white);
        setLocation(400,200);
        setSize(800,600);
        setLayout(null);
       
        label=new JLabel("UPDATE CUSTOMER DETAILS");
        label.setFont(new Font("Algerian",Font.BOLD,22));
        label.setBounds(400,3,400,30);
        label.setForeground(Color.red);
        add(label);
        
        ImageIcon I=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/unnamed.png"));
        Image i=I.getImage().getScaledInstance(420,350,Image.SCALE_DEFAULT);
        ImageIcon i1=new ImageIcon(i);
        l=new JLabel(i1);
        l.setBounds(410,100,420,350);
        add(l);
        
        l1=new JLabel("ID_NO");
        l1.setBounds(30,30,180,30);
        l1.setFont(f);
        add(l1);
        
        c=new JComboBox();
        c.setBounds(220,30,180,30);
        
        c.setBackground(Color.white);
        c.setFont(f1);
        add(c);
        
        try{
                connection cap=new connection();
                ResultSet rs=cap.s.executeQuery("select id_no from customerdetails");
                while(rs.next())
                {
                    c.addItem(rs.getString("id_no"));
                }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        c.addItemListener(this);
        
        l2=new JLabel("ID-Type");
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
        
        c1=new JTextField();
        c1.setBounds(220,230,180,30);
        c1.setBackground(Color.white);
        c1.setFont(f1);
        
        add(c1);
        
        l7=new JLabel("Checked-In At");
        l7.setBounds(30,270,180,30);
        l7.setFont(f);
        add(l7);
        
                
        t4=new JTextField();
        t4.setBounds(220,270,180,30);
        t4.setEditable(false);
        t4.setFont(f1);
        add(t4);
        
        l8=new JLabel("Check-Out At");
        l8.setBounds(30,310,180,30);
        l8.setFont(f);
        add(l8);
        
        t6=new JTextField();
        t6.setBounds(220,310,180,30);
        t6.setEditable(false);
        t6.setFont(f1);
        add(t6);
        
        b3=new JButton("",new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/cancel.png")));
        b3.setBounds(405,310,15,15);
        add(b3);
        
        
        l9=new JLabel("No_of_days_Stayed");
        l9.setFont(f);
        l9.setBounds(30,350,180,30);
        add(l9);
        
        t7=new JTextField();
        t7.setText(String.valueOf(day));
        t7.setBounds(220,350,180,30);
        t7.setFont(f1);
        add(t7);
        
        b4=new JButton("",new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/cancel.png")));
        b4.setBounds(405,350,15,15);
        add(b4);
        
        l8=new JLabel("Deposit");
        l8.setBounds(30,390,180,30);
        l8.setFont(f);
        add(l8);
        
        t5=new JTextField();
        t5.setBounds(220,390,180,30);
        t5.setFont(f1);
        add(t5);
        
        l9=new JLabel("Total Payable Amt");
        l9.setBounds(30,430,180,30);
        l9.setFont(f);
        add(l9);
        
        t8=new JTextField();
        t8.setBounds(220,430,180,30);     
        t8.setFont(f1);
        add(t8);
        
        
        b1=new JButton("Submit");
        b1.setBounds(30,495,180,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setFont(f);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(220,495,180,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setFont(f);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
       
                
    }
    @Override
    public void itemStateChanged(ItemEvent ie)
    {
        try{
                connection conn=new connection();
                ResultSet rs=conn.s.executeQuery("select * from customerdetails where id_no='"+c.getSelectedItem().toString()+"'");
                if(rs.next())
                {
                    help=rs.getFloat("deposit");
                    t1.setText(rs.getString("id"));
                    t2.setText(rs.getString("c_name"));
                    if(rs.getString("gender").equals(rb1.getText()))
                    {
                        rb1.setSelected(true);
                    }
                    else
                    {
                        rb2.setSelected(true);
                    }
                }
                    t3.setText(rs.getString("country"));
                    c1.setText(String.valueOf(rs.getInt("allocated_room_no")));
                    t4.setText(rs.getString("checkin_time"));
                    t5.setText(String.valueOf(rs.getFloat("deposit")));
                    
                    
        }
        catch(Exception e)
        {
            e.getMessage();
        }
                
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
            int s5=Integer.parseInt(c1.getText());
            String s6=t4.getText();
            String s7=t6.getText();
            int s8=Integer.parseInt(t7.getText());
            Float s9=Float.parseFloat(t5.getText());
            Float s10=Float.parseFloat(t8.getText());
            try{
                    connection css=new connection();
                    css.s.executeUpdate("insert into outcustomerdetails values('"+s1+"','"+s+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"')");
                    css.s.executeUpdate("update roomdetails set availability='Available',clean_status='Dirty' where room_no='"+s5+"'");
                    css.s.executeUpdate("delete from customerdetails where id_no='"+c.getSelectedItem().toString()+"'");
                    JOptionPane.showMessageDialog(null,"Customer Checkded Out Successfully from Allocated Room No. "+c1.getText()+"\nat"+t6.getText());
                    this.setVisible(false);
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
       if(ae.getSource()==b3)
       {
           t6.setText(new java.util.Date().toString());
       }
       if(ae.getSource()==b4)
       {
            try{
                connection cnn=new connection();
                ResultSet rs=cnn.s.executeQuery("select price from roomdetails where room_no='"+Integer.parseInt(c1.getText())+"'");
                if(rs.next())
                        {
                            fs=rs.getFloat("price");
                            t8.setText(String.valueOf((fs*Float.parseFloat(t7.getText()))));
                        }
                
        }
        catch(Exception e)
        {
            e.getMessage();
        }
           
       }
    }
    
    public static void main(String[] args)
    {
        
        String days=JOptionPane.showInputDialog(null,"NO. OF DAYS GUEST STAYED");
        day=Integer.parseInt(days);
        new UpdateCheckStatus().setVisible(true);
    }
    
}
