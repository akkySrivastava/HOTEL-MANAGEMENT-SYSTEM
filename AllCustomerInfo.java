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
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author akky
 */
public class AllCustomerInfo extends JFrame implements ActionListener{
    JLabel l;
    JButton b;
    String top[]={"ID","ID_NUMBER","NAME","GENDER","COUNTRY","ALLOCATED ROOM NO","CHECK-IN TIME","DEPOSITED AMT"};
    JTable jt;
    int i=0,j=0;
    JButton b1,b2;
    String down[][]=new String[15][8];
    AllCustomerInfo()
    {
        getContentPane().setBackground(new Color(0,255,0));
        setLocation(350,200);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,380);
        setLayout(null);
        
        l=new JLabel("CUSTOMER DETAILS");
        l.setFont(new Font("Algerian",Font.BOLD,22));
        l.setBounds(435,30,300,30);
        l.setForeground(Color.white);
        add(l);
        
        try{
                connection conn=new connection();
                ResultSet rs=conn.s.executeQuery("select * from customerdetails");
                while(rs.next())
                {
                    down[i][j++]=rs.getString("id");
                    down[i][j++]=rs.getString("id_no");
                    down[i][j++]=rs.getString("c_name");
                    down[i][j++]=rs.getString("gender");
                    down[i][j++]=rs.getString("country");
                    down[i][j++]=String.valueOf(rs.getInt("allocated_room_no"));
                    down[i][j++]=rs.getString("checkin_time");
                    down[i][j++]=String.valueOf(rs.getFloat("deposit"));
                    j=0;
                    i++;
                    
                    jt=new JTable(down,top);
                    jt.setFont(new Font("serif",Font.BOLD,15));
                    JScrollPane js=new JScrollPane(jt);
                    js.setBounds(5,70,975,200);
                    //js.setFont(new Font("Algerian",Font.BOLD,18));
                   // js.setForeground(Color.blue);
                    add(js);
                }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        b1=new JButton("Add New Custome");
        b1.setFont(new Font("Serif",Font.BOLD,15));
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(30,300,180,30);
        add(b1);
        
        b2=new JButton("Check-Out");
        b2.setFont(new Font("Serif",Font.BOLD,15));
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setBounds(790,300,180,30);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            
            new NewCustomerForm().setVisible(true);
            this.setVisible(false);
          }
        if(ae.getSource()==b2)
        {
            
            String s=JOptionPane.showInputDialog(null,"Enter the Room No. of Customer:");
            if(s.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter the Room No.");
                
            }
            int ss=Integer.parseInt(s);
            try{
                    this.setVisible(false);
                    new UpdateCheckStatus().setVisible(true);
                    
            }
            catch(Exception e)
            {
                
                e.getMessage();
            }
        }
    }
    public static void main(String[] args)
    {
        new AllCustomerInfo().setVisible(true);
    }
    
}
