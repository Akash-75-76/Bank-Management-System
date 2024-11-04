
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
      JButton hundred,fivehundred,thousand,twothousand,fivethousand,tenthousand,exit;
      String pinnumber;
      
       FastCash(String pinnumber)
       {
           this.pinnumber=pinnumber;
           setLayout(null);
           ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
           Image i2=i1.getImage().getScaledInstance(900,935, Image.SCALE_DEFAULT);
           ImageIcon i3=new ImageIcon(i2);
           JLabel image=new JLabel(i3);
           image.setBounds(0, 0,900, 800);
           add(image);
           
           JLabel text=new JLabel("SELECT WITHDRAW AMOUNT");
           text.setBounds(213, 300, 700, 35);
           text.setForeground((Color.white));
           text.setFont(new Font("System",Font.BOLD,16));
           image.add(text);
           
           hundred=new JButton("100");
           hundred.setBounds(170, 365, 150, 30);
           hundred.addActionListener(this);
           image.add(hundred);
           
           
           fivehundred=new JButton("500");
           fivehundred.setBounds(355, 365, 150, 30);
           fivehundred.addActionListener(this);
           image.add(fivehundred);
           
           
           thousand=new JButton("1000");
           thousand.setBounds(170, 400, 150, 30);
           thousand.addActionListener(this);
           image.add(thousand);
           
           twothousand=new JButton("2000");
           twothousand.setBounds(355, 400, 150, 30);
           twothousand.addActionListener(this);
           image.add(twothousand);
           
           fivethousand=new JButton("5000");
           fivethousand.setBounds(170, 435, 150, 30);
           fivethousand.addActionListener(this);
           image.add(fivethousand);
           
            
           tenthousand=new JButton("10000");
           tenthousand.setBounds(355, 436, 150, 30);
           tenthousand.addActionListener(this);
           image.add(tenthousand);
           
            
           exit=new JButton("Back");
           exit.setBounds(355, 472, 150, 30);
           exit.addActionListener(this);
           image.add(exit);
           
           setSize(900,900);
           setLocation(300,0);
           setUndecorated(true);
           setVisible(true);
       }
      public void actionPerformed(ActionEvent ae)
      {
          if(ae.getSource()==exit)
          {
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
          }
          else 
          {
              String amount=((JButton)ae.getSource()).getText();
              Conn c=new Conn();
              try
              {
                  if(ae.getSource()==hundred){
                       JOptionPane.showMessageDialog(null, "Rs 100 Debited Sucessfully");
                  }
                  else if(ae.getSource()==fivehundred){
                       JOptionPane.showMessageDialog(null, "Rs 500 Debited Sucessfully");
                               }
                   else if(ae.getSource()==thousand){
                       JOptionPane.showMessageDialog(null, "Rs 1000 Debited Sucessfully");
                               }
                    else if(ae.getSource()==twothousand){
                       JOptionPane.showMessageDialog(null, "Rs 2000 Debited Sucessfully");
                               }
                   else if(ae.getSource()==fivethousand){
                       JOptionPane.showMessageDialog(null, "Rs 5000 Debited Sucessfully");
                               }
                   else if(ae.getSource()==tenthousand){
                       JOptionPane.showMessageDialog(null, "Rs 10000 Debited Sucessfully");
                               }
                  
                  ResultSet rs=c.s.executeQuery("Select * from bank where pin='"+pinnumber+"'");
                  int balance=0;
                  while(rs.next())
                  {
                      if(rs.getString("type").equals("Deposit"))
                      {
                          balance+=Integer.parseInt(rs.getString("amount"));
                      }else
                      {
                          balance-=Integer.parseInt(rs.getString("amount"));
                      }
                  }
                  if( balance < Integer.parseInt(amount))
                  {
                     // JOptionPane.showMessageDialog(null, "Insufficient Balance");
                      return;
                  }
                 
               
                 Date date = new Date();
                 c.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
               // JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
          }
              catch(Exception e)
              {
                  System.out.println(e);
               }
        }
}
    public static void main(String args[]) {
        new FastCash("").setVisible(true);
    }
}
