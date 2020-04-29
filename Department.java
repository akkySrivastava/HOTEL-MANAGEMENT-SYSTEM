/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author akky
 */
public class Department extends JFrame implements ActionListener{
    JLabel l;
    String top[]={"Room No.","Availability","Clean Status","Price(per night)","Bed Type"};
    JTable jt;
    int i=0,j=0;
    JButton b2;
    String down[][]=new String[10][5];
    Department()
    {
        getContentPane().setBackground(Color.PINK);
        setLocation(350,200);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,380);
        setLayout(null);
        
        l=new JLabel("DEPARTMENT");
        l.setFont(new Font("Algerian",Font.BOLD,22));
        l.setBounds(235,30,200,30);
        l.setForeground(Color.BLACK);
        add(l);
                jt=new JTable();
                jt.setFont(new Font("serif",Font.BOLD,15));
                JScrollPane js=new JScrollPane(jt);
                js.setBounds(5,70,575,200);
                add(js);
        try{
                connection conn=new connection();
                ResultSet rs=conn.s.executeQuery("select * from department");                   
                jt.setModel(DbUtils.resultSetToTableModel(rs));
                    
                    
                }
        
        catch(Exception e)
        {
            e.getMessage();
        }
               
        b2=new JButton("BACK");
        b2.setFont(new Font("Serif",Font.BOLD,15));
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setBounds(320,300,230,30);
        add(b2);
        
        
        b2.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b2)
        {
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new Department().setVisible(true);
        
    }
    
}
