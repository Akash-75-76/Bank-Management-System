
package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;


public class PinChange extends JFrame implements ActionListener{

    JPasswordField pin,repint;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,935,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 800);
        add(image);
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250, 245,500, 35);
        image.add(text);
             
                            
        JLabel pintext=new JLabel("New Pin:");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165, 290,180, 25);
        image.add(pintext);
        
        
         
        JLabel repintext=new JLabel("Re-Enter Pin:");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165, 340,500, 35);
        image.add(repintext);
        
        pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330, 290, 180, 25);
        image.add(pin);
        
        
        repint =new JPasswordField();
        repint .setFont(new Font("Raleway",Font.BOLD,25));
        repint .setBounds(330, 340, 180, 25);
        image.add(repint );
        
        change=new JButton("CHANGE");
        change.setBounds(355, 440, 150, 30);
        change.addActionListener(this);
       image.add(change);
       
        
        back=new JButton("BACK");
        back.setBounds(355, 475, 150, 30);
        back.addActionListener(this);
       image.add(back);
        
        
        setSize(900,900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource()==change)
     {
             
        try{
             String npin=pin.getText();
             String repin=repint.getText();
             if(npin.equals("")){
                 JOptionPane.showMessageDialog(null,"Enter The Pin");
                 return;
             }
             if(repin.equals("")){
                 JOptionPane.showMessageDialog(null,"Confirm The Password");
                 return;
             }
             if(!npin.equals(repin)){
                 JOptionPane.showMessageDialog(null,"Entered Pin Does not match");
                 return;
                 }
             
             
                       
             if(npin.length()<3){
             JOptionPane.showMessageDialog(null,"Pin Must Be Above 3 Charesctors");
                 return;
         }
     
     
             Conn conn=new Conn();
             String query1 = "update bank set pin = '"+repin+"' where pin = '"+pinnumber+"' ";
             String query2 = "update login set pin = '"+repin+"' where pin = '"+pinnumber+"' ";
             String query3 = "update signupThree set pin = '"+repin+"' where pin = '"+pinnumber+"' ";
             conn.s.executeUpdate(query1);
             conn.s.executeUpdate(query2);
             conn.s.executeUpdate(query3);
             JOptionPane.showMessageDialog(null,"PIN Changed Sucessfully");
                 setVisible(false);
                 new Transactions(repin).setVisible(true);
             }catch(Exception e)
             {
                 System.out.println(e);
             }
         }else{
         setVisible(false);
         new Transactions(pinnumber).setVisible(true);
     }
    }



    
        
    public static void main(String args[]) {
       new PinChange("").setVisible(true);
    }
}
