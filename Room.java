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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author akky
 */
public class Room extends JFrame implements ActionListener{
    JLabel l;
    JButton b,b3;
    String top[]={"Room No.","Availability","Clean Status","Price(per night)","Bed Type"};
    JTable jt;
    int i=0,j=0;
    JButton b1,b2;
    String down[][]=new String[10][5];
    Room()
    {
        getContentPane().setBackground(Color.PINK);
        setLocation(350,200);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,380);
        setLayout(null);
        
        l=new JLabel("SEARCH DETAILS");
        l.setFont(new Font("Algerian",Font.BOLD,22));
        l.setBounds(235,30,200,30);
        l.setForeground(Color.BLACK);
        add(l);
        
        try{
                connection conn=new connection();
                ResultSet rs=conn.s.executeQuery("select * from roomdetails");
                while(rs.next())
                {
                    down[i][j++]=String.valueOf(rs.getInt("room_no"));
                    down[i][j++]=rs.getString("availability");
                    down[i][j++]=rs.getString("clean_status");
                    down[i][j++]=String.valueOf(rs.getFloat("price"));
                    down[i][j++]=rs.getString("bed_type");
                    j=0;
                    i++;
                    
                    jt=new JTable(down,top);
                    jt.setFont(new Font("serif",Font.BOLD,15));
                    JScrollPane js=new JScrollPane(jt);
                    js.setBounds(5,70,575,200);
                    //js.setFont(new Font("Algerian",Font.BOLD,18));
                   // js.setForeground(Color.blue);
                    add(js);
                }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        b1=new JButton("ADD ROOM");
        b1.setFont(new Font("Serif",Font.BOLD,15));
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(30,300,180,30);
        add(b1);
        
        b3=new JButton("BACK",new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/cancel.png")));
        b3.setFont(new Font("Serif",Font.BOLD,15));
        b3.setForeground(Color.white);
        b3.setBackground(Color.black);
        b3.setBounds(480,30,100,30);
        add(b3);
        
        b2=new JButton("UPDATE ROOM STATUS");
        b2.setFont(new Font("Serif",Font.BOLD,15));
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setBounds(320,300,230,30);
        add(b2);
        
        b1.addActionListener(this);
        b3.addActionListener(this);
        b2.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            this.setVisible(false);
            new AddRoom().setVisible(true);
        }
        if(ae.getSource()==b2)
        {
            String s=JOptionPane.showInputDialog(null,"Enter the Room No.");
            int ss=Integer.parseInt(s);
            try{
                    connection cnn=new connection();
                    cnn.s.executeUpdate("update roomdetails set clean_status='Dirty' where room_no='"+ss+"' and availability='Occupied'");
                    cnn.s.executeUpdate("update roomdetails set clean_status='Cleaned' where room_no='"+ss+"' and availability='Available'");
                    JOptionPane.showMessageDialog(null,"Room Status Changed");
                    this.setVisible(false);
                    new Room().setVisible(true);
            }
            catch(Exception e)
            {
                e.getMessage();
            }
        }
        if(ae.getSource()==b3)
        {
            this.setVisible(false);
            new Reception().setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new Room().setVisible(true);
        
    }
    
}
