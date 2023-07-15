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
public class View_Employee implements ActionListener 
{
   JFrame f;
   JTextField t;
   JLabel l1, l2;
   JButton b,b2;
   
  View_Employee()
  {
     f = new JFrame("View Employee");
     f.setBackground(Color.GREEN);
     f.setLayout(null);
     
     l1 = new JLabel();
     l1.setBounds(0,0,500,270);
     l1.setLayout(null);
     
     ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee_Management/icon/back2.jpg"));
     Image i1 = img.getImage().getScaledInstance(700,370 , Image.SCALE_DEFAULT);
     ImageIcon img1 = new ImageIcon(i1);
     l1.setIcon(img1);
             
     l2 = new JLabel("Employee Id");
     l2.setVisible(true);
     l2.setBounds(40,60,250,30);
     l2.setForeground(Color.WHITE);
     Font f1 = new Font("Airal", Font.BOLD,30);
     l2.setFont(f1);
     l1.add(l2);
     f.add(l1);
     
     t = new JTextField();
     t.setBounds(240,60,220,30);
     l1.add(t);
     
     b = new JButton("Search");
     b.setBounds(140,150,100,30);
     b.addActionListener(this);
     l1.add(b);
     
     b2 = new JButton("Cancel");
     b2.setBackground(Color.RED);
     b2.setForeground(Color.WHITE);
     b2.setBounds(260,150,100,30);
     b2.addActionListener(this);
     l1.add(b2);
     
     f.setSize(500,270);
     f.setLocation(450,250);
     f.setVisible(true);
  }
  
  
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b)
        {
          f.setVisible(false);
          new View_Employee_Data(t.getText());
        }
        if(e.getSource() == b2)
        {
          f.setVisible(false);
          new HomePage();
        }
    }
  
  public static void main(String args[])
  {
  
  }

    
    
}
