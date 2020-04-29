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
import javax.swing.UIManager.LookAndFeelInfo;
/**
 *
 * @author akky
 */
public class SearchRoom extends JFrame implements ActionListener{
    JLabel l,l1;
    JComboBox c;
    JCheckBox c1;
    JButton b,b2;
    JTable jt;
    
    JButton b1;
    SearchRoom()
    {
        getContentPane().setBackground(Color.PINK);
        setLocation(350,200);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,475);
        setLayout(null);
        
        l=new JLabel("ROOM DETAILS");
        l.setFont(new Font("Algerian",Font.BOLD,22));
        l.setBounds(235,30,200,30);
        l.setForeground(Color.BLUE);
        add(l);
        
        l1=new JLabel("Select Bed Type");
        l1.setFont(new Font("Serif",Font.BOLD,18));
        l1.setBounds(30,300,180,30);
        add(l1);
        
        c=new JComboBox();
        c.addItem("Single Bed");
        c.addItem("Double Bed");
        c.setBounds(220,300,180,30);
        c.setFont(new Font("Serif",Font.BOLD,15));
        c.setBackground(Color.white);
        add(c);
        
        c1=new JCheckBox("Only Available Rooms");
        c1.setBackground(Color.pink);
        c1.setFont(new Font("Serif",Font.BOLD,18));
        c1.setBounds(220,340,220,30);
        add(c1);
        
        b1=new JButton("LOAD DATA");
        b1.setFont(new Font("Serif",Font.BOLD,15));
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(170,400,180,30);
        add(b1);
        
        b2=new JButton("BACK",new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/cancel.png")));
        b2.setFont(new Font("Serif",Font.BOLD,15));
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setBounds(470,30,100,30);
        add(b2);
        
                    jt=new JTable();
                    jt.setFont(new Font("serif",Font.BOLD,15));
                    JScrollPane js=new JScrollPane(jt);
                    js.setBounds(5,70,575,200);
                    jt.setBackground(Color.GREEN);
                    add(js);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                connection conn=new connection();
                String sps=c.getSelectedItem().toString();
                String rs="select * from roomdetails where bed_type='"+sps+"'";
                String rss="select * from roomdetails where availability='Available' and bed_type='"+sps+"'";
                    
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
        if(ae.getSource()==b2)
        {
            this.setVisible(false);
            new Reception().setVisible(true);
        }
        
    }
    public static void main(String[] args)
    {
        try{
                for(LookAndFeelInfo info:UIManager.getInstalledLookAndFeels())
                {
                    if("Nimbus".equals(info.getName()))
                    {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                    
                }
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        new SearchRoom().setVisible(true);
        
    }
}
