/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


/**
 *
 * @author akky
 */
public class AllEmployeeInfo extends JFrame implements ActionListener{
    JLabel l;
    JButton b;
    String top[]={"Emp ID","Name","Age","Gender","JOB","Salary","Phone","Aadhar","Email"};
    JTable jt;
    int i=0,j=0;
    JButton b1,b2;
    String down[][]=new String[15][9];
    AllEmployeeInfo()
    {
        getContentPane().setBackground(new Color(0,0,255));
        setLocation(350,200);
       // setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,380);
        setLayout(null);
        
        l=new JLabel("EMPLOYEE DETAILS");
        l.setFont(new Font("Algerian",Font.BOLD,22));
        l.setBounds(435,30,300,30);
        l.setForeground(Color.white);
        add(l);
        
        try{
                connection conn=new connection();
                ResultSet rs=conn.s.executeQuery("select * from employeedetails");
                while(rs.next())
                {
                    down[i][j++]=String.valueOf(rs.getInt("emp_id"));
                    down[i][j++]=rs.getString("e_name");
                    down[i][j++]=String.valueOf(rs.getInt("age"));
                    down[i][j++]=rs.getString("gender");
                    down[i][j++]=rs.getString("job");
                    down[i][j++]=String.valueOf(rs.getFloat("salary"));
                    down[i][j++]=rs.getString("phone");
                    down[i][j++]=rs.getString("aadhar");
                    down[i][j++]=rs.getString("email");
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
        b1=new JButton("Add Employee");
        b1.setFont(new Font("Serif",Font.BOLD,15));
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(30,300,180,30);
        add(b1);
        
        b2=new JButton("Delete Employee");
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
            this.setVisible(false);
            new AddEmployee().setVisible(true);
        }
        if(ae.getSource()==b2)
        {
            
            String s=JOptionPane.showInputDialog(null,"Enter the employee id to delete:");
            int ss=Integer.parseInt(s);
            try{
                    connection css=new connection();
                    css.s.executeUpdate("delete from employeedetails where emp_id='"+ss+"'");
                    JOptionPane.showMessageDialog(null,"Employee deleted Successfully");
                    this.setVisible(false);
                    new AllEmployeeInfo().setVisible(true);
            }
            catch(Exception e)
            {
                e.getMessage();
            }
        }
    }
    public static void main(String[] args)
    {
        new AllEmployeeInfo().setVisible(true);
    }
    
}
