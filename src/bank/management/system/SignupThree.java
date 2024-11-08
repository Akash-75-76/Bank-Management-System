
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.*;


public class SignupThree extends JFrame implements ActionListener{
    
        JRadioButton r1,r2,r3,r4;
        JCheckBox c1,c2,c3,c4,c5,c6,c7;
        JButton submit,cancel;
        String formno;
          SignupThree(String formno)
          {
              this.formno=formno;
              setLayout(null);
              
              JLabel l1=new JLabel("Page 3:Account Details");
              l1.setFont(new Font("Raleway",Font.BOLD,22));
              l1.setBounds(280, 40, 400, 40);
              add(l1);
              
                 
              JLabel type=new JLabel("Account Types:");
              type.setFont(new Font("Raleway",Font.BOLD,22));
              type.setBounds(100, 140,200, 30);
              add(type);
              
              
              r1=new JRadioButton("Saving Account");
              r1.setFont(new Font("Raleway",Font.BOLD,16));
              r1.setBackground(Color.white);
              r1.setBounds(100, 180, 155, 20);
              add(r1);
              
              
              r2=new JRadioButton("Fix Deposit Account");
              r2.setFont(new Font("Raleway",Font.BOLD,16));
              r2.setBackground(Color.white);
              r2.setBounds(350, 180, 250, 20);
              add(r2);
              
              r3=new JRadioButton("Current Account");
              r3.setFont(new Font("Raleway",Font.BOLD,16));
              r3.setBackground(Color.white);
              r3.setBounds(100, 220, 155, 20);
              add(r3);
            
              r4=new JRadioButton("Recurring Deposit Account");
              r4.setFont(new Font("Raleway",Font.BOLD,16));
              r4.setBackground(Color.white);
              r4.setBounds(350, 220, 250, 20);
              add(r4);
              
              ButtonGroup groupaccount=new ButtonGroup();
              groupaccount.add(r1);
              groupaccount.add(r2);
              groupaccount.add(r3);
              groupaccount.add(r4);
              
              JLabel card=new JLabel("Card No:");
              card.setFont(new Font("Raleway",Font.BOLD,22));
              card.setBounds(100, 300,200, 30);
              add(card);
              
              JLabel number=new JLabel("XXXX-XXXX-XXXX-7576");
              number.setFont(new Font("Raleway",Font.BOLD,22));
              number.setBounds(335, 315,300, 30);
              add(number);
              
              JLabel carddetail=new JLabel("Your 16 Digit Card Number:");
              carddetail.setFont(new Font("Raleway",Font.BOLD,16));
              carddetail.setBounds(100, 333,300, 20);
              add(carddetail);
              
              JLabel pin=new JLabel("Pin No:");
              pin.setFont(new Font("Raleway",Font.BOLD,22));
              pin.setBounds(100, 370,200, 30);
              add(pin);
               JLabel pindetail=new JLabel("Your 4 Digit Pin Number:");
              pindetail.setFont(new Font("Raleway",Font.BOLD,16));
              pindetail.setBounds(100, 400,300, 20);
              add(pindetail);
              
              JLabel pnumber=new JLabel("XXXX");
              pnumber.setFont(new Font("Raleway",Font.BOLD,22));
              pnumber.setBounds(335, 380,300, 30);
              add(pnumber);
              
              JLabel services=new JLabel("Services Required:");
              services.setFont(new Font("Raleway",Font.BOLD,22));
              services.setBounds(100, 450,220, 30);
              add(services);
              
              c1=new JCheckBox("ATM CARD");
              c1.setBackground(Color.white);
              c1.setFont(new Font("Raleway",Font.BOLD,16));
              c1.setBounds(100, 500, 200, 30);
              add(c1);
              
              c2=new JCheckBox("Internet Banking");
              c2.setBackground(Color.white);
              c2.setFont(new Font("Raleway",Font.BOLD,16));
              c2.setBounds(350, 500, 200, 30);
              add(c2);
              
              c3=new JCheckBox("Mobile Banking");
              c3.setBackground(Color.white);
              c3.setFont(new Font("Raleway",Font.BOLD,16));
              c3.setBounds(100, 550, 200, 30);
              add(c3); 
              
              c4=new JCheckBox("Email and SMS Alerts");
              c4.setBackground(Color.white);
              c4.setFont(new Font("Raleway",Font.BOLD,16));
              c4.setBounds(350, 550, 200, 30);
              add(c4);
              
              c5=new JCheckBox("Checkbook");
              c5.setBackground(Color.white);
              c5.setFont(new Font("Raleway",Font.BOLD,16));
              c5.setBounds(100, 600, 200, 30);
              add(c5);
              
              c6=new JCheckBox("E-Statements");
              c6.setBackground(Color.white);
              c6.setFont(new Font("Raleway",Font.BOLD,16));
              c6.setBounds(350, 600, 200, 30);
              add(c6);
              
              c7=new JCheckBox("I hereby declares that the above entered details are correct to best of my knowlage");
              c7.setBackground(Color.white);
              c7.setFont(new Font("Raleway",Font.BOLD,12));
              c7.setBounds(100, 680, 600, 30);
              add(c7);
              
              
              submit=new JButton("Submit");
              submit.setBackground(Color.BLACK);
              submit.setForeground(Color.white);
              submit.setFont(new Font("Raleway",Font.BOLD,14));
              submit.setBounds(250, 720, 100, 30);
              submit.addActionListener(this);
              add(submit);
              
              
              cancel=new JButton("Cancel");
              cancel.setBackground(Color.BLACK);
              cancel.setForeground(Color.white);
              cancel.setFont(new Font("Raleway",Font.BOLD,14));
              cancel.setBounds(420, 720, 100, 30);
              add(cancel);
              cancel.addActionListener(this);
              getContentPane().setBackground(Color.white);
              
              
              setSize(850,820);
              setLocation(350,0);
              setVisible(true);
              
          }
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==submit)
       {
           String acctype=null;
           if(r1.isSelected())
           {
               acctype="Saving Account";
           }
           else if(r2.isSelected())
           {
               acctype="Fixed Deposit Account";
           }
            else if(r3.isSelected())
           {
               acctype="Current Account";
           }
            else if(r4.isSelected())
           {
               acctype="Reccuring Deposit Account";
           }
       
       Random random=new Random();
       String cardnumber=""+Math.abs((random.nextLong()%90000000L) +504093600000000L);
       String pinnumber=""+Math.abs((random.nextLong()%9000L) +1000L);
       String facility="";
       if(c1.isSelected())
       {
           facility=facility+"ATM Card";
       }
       else if(c2.isSelected())
       {
           facility=facility+" Internet Banking";
       }
       else if(c3.isSelected())
       {
           facility=facility+" Mobile Banking";
       }
       else if(c4.isSelected())
       {
           facility=facility+" Email and SMS Alerts";
       }
       else if(c5.isSelected())
       {
           facility=facility+" Checkbook";
       }
       else if(c6.isSelected())
       {
           facility=facility+" E-Statement";
       }
       try
       {
           if(acctype.equals(" ")||!c7.isSelected())
           {
               JOptionPane.showMessageDialog(null, "Please Select all fields and Give Agreement");
           }
           else
           {
               Conn conn=new Conn();
               String query1="insert into signupThree values('"+formno+"','"+acctype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
               String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
               conn.s.executeUpdate(query1);
               conn.s.executeUpdate(query2);
               
               JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\nPin: "+pinnumber);
               
               setVisible(false);
               new Deposit(pinnumber).setVisible(true);
           } setVisible(false);
            new Transactions(formno).setVisible(true);
       }catch(Exception e)
       {
           System.out.println(e);
       }
     }
   else if(ae.getSource()==cancel)
   {
           setVisible(true);
           new Login().setVisible(true);
   }
 }
    
    public static void main(String args[]) {
        new SignupThree("");
    }
}
