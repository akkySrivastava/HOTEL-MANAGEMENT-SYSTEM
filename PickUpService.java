/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author akky
 */
public class PickUpService extends JFrame implements ActionListener{
    JLabel l,l1;
    JComboBox c;
    JCheckBox c1;
    JButton b;
    JTable jt;
    
    JButton b1;
    PickUpService()
    {
        getContentPane().setBackground(Color.PINK);
        setLocation(350,200);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,475);
        setLayout(null);
        
        l=new JLabel("AVAILABLE PICKUP SERVICES");
        l.setFont(new Font("Algerian",Font.BOLD,22));
        l.setBounds(325,30,390,30);
        l.setForeground(Color.BLUE);
        add(l);
        
        b=new JButton("BACK",new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/cancel.png")));
        b.setFont(new Font("Serif",Font.BOLD,15));
        b.setForeground(Color.white);
        b.setBackground(Color.black);
        b.setBounds(775,30,100,30);
        add(b);
        
        l1=new JLabel("Car Brand");
        l1.setFont(new Font("Serif",Font.BOLD,18));
        l1.setBounds(230,300,180,30);
        add(l1);
        
        c=new JComboBox();
        try{
                connection conn=new connection ();
                ResultSet rs=conn.s.executeQuery("select car_brand from driverdetails");
                while(rs.next())
                {
                c.addItem(rs.getString("car_brand"));
                }
        }
        catch(Exception e)
        {
                e.getMessage();
        }
        c.setBounds(420,300,180,30);
        c.setFont(new Font("Serif",Font.BOLD,15));
        c.setBackground(Color.white);
        add(c);
        
        c1=new JCheckBox("Only Available Drivers");
        c1.setBackground(Color.pink);
        c1.setFont(new Font("Serif",Font.BOLD,18));
        c1.setBounds(420,340,220,30);
        add(c1);
        
        b1=new JButton("LOAD DATA");
        b1.setFont(new Font("Serif",Font.BOLD,15));
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(420,400,180,30);
        add(b1);
        
                    jt=new JTable();
                    jt.setFont(new Font("serif",Font.BOLD,15));
                    JScrollPane js=new JScrollPane(jt);
                    js.setBounds(5,70,875,200);
                    jt.setBackground(Color.GREEN);
                    add(js);
        
        b1.addActionListener(this);
        b.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                connection conn=new connection();
                String sps=c.getSelectedItem().toString();
                String rs="select * from driverdetails where car_brand='"+sps+"'";
                String rss="select * from driverdetails where availability='Yes' and car_brand='"+sps+"'";
                    
                    if(c1.isSelected()){
                    ResultSet x=conn.s.executeQuery(rss);
                    jt.setModel(DbUtils.resultSetToTableModel(x));
                    }
                    else
                    {
                        ResultSet y=conn.s.executeQuery(rs);
                        jt.setModel(DbUtils.resultSetToTableModel(y));
                    }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
            
        }
        if(ae.getSource()==b)
        {
            this.setVisible(false);
            new Reception().setVisible(true);
        }
        
    }
    public static void main(String[] args)
    {
        new PickUpService().setVisible(true);
        
    }
}
