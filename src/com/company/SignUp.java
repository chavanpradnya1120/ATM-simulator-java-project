package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.*;
import com.toedter.calendar.JDateChooser;







public class SignUp extends JFrame implements ActionListener {
  JTextField nameTextfield,fnameTextfield,emailTextfield,addressTextfield,cityTextfield,stateTextfield,pincodeTextfield;
  ;
  JRadioButton female,male,unmarried,married,others;
  JDateChooser dateChooser;
  JButton next;
    Long random;

    SignUp(){
        setLayout(null);
        Random r=new Random();
       random= Math.abs(r.nextLong()%9000L)+1000L;
        JLabel formNo=new JLabel("APLICATION FORM NO :"+random);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        formNo.setBounds(140,10,600,30);
        add(formNo);
        JLabel personalDetails=new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,50,600,30);
        add(personalDetails);
        JLabel name=new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,100,100,30);
        add(name);
         nameTextfield=new JTextField();
        nameTextfield.setFont(new Font("Arial",Font.BOLD,14));
        nameTextfield.setBounds(300,100,400,30);
        add(nameTextfield);
        JLabel fname=new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,150,200,30);
        add(fname);
         fnameTextfield=new JTextField();
        fnameTextfield.setFont(new Font("Arial",Font.BOLD,14));
        fnameTextfield.setBounds(300,150,400,30);
        add(fnameTextfield);
        JLabel dob=new JLabel("Date Of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,200,200,30);
        add(dob);
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,200,400,30);
        dateChooser.setForeground(new Color(150,150,150));
        add(dateChooser);
        JLabel gender=new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,270,200,30);
        add(gender);
        male=new JRadioButton("Male");
        male.setBounds(300,270,60,20);
        male.setBackground(Color.white);
        add(male);
       female=new JRadioButton("female");
        female.setBounds(450,270,80,20);
        female.setBackground(Color.white);
        add(female);
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,320,200,30);
        add(email);
        emailTextfield=new JTextField();
        emailTextfield.setFont(new Font("Arial",Font.BOLD,14));
        emailTextfield.setBounds(300,320,400,30);
        add(emailTextfield);
        JLabel marital =new JLabel("Marital status :");
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        marital.setBounds(100,380,200,30);
        add(marital);
     married=new JRadioButton("Married");
      married.setBounds(300,380,80,30);
      married.setBackground(Color.white);
      add(married);
     unmarried=new JRadioButton("Unmarried");
      unmarried.setBounds(400,380,100,30);
      unmarried.setBackground(Color.white);
      add(unmarried);
       others=new JRadioButton("Others");
      others.setBounds(520,380,80,20);
      others.setBackground(Color.white);
      add(others);

      ButtonGroup maritalGroup=new ButtonGroup();
      maritalGroup.add(married);
      maritalGroup.add(unmarried);

      maritalGroup.add(others);
        JLabel address =new JLabel("Address :");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,430,200,30);
        add(address);
        addressTextfield=new JTextField();
        addressTextfield.setFont(new Font("Arial",Font.BOLD,14));
        addressTextfield.setBounds(300,430,400,30);
        add(addressTextfield);
        JLabel city =new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,480,200,30);
        add(city);
      cityTextfield=new JTextField();
        cityTextfield.setFont(new Font("Arial",Font.BOLD,14));
        cityTextfield.setBounds(300,480,400,30);
        add(cityTextfield);

        JLabel state =new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,530,200,20);
        add(state);
        stateTextfield=new JTextField();
        stateTextfield.setFont(new Font("Arial",Font.BOLD,14));
        stateTextfield.setBounds(300,530,400,30);
        add(stateTextfield);

        JLabel pincode =new JLabel("Pincode :");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,570,200,30);
        add(pincode);
       pincodeTextfield=new JTextField();
        pincodeTextfield.setFont(new Font("Arial",Font.BOLD,14));
        pincodeTextfield.setBounds(300,570,400,30);
        add(pincodeTextfield);
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
        String formno =""+random;
        String name=nameTextfield.getText();
        String fname=fnameTextfield.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="male";
        }
        else if(female.isSelected()){
            gender="female";
        }
        String email=emailTextfield.getText();
        String marital=null;
        if(married.isSelected()){
            marital="married";
        }
        else if(unmarried.isSelected()){
            marital="unmarried";
        }
        else{
            marital="others";
        }
        String address=addressTextfield.getText();
        String city=cityTextfield.getText();
        String pincode=pincodeTextfield.getText();
        String state=stateTextfield.getText();
        try{
            if(name.equals("")){
                  JOptionPane.showMessageDialog(null,"Name is required");
            }
            else{
              Conn c =new Conn();
              String q1="insert into signup value ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c.s.executeUpdate(q1);
                setVisible(true);
                new SignUp2(formno).setVisible(true);

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String args[]){
        System.out.println("hello");
        new SignUp();
    }
}
