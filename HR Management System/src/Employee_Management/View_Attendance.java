/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee_Management;

/**
 *
 * @author priya
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class View_Attendance extends JFrame implements ActionListener 
{
    JTable t;
    JButton bt1;
    JTextField tf1;
    JPanel p1,p2,p3;
    String x[] = {"Employee ID","Name","Email","First Half","Second Half","date"};
    String y[][] = new String [20][6];
    int i=0, j=0;
    Font f,f1;
    JLabel l1,l2;
    
    View_Attendance()
    {
      super("All Employee attendence records");
      setSize(1480,400);
      setLocation(0,10);
      f = new Font("MS UI Gothic",Font.BOLD,17);
      
      try
      {
          ConnectionClass obj = new ConnectionClass();
          String q = "Select * from attendence";
          ResultSet rest = obj.stmt.executeQuery(q);
          while(rest.next())
          {
              y[i][j++] = rest.getString("Eid");
              y[i][j++] = rest.getString("name");
              y[i][j++] = rest.getString("Email");
              y[i][j++] = rest.getString("first_half");
              y[i][j++] = rest.getString("second_half");
              y[i][j++] = rest.getString("day_date");
                
              i++;
              j=0;    
          }
            t = new JTable(y,x);
      }
      catch(Exception ex)
      { ex.printStackTrace();}
      
      t.setBackground(Color.BLACK);
      t.setForeground(Color.WHITE);
      t.setFont(f);
      
      JScrollPane js = new JScrollPane(t);
      
      f1 = new Font("Lucidia Fax",Font.BOLD,25);
      
      l1 = new JLabel("Search any Employee");
      l1.setHorizontalAlignment(JLabel.CENTER);
      l1.setFont(f1);
      l1.setForeground(Color.YELLOW);
      
      
      l2 =new JLabel("Employee ID");
      l2.setFont(f1);
      l2.setForeground(Color.GRAY);
      
      tf1 = new JTextField();
      bt1 = new JButton("Search Employee");
      tf1.setFont(f);
      bt1.setFont(f);
      
      bt1.setBackground(Color.BLACK);
      bt1.setForeground(Color.RED);
      bt1.addActionListener(this);
      
      p1 = new JPanel();
      p1.setLayout(new GridLayout(1,1,10,10));
      p1.add(l1);
      
      p2 = new JPanel();
      p2.setLayout(new GridLayout(1,3,10,10));
      p2.add(l2);
      p2.add(tf1);
      p2.add(bt1);
      
      p3 = new JPanel();
      p3.setLayout(new GridLayout(2,1,10,10));
      p3.add(p1);
      p3.add(p2);
      
      p1.setBackground(Color.BLACK);
      p2.setBackground(Color.BLACK);
      p3.setBackground(Color.BLACK);
      
      add(p3,"South");
      add(js);
      
    }
    
    public void actionPerformed(ActionEvent e)
    {  
       String eid = tf1.getText();
       if(e.getSource()==bt1)
       {
          new View_Attendance_single(eid).setVisible(true);
       }
    }
    
    public static void main(String args[])
    {
      new View_Attendance().setVisible(true);
    }
}
