package com.company;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.*;
import com.toedter.calendar.JDateChooser;







public class SignUp2 extends JFrame implements ActionListener {
    JTextField panTextfield,aadharTextfield;
    ;
    JRadioButton  sno,syes,accountYes,accountNo;

    JButton next;

    JComboBox religion,occu,income,edu,cat;
    String formno=null;

    SignUp2(String formno ){
        this.formno=formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE NO.2 ");

        JLabel additionalDetails=new JLabel("Page 2: additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,50,600,30);
        add(additionalDetails);
        JLabel name=new JLabel("Religion :");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,100,100,30);
        add(name);
        String vals[]={"Hindu","Muslim","Sikh","Buddha","Humanity","Christian","others"};
        religion=new JComboBox(vals);

        religion.setBounds(300,100,400,30);
        religion.setBackground(Color.white);
        add(religion);
        JLabel fname=new JLabel("category :");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,150,200,30);
        add(fname);
        String valCat[]={"OBC","ST","SC","NT","OTHERS"};
         cat=new JComboBox(valCat);
        cat.setBackground(Color.WHITE);
        cat.setBounds(300,150,400,30);
        add(cat);
        JLabel dob=new JLabel("Income :");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,200,200,30);
        add(dob);
        String valIncome[]={"NULL","<1,50,000","<2,50,00","<5,00,00","upto 10,00,000"};

         income=new JComboBox(valIncome);

        income.setBounds(300,200,400,30);
        income.setBackground(Color.white);
        add(income);
        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,270,200,30);
        add(gender);


        JLabel email=new JLabel("Qualification :");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,300,200,30);
        add(email);

        String valEdu[]={"Non-Graduate","Graduate","DOctrate","others","POST Graduate"};
        edu=new JComboBox(valEdu);
        edu.setBounds(300,300,400,30);
        edu.setBackground(Color.WHITE);
        add(edu);
        JLabel marital =new JLabel("Occupation :");
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        marital.setBounds(100,380,200,30);
        add(marital);
        String valOccu[]={"salaried","self-employed","Business","Student","others"};
         occu=new JComboBox(valOccu);
        occu.setBounds(300,380,400,30);
        occu.setBackground(Color.WHITE);
        add(occu);





        JLabel address =new JLabel("PAN no :");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,430,200,30);
        add(address);
        panTextfield=new JTextField();
        panTextfield.setFont(new Font("Arial",Font.BOLD,14));
        panTextfield.setBounds(300,430,400,30);
        add(panTextfield);
        JLabel city =new JLabel("Aadhar no:");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,480,200,30);
        add(city);
        aadharTextfield=new JTextField();
        aadharTextfield.setFont(new Font("Arial",Font.BOLD,14));
        aadharTextfield.setBounds(300,480,400,30);
        add(aadharTextfield);

        JLabel state =new JLabel("Senior citizen :");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,530,200,20);
        add(state);
        syes=new JRadioButton("Yes");
        syes.setBounds(300,530,60,20);
        syes.setBackground(Color.white);
        add(syes);
        sno=new JRadioButton("No");
        sno.setBounds(450,530,80,20);
        sno.setBackground(Color.white);
        add( sno);
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add( syes);
        genderGroup.add( sno);

        JLabel pincode =new JLabel("Existing account :");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,570,200,30);
        add(pincode);
        accountYes=new JRadioButton("Yes");
        accountYes.setBounds(300,570,60,30);
        accountYes.setBackground(Color.white);
        add(accountYes);
        accountNo=new JRadioButton("No");
        accountNo.setBounds(450,570,80,30);
        accountNo.setBackground(Color.white);
        add(accountNo);
        ButtonGroup Group=new ButtonGroup();
        Group.add(accountYes);
        Group.add(accountNo);


        next=new JButton("next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setBounds(6,6,80,30);
        next.addActionListener(this);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);
        setSize(850,600);
        setVisible(true);
        setLocation(1,1);





    }
    public void actionPerformed(ActionEvent ae){

        String seniorCitizen=null;
        String sreligion=(String)religion.getSelectedItem();
        String scat=(String)cat.getSelectedItem();
        String sedu=(String)edu.getSelectedItem();
        String soccu=(String)occu.getSelectedItem();
        String sincome=(String)income.getSelectedItem();

        if(syes.isSelected()){
            seniorCitizen="yes";
        }
        else if(sno.isSelected()){
           seniorCitizen="no";
        }

        String existingAccount=null;
        if(accountYes.isSelected()){
            existingAccount="yes";
        }
        else if(accountNo.isSelected()){
            existingAccount="no";
        }
        String span=panTextfield.getText();
        String saadhar=aadharTextfield.getText();



        try{

                Conn c =new Conn();
                String q1="insert into signupTwo value ('"+formno+"','"+sreligion+"','"+scat+"','"+sedu+"','"+soccu+"','"+sincome+"','"+span+"','"+saadhar+"','"+seniorCitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(q1);
                setVisible(false);
                new SignUp3(formno).setVisible(true);



        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String args[]){
        System.out.println("hello");
        new SignUp2("");
    }
}
