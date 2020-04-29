/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 *
 * @author akky
 */
public class login extends JFrame implements ActionListener {
        JLabel l1,l2,l3,l4;
        JTextField t1;
        JPasswordField t2;
        JButton b1,b2;
        login()
        {
            getContentPane().setBackground(Color.white);
            setLayout(null);
            setSize(550,400);
            setLocation(300,100);
            
        l1=new JLabel("!!!Authentication!!!");
        l1.setForeground(Color.blue);
        l1.setBounds(150,20,200,50);
        l1.setFont(new Font("System",Font.BOLD,20));
        add(l1);
        
        l2=new JLabel("User-ID:");
        l2.setBounds(50,120,100,30);
        l2.setFont(new Font("Tahoma",Font.BOLD,17));
        add(l2);
        
        l3=new JLabel("Password:");
        l3.setBounds(50,170,100,30);
        l3.setFont(new Font("Tahoma",Font.BOLD,17));
        add(l3);
        
        t1=new JTextField();
        t1.setFont(new Font("courier",Font.BOLD,15));
        t1.setForeground(Color.GREEN);
        t1.setBounds(180,120,150,30);
        add(t1);
        
        t2=new JPasswordField();
        t2.setFont(new Font("courier",Font.BOLD,15));
        t2.setForeground(Color.GREEN);
        t2.setBounds(180,170,150,30);
        add(t2);
        
        b1=new JButton("Login",new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/login.png")));
        b1.setBackground(Color.BLACK);
        b1.setFont(new Font("System",Font.BOLD,15));
        b1.setForeground(Color.GREEN);
        b1.setBounds(50,250,120,30);
        add(b1);
        
        b2=new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/cancel.png")));
        b2.setBackground(Color.BLACK);
        b2.setFont(new Font("System",Font.BOLD,15));
        b2.setForeground(Color.red);
        b2.setBounds(180,250,120,30);
        add(b2);
        
        ImageIcon I=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/secondII.jpg"));
        Image I1=I.getImage().getScaledInstance(180,180,Image.SCALE_DEFAULT);
        ImageIcon I2=new ImageIcon(I1);
        l4=new JLabel(I2);
        l4.setBounds(350,100,120,120);
        add(l4);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1){
            String user=t1.getText();
            String pass=t2.getText();
            
            try {
                connection conn=new connection();
                ResultSet rs=conn.s.executeQuery("select * from login where username='"+user+"' and password='"+pass+"'");
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"Sucessfully Logged In");
                    new welcome().setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Authentication Failed");
                    t1.setText("");
                    t2.setText("");
                    this.setVisible(true);
                    
                    
                }
            
            }
            catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getSource()==b2)
        {
            
            this.setVisible(false);
            new welcome().setVisible(false);
        }
        
    }

public static void main(String[] args)
{
    new login().setVisible(true);
}
        
}
