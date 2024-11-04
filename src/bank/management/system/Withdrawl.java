
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import java.sql.*;


public class Withdrawl extends JFrame implements ActionListener{
     JTextField amount;
     JButton withdraw,back;
     String pinnumber;
  Withdrawl(String pinnumber)
  {
      this.pinnumber=pinnumber;
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
      image.setBounds(0, 0,900,900);
      add(image);
      
      JLabel text=new JLabel("Enter the amount you want to Withdraw:");
      text.setForeground(Color.WHITE);
      text.setFont(new Font("System",Font.BOLD,16));
      text.setBounds(170, 300,400, 20);
      image.add(text);
      
      
      amount=new JTextField();
      amount.setFont(new Font("Raleway",Font.BOLD,22));
      amount.setBounds(170, 350, 320, 25);
      image.add(amount);
      
       back=new JButton("Back");
      back.setBounds(355, 493, 150,30);
      back.addActionListener(this);
      image.add(back);
      
      withdraw=new JButton("Withdraw");
      withdraw.setBounds(355, 460, 150,30);
      withdraw.addActionListener(this);
      image.add(withdraw);
      
      setSize(900,900);
      setLocation(300, 0);
      setVisible(true);
  }   
      public void actionPerformed(ActionEvent ae)
       {
           try{        
            String number = amount.getText();
            Date date = new Date();
            if(ae.getSource()==withdraw){
                if(number.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                      String text = amount.getText();  
                      int value = Integer.parseInt(text);
                    if(balance < value){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+number+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+value+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
         } else if(ae.getSource()==back)
           {
               setVisible(false);
            new Transactions(pinnumber).setVisible(true);
           }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
       }
  
    public static void main(String args[]) {
       new Withdrawl("");
       
    }
}
