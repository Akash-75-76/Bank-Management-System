
package bank.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne  extends JFrame implements ActionListener
{
    long random;
    JTextField  nameTextfield,fTextfield,pinTextfield,stateTextfield ,cityTextfield,addressTextfield,emailTextfield ;
    JButton next;
    JRadioButton male,female,married,unmarried;
    JDateChooser datechooser;
     SignupOne()
     {
         setLayout(null);
         Random ran=new Random();
         random=Math.abs((ran.nextLong() % 900L)+1000L);
         
         
         JLabel formno=new JLabel("APPLICATION FORM NO: "+random);
         formno.setFont(new Font("Railway",Font.BOLD,38));
         formno.setBounds(140,20, 600,40);
         add(formno);
         
         JLabel personDetails=new JLabel("PAGE 1: Personal Details ");
         personDetails.setFont(new Font("Railway",Font.BOLD,22));
         personDetails.setBounds(290,80, 400,30);
         add(personDetails);
         
          
         JLabel name=new JLabel("NAME: ");
         name.setFont(new Font("Railway",Font.BOLD,21));
         name.setBounds(100,140, 100,30);
         add(name);
         
         nameTextfield =new JTextField();
         nameTextfield.setFont((new Font("Railway",Font.BOLD,20)));
         nameTextfield.setBounds(300, 140, 400, 30);
         add(nameTextfield);
          
         JLabel fname=new JLabel("Father's Name: ");
         fname.setFont(new Font("Railway",Font.BOLD,21));
         fname.setBounds(100,190, 200,30);
         add(fname);
         
         fTextfield =new JTextField();
         fTextfield.setFont((new Font("Railway",Font.BOLD,20)));
         fTextfield.setBounds(300, 190, 400, 30);
         add(fTextfield);
         
          
         JLabel dob=new JLabel("DATE OF BIRTH: ");
         dob.setFont(new Font("Railway",Font.BOLD,19));
         dob.setBounds(100,240, 200,30);
         add(dob);
         
         datechooser=new JDateChooser();
         datechooser.setBounds(300, 240, 400, 30);
         datechooser.setForeground(new Color(105,105,105));
         add(datechooser);
         
         JLabel gender=new JLabel("Gender: ");
         gender.setFont(new Font("Railway",Font.BOLD,21));
         gender.setBounds(100,290, 200,30);
         add(gender);
         
         male=new JRadioButton("Male:");
         male.setBounds(300, 290, 60, 30);
         male.setBackground(Color.white);
         add(male);
         
          female=new JRadioButton("Female:");
         female.setBounds(450, 290, 120, 30);
         female.setBackground(Color.white);
         add(female);
         
         ButtonGroup gendergroup=new ButtonGroup();
         gendergroup.add(male);
         gendergroup.add(female);
        
         
         JLabel email=new JLabel("EMAIL ADDRESS: ");
         email.setFont(new Font("Railway",Font.BOLD,19));
         email.setBounds(100,340, 200,30);
         add(email);
         
         emailTextfield =new JTextField();
         emailTextfield.setFont((new Font("Railway",Font.BOLD,18)));
         emailTextfield.setBounds(300, 340, 400, 30);
         add(emailTextfield);
         
         JLabel marital=new JLabel("Marital Status: ");
         marital.setFont(new Font("Railway",Font.BOLD,21));
         marital.setBounds(100,390, 200,30);
         add(marital);
         
         married=new JRadioButton("Married:");
         married.setBounds(300, 390, 100, 30);
         married.setBackground(Color.white);
         add(married);
         
          unmarried=new JRadioButton("Unmarried:");
         unmarried.setBounds(450, 390, 100, 30);
         unmarried.setBackground(Color.white);
         add(unmarried);
         
         ButtonGroup marritalgroup=new ButtonGroup();
         marritalgroup.add(married);
         marritalgroup.add(unmarried);
         
         JLabel address=new JLabel("Address: ");
         address.setFont(new Font("Railway",Font.BOLD,21));
         address.setBounds(100,440, 200,30);
         add(address);
         
         
         addressTextfield =new JTextField();
         addressTextfield.setFont((new Font("Railway",Font.BOLD,20)));
         addressTextfield.setBounds(300, 440, 400, 30);
         add(addressTextfield);
         
         JLabel city=new JLabel("City: ");
         city.setFont(new Font("Railway",Font.BOLD,21));
         city.setBounds(100,490, 200,30);
         add(city);
         
          cityTextfield =new JTextField();
         cityTextfield.setFont((new Font("Railway",Font.BOLD,20)));
         cityTextfield.setBounds(300, 490, 400, 30);
         add(cityTextfield);
         
         JLabel state=new JLabel("State: ");
         state.setFont(new Font("Railway",Font.BOLD,21));
         state.setBounds(100,540, 200,30);
         add(state);
         
         
          stateTextfield =new JTextField();
         stateTextfield.setFont((new Font("Railway",Font.BOLD,20)));
         stateTextfield.setBounds(300, 540, 400, 30);
         add(stateTextfield);
         
         JLabel pin=new JLabel("Pin Code: ");
         pin.setFont(new Font("Railway",Font.BOLD,21));
         pin.setBounds(100,590, 200,30);
         add(pin);
         
          pinTextfield =new JTextField();
         pinTextfield.setFont((new Font("Railway",Font.BOLD,20)));
         pinTextfield.setBounds(300, 590, 400, 30);
         add(pinTextfield);
         
         next=new JButton("Next");
         next.setBackground(Color.BLACK);
         next.setForeground(Color.white);
         next.setFont((new Font("Railway",Font.BOLD,14)));
         next.setBounds(620, 660,80,30);
         next.addActionListener(this);
         add(next);
         
         getContentPane().setBackground(Color.WHITE);
         setSize(850,800);
         setLocation(350,10);
         setVisible(true);
     }
     
     public void actionPerformed(ActionEvent ae)
     {
       String formno=""+random;//conversion to long
       String name=nameTextfield.getText();
       String fname= fTextfield.getText();
       String dob=((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
       String gender=null;
       if(male.isSelected())
       {
           gender="Male";
       }
       else if(female.isSelected())
       {
           gender="Female";
       }
       String email=emailTextfield.getText();
       String marital=null;
        if(married.isSelected())
       {
           marital="Married";
       }
        else if(unmarried.isSelected())
       {
           marital="Unmarried";
       }
      String address=addressTextfield.getText();
      String city=cityTextfield.getText();
      String state=stateTextfield.getText();
      String pin=pinTextfield.getText();
      
        try
        {
           if(name.equals("")||fname.equals("")||email.equals("")||address.equals("")||pin.equals("")||city.equals("")||state.equals(""))
            {  
             JOptionPane.showMessageDialog(null, "Please Fill All The Fields");
            }
          
           else if(!male.isSelected()&&!female.isSelected()&&!married.isSelected()&&!unmarried.isSelected())
             {
                JOptionPane.showMessageDialog(null, "Please choose Gender And Marital Status");
             }
           else
             {
                 Conn c=new Conn();
               String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
              c.s.executeUpdate(query);
                 setVisible(false);
                 new SignupTwo(formno).setVisible(true);
             }
     }catch(Exception e)
     {
         System.out.println(e);
     }
  }
   
    public static void main(String args[]) {
        new SignupOne();
    }
}
