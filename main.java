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
public class main extends JFrame implements ActionListener {
    JLabel l,l1;
    JButton b;
    main()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(100,100);
        setSize(1300,666);
        
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
        Image I=i.getImage().getScaledInstance(1300,666,Image.SCALE_DEFAULT);
        ImageIcon i1=new ImageIcon(I);
        l=new JLabel(i1);
        l.setBounds(0,0,1300,666);
        add(l);
        
        l1=new JLabel("HOTEL MANAGEMENT SYSTEM");
        l1.setBounds(425,20,600,90);
        l1.setFont(new Font("Serif",Font.BOLD,32));
        l1.setForeground(Color.red);
        l.add(l1);
        
        b=new JButton("CONTINUE");
        b.setForeground(Color.black);
        b.setBackground(Color.white);
        b.setFont(new Font("tahoma",Font.BOLD,18));
        b.setBounds(550,590,200,30);
        add(b);
        
        b.addActionListener(this);
        
        setVisible(true);
        
        while(true)
        {
            l1.setVisible(false);
            try{
                    Thread.sleep(500);
            }
            catch(Exception e)
            {}
                l1.setVisible(true);
            
        
        try{
            Thread.sleep(500);
           }
        catch(Exception  e)
        {}
        }
        }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){
            new login().setVisible(true);
            this.setVisible(false);
        }
    }
        
    
    public static void main(String[] args){
        try{
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        new main().setVisible(true);
    }
    
}
