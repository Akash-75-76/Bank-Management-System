
package bank.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo  extends JFrame implements ActionListener
{
   
    JTextField  MTextfield,panTextfield,aadharTextfield;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    String formno;
    JComboBox religion,occupation,education,income;
 
     SignupTwo(String formno)
     {
         this.formno=formno;
         setLayout(null);
         setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");
         
         JLabel additionalDetails=new JLabel("PAGE 2: Additional  Details ");
         additionalDetails.setFont(new Font("Railway",Font.BOLD,22));
         additionalDetails.setBounds(290,80, 400,30);
         add(additionalDetails);
         
          
         JLabel name=new JLabel("Religion: ");
         name.setFont(new Font("Railway",Font.BOLD,21));
         name.setBounds(100,140, 100,30);
         add(name);
         
         
         String valRegion[]={"Hindu","Muslim","Sikh","Christian","Other"};
         religion=new JComboBox(valRegion);
         religion.setBounds(300, 140, 400, 30);
         religion.setBackground(Color.white);
         add(religion);
         
        // nameTextfield =new JTextField();
         //nameTextfield.setFont((new Font("Railway",Font.BOLD,20)));
         //nameTextfield.setBounds(300, 140, 400, 30);
         //add(nameTextfield);
          
         JLabel fname=new JLabel("Mobile No: ");
         fname.setFont(new Font("Railway",Font.BOLD,21));
         fname.setBounds(100,190, 200,30);
         add(fname);
         
         
         MTextfield =new JTextField();
         MTextfield.setFont((new Font("Railway",Font.BOLD,20)));
         MTextfield.setBounds(300, 190, 400, 30);
         add(MTextfield);
         
          
         JLabel dob=new JLabel("Income: ");
         dob.setFont(new Font("Railway",Font.BOLD,19));
         dob.setBounds(100,260, 200,30);
         add(dob);
         
         
          
         String valincome[]={"Null","1000-99999","100000-499999","500000-800000","Above 800000"};
         income=new JComboBox(valincome);
         income.setBounds(300, 260, 400, 30);
         income.setBackground(Color.white);
         add(income);
         
         
       
     
         
         JLabel email=new JLabel("Qualification: ");
         email.setFont(new Font("Railway",Font.BOLD,19));
         email.setBounds(100,325, 200,30);
         add(email);
         
             
         String ed[]={"Non-Graduate","Graduate","Post-Graduate","Docterate","Others"};
         education=new JComboBox(ed);
         education.setBounds(300, 325, 400, 30);
         education.setBackground(Color.white);
         add(education);
         
      
         
         JLabel marital=new JLabel("Occupation: ");
         marital.setFont(new Font("Railway",Font.BOLD,21));
         marital.setBounds(100,390, 200,30);
         add(marital);
         
             
         String occ[]={"Salaried","Self-Employeed","Student","Buzinessman","Retired","None"};
         occupation=new JComboBox(occ);
         occupation.setBounds(300, 390, 400, 30);
         occupation.setBackground(Color.white);
         add(occupation);
         
         
         JLabel pan=new JLabel("Pan NO: ");
         pan.setFont(new Font("Railway",Font.BOLD,21));
         pan.setBounds(100,440, 200,30);
         add(pan);
         
         
         panTextfield =new JTextField();
         panTextfield.setFont((new Font("Railway",Font.BOLD,20)));
         panTextfield.setBounds(300, 440, 400, 30);
         add(panTextfield);
         
         JLabel aadhar=new JLabel("Aadhar NO: ");
         aadhar.setFont(new Font("Railway",Font.BOLD,21));
         aadhar.setBounds(100,490, 200,30);
         add(aadhar);
         
         aadharTextfield =new JTextField();
         aadharTextfield.setFont((new Font("Railway",Font.BOLD,20)));
         aadharTextfield.setBounds(300, 490, 400, 30);
         add(aadharTextfield);
         
         JLabel state=new JLabel("Senior Citizen: ");
         state.setFont(new Font("Railway",Font.BOLD,21));
         state.setBounds(100,540, 200,30);
         add(state);
         
         
        syes =new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno =new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup st=new ButtonGroup();
        st.add(syes);
        st.add(sno);
        
         JLabel pin=new JLabel("Existing Account: ");
         pin.setFont(new Font("Railway",Font.BOLD,21));
         pin.setBounds(100,590, 200,30);
         add(pin);
         
        eyes =new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno =new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.white);
        add(eno);
        
        ButtonGroup e=new ButtonGroup();
        e.add(syes);
        e.add(sno);
         
        
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
      
       String sreligion=(String)religion.getSelectedItem();
       String mnumber=MTextfield.getText();
       String sincome=(String)income.getSelectedItem();
       String seducation=(String)education.getSelectedItem();
       String occpation=(String)education.getSelectedItem();
       String senior=null;
       if(syes.isSelected())
       {
           senior="Yes";
       }
       else if(sno.isSelected())
       {
           senior="No";
       }
   
       String account=null;
        if(eyes.isSelected())
       {
          account="Yes";
       }
        else if(eno.isSelected())
       {
           account="No";
       }
      String span=panTextfield.getText();
      String saadhar=aadharTextfield.getText();
     
        try
        {
           if(MTextfield.equals("")||panTextfield.equals("")||aadharTextfield.equals(""))
            {  
             JOptionPane.showMessageDialog(null, "Please Fill All The Fields");
            }
          
           else if(!syes.isSelected()&&!sno.isSelected()&&!eyes.isSelected()&&!eno.isSelected())
             {
                JOptionPane.showMessageDialog(null, "Please choose All fields");
             }
           else
             {
                 Conn c=new Conn();
               String query="insert into signupTwo values('"+formno+"','"+sreligion+"','"+mnumber+"','"+sincome+"','"+seducation+"','"+occpation+"','"+span+"','"+saadhar+"','"+senior+"','"+account+"')";
              c.s.executeUpdate(query);
              setVisible(false);
               new SignupThree(formno).setVisible(true);
             }
           
     }catch(Exception e)
     {
         System.out.println(e);
     }
  }
   
    public static void main(String args[]) {
        new SignupTwo("");
    }
}

