/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
/**
 *
 * @author akky
 */
public class AddEmployee extends JFrame implements ActionListener{
    JLabel l,label,l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton rb1,rb2;
    JButton b1,b2;
    JComboBox c;
    Font f=new Font("Sans-Serif",Font.BOLD,18);
    Font f1=new Font("Monospaced",Font.BOLD,15);
    Random random= new Random();
    int id=(random.nextInt()%90000000)+10000000;
    String id1=String.valueOf(Math.abs(id));
    AddEmployee()
    {
        getContentPane().setBackground(Color.white);
        setTitle("HOTEL MANAGEMENT SYSTEM - EMPLOYEE DETAILS");
        setSize(900,500);
        setLocation(400,200);
        setLayout(null);
        
        label=new JLabel("Add Employee Details");
        label.setFont(new Font("Algerian",Font.BOLD | Font.ITALIC, 20));
        label.setForeground(Color.blue);
        label.setBounds(520,5,280,40);
        add(label);
        ImageIcon I=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/employee.jpg"));
        Image i=I.getImage().getScaledInstance(480,400,Image.SCALE_DEFAULT);
        ImageIcon i1=new ImageIcon(i);
        l=new JLabel(i1);
        l.setBounds(420,30,480,400);
        add(l);
        
        l1=new JLabel("NAME");
        l1.setFont(f);
        l1.setBounds(30,30,180,30);
        add(l1);
        
        t1=new JTextField();
        t1.setBounds(220,30,180,30);
        t1.setFont(f1);
        add(t1);
        
        l2=new JLabel("AGE");
        l2.setFont(f);
        l2.setBounds(30,70,180,30);
        add(l2);
        
        t2=new JTextField();
        t2.setBounds(220,70,180,30);
        t2.setFont(f1);
        add(t2);
        
        l3=new JLabel("GENDER");
        l3.setFont(f);
        l3.setBounds(30,110,180,30);
        add(l3);
        
        rb1=new JRadioButton("Male");
        rb1.setBounds(220,110,80,30);
        rb1.setFont(f1);
        rb1.setBackground(Color.white);
        add(rb1);
        
        rb2=new JRadioButton("Female");
        rb2.setBounds(330,110,80,30);
        rb2.setBackground(Color.white);
        rb2.setFont(f1);
        add(rb2);
        
        
        
        l4=new JLabel("JOB");
        l4.setFont(f);
        l4.setBounds(30,150,180,30);
        add(l4);
        
        c=new JComboBox();
        c.setFont(f1);
        c.setBounds(220,150,180,30);
        c.addItem("Chef");
        c.addItem("Manager");
        c.addItem("Sanitory");
        c.addItem("Receptionist");
        c.addItem("Driver");
        c.addItem("Janitor");
        c.addItem("Accountant");
        add(c);
        
        l5=new JLabel("SALARY");
        l5.setFont(f);
        l5.setBounds(30,190,180,30);
        add(l5);
        
        t3=new JTextField();
        t3.setBounds(220,190,180,30);
        t3.setFont(f1);
        add(t3);
        
        l6=new JLabel("PHONE");
        l6.setFont(f);
        l6.setBounds(30,230,180,30);
        add(l6);
        
        t4=new JTextField();
        t4.setBounds(220,230,180,30);
        t4.setFont(f1);
        add(t4);
        
        l7=new JLabel("AADHAR");
        l7.setFont(f);
        l7.setBounds(30,270,180,30);
        add(l7);
        
        t5=new JTextField();
        t5.setBounds(220,270,180,30);
        t5.setFont(f1);
        add(t5);
        
        l8=new JLabel("EMAIL");
        l8.setFont(f);
        l8.setBounds(30,310,180,30);
        add(l8); 
        
        t6=new JTextField();
        t6.setBounds(220,310,180,30);
        t6.setFont(f1);
        add(t6);
        
        l9=new JLabel("Employee ID");
        l9.setFont(f);
        l9.setBounds(30,350,180,30);
        add(l9);
        
        t7=new JTextField();
        t7.setFont(f1);
        t7.setBounds(220,350,180,30);
        t7.setText(id1);
        t7.setEditable(false);
        add(t7);
        
        b1=new JButton("ADD");
        b1.setFont(f);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(30,400,180,30);
        add(b1);
        
        b2=new JButton("Cancel");
        b2.setFont(f);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(220,400,180,30);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String str;
            if(ae.getSource()==b1)
            {
                String s1=t1.getText();
                int s2=Integer.parseInt(t2.getText());
                if(rb1.isSelected())
                {
                    str=rb1.getText();
                }
                else
                {
                    str=rb2.getText();
                }
                String s4=c.getSelectedItem().toString();
                float s5=Float.parseFloat(t3.getText());
                String s6=t4.getText();
                String s7=t5.getText();
                String s8=t6.getText();
                int s9=Integer.parseInt(t7.getText());
                try{
                        connection conn=new connection();
                        conn.s.executeUpdate("insert into employeedetails values('"+s9+"','"+s1+"','"+s2+"','"+str+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')");
                        JOptionPane.showMessageDialog(null,"Employee Added SuccessFully \n Emp ID= "+s9);
                        this.setVisible(false);
                        //JOptionPane.showInternalConfirmDialog(null,"Do You Want to add More Details");
                        new Reception().setVisible(true);
                }
                catch(Exception e)
                {
                    e.getMessage();
                }
            }
                if(ae.getSource()==b2)
                {
                    this.setVisible(false);
                    
                }
                
            
    }
    public static void main(String[] args){
        new AddEmployee().setVisible(true);
    }
}
