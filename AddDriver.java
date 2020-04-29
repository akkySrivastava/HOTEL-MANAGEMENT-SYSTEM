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
import java.sql.SQLException;
import java.util.Random;
public class AddDriver extends JFrame implements ActionListener{
    JLabel l,label,l1,l2,l3,l4,l5,l6,l7,l8,label1;
    JTextField t1,t2,t3,t4,t5,t6;
    JComboBox c1,c2;
    JButton b1,b2;
    Font f=new Font("Serif",Font.BOLD,18);
    Font f1=new Font("monospaced",Font.BOLD,15);
    
    Random ran=new Random();
    int first=(ran.nextInt()%90000000)+10000000;
    String ss=String.valueOf(Math.abs(first));
    AddDriver()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setLocation(400,200);
        setSize(800,450);
        setForeground(Color.BLUE);
        
        ImageIcon I=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/download.jpg"));
        Image i=I.getImage().getScaledInstance(380,160,Image.SCALE_DEFAULT);
        ImageIcon i1=new ImageIcon(i);
        l=new JLabel(i1);
        l.setBounds(420,40,380,160);
        add(l);
        
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/unnamed.jpg"));
        Image n=I1.getImage().getScaledInstance(380,180,Image.SCALE_DEFAULT);
        ImageIcon n1=new ImageIcon(n);
        label1=new JLabel(n1);
        label1.setBounds(420,200,380,180);
        add(label1);
        
        label=new JLabel("ADD DRIVER");
        label.setBounds(500,10,280,30);
        label.setFont(new Font("Algerian",Font.BOLD,32));
        label.setForeground(Color.red);
        add(label);
        
        
        
        l1=new JLabel("Name");
        l1.setBounds(30,30,180,30);
        l1.setFont(f);
        add(l1);
        
        t1=new JTextField();
        t1.setBounds(220,30,180,30);
        t1.setFont(f1);
        add(t1);
        
        l2=new JLabel("Age");
        l2.setBounds(30,70,180,30);
        l2.setFont(f);
        add(l2);
        
        t2=new JTextField();
        t2.setBounds(220,70,180,30);
        t2.setFont(f1);
        add(t2);
        
        l3=new JLabel("Gender");
        l3.setBounds(30,110,180,30);
        l3.setFont(f);
        add(l3);
        
        c1=new JComboBox();
        c1.setBackground(Color.white);
        c1.setBounds(220,110,180,30);
        c1.addItem("Male");
        c1.addItem("Female");
        add(c1);
        
        l4=new JLabel("Car Brand");
        l4.setBounds(30,150,180,30);
        l4.setFont(f);
        add(l4);
        
        t3=new JTextField();
        t3.setBounds(220,150,180,30);
        t3.setFont(f1);
        add(t3);
        
        l5=new JLabel("Car Model");
        l5.setBounds(30,190,180,30);
        l5.setFont(f);
        add(l5);
        
        t4=new JTextField();
        t4.setBounds(220,190,180,30);
        t4.setFont(f1);
        add(t4);
        
        l6=new JLabel("Avalilability");
        l6.setBounds(30,230,180,30);
        l6.setFont(f);
        add(l6);
        
        c2=new JComboBox();
        c2.setBackground(Color.white);
        c2.setBounds(220,230,180,30);
        c2.addItem("Yes");
        c2.addItem("No");
        add(c2);
        
        l7=new JLabel("Location");
        l7.setBounds(30,270,180,30);
        l7.setFont(f);
        add(l7);
        
        t5=new JTextField();
        t5.setBounds(220,270,180,30);
        t5.setFont(f1);
        add(t5);
        
        l8=new JLabel("Driver ID");
        l8.setBounds(30,310,180,30);
        l8.setFont(f);
        add(l8);
        
        t6=new JTextField();
        t6.setBounds(220,310,180,30);
        t6.setText(ss);
        t6.setEditable(false);
        t6.setFont(f1);
        add(t6);
        
        b1=new JButton("ADD");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(30,350,180,30);
        add(b1);
        
        b2=new JButton("BACK");
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setBounds(220,350,180,30);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1)
        {
           int s=Integer.parseInt(t6.getText());
           String s1=t1.getText();
           int s2=Integer.parseInt(t2.getText());
           String s3=c1.getSelectedItem().toString();
           String s4=t3.getText();
           String s5=t4.getText();
           String s6=c2.getSelectedItem().toString();
           String s7=t5.getText();
           try{
                    connection css=new  connection();
                    css.s.executeUpdate("insert into driverdetails values('"+s+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')");
                    JOptionPane.showMessageDialog(null,"Driver Added Successfully \nDriver ID "+t6.getText());
                    this.setVisible(false);
                   // new welcome().setVisible(true);
        }
        
           catch(SQLException e)
                   {
                        e.getMessage();
                        JOptionPane.showMessageDialog(null,"Driver ID already exit\nPlease try again");
                        
                   }
        }
        if(ae.getSource()==b2)
        {
            dispose();
            //new welcome().setVisible(true);
        }
    }
    
    
    public static void main(String[] args)
    {
        new AddDriver().setVisible(true);
    }
}
