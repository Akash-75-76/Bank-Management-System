
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
    
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login()
    {
  

        setUndecorated(false);
        setTitle("ATM");
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/sbi.png"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(40, 10, 170, 120);
        add(label);
        
        JLabel text=new JLabel("Welcome To  SBI ATM");
        text.setFont(new Font("Arial",Font.BOLD,38));
        text.setForeground(Color.white);
        text.setBounds(220, 40, 450, 40);
        add(text);      
        JLabel cardno=new JLabel("Card NO:");
        cardno.setFont(new Font("Railway",Font.BOLD,28));
        cardno.setForeground(Color.white);
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);       
        cardTextField=new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Railway",Font.BOLD,28));
        pin.setForeground(Color.white);
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
         pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.yellow);
        login.setForeground(Color.black);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.yellow);
        clear.setForeground(Color.black);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.yellow);
        signup.setForeground(Color.black);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.blue);
        setSize(800, 600);
        setVisible(true);
        setLocation(300, 130);
    }
   
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login)
        {
            Conn conn=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="Select * from login where cardnumber='"+cardnumber+"' and pin='"+pinnumber+"'";
            try
            {
               ResultSet rs= conn.s.executeQuery(query);
               if(rs.next())
               {
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               }
               else if( pinTextField.equals("")||cardTextField.equals(""))
               {
                   JOptionPane.showMessageDialog(null,"Enter Card NO or Pin");
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"Incorrect Card NO or Pin");
               }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
        else if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[])
    {
     new Login();
    }
    
}
