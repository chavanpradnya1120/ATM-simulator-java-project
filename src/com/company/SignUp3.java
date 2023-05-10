package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    Checkbox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno=null;
    SignUp3(String formno){
        this.formno=formno;
        setLayout(null);
        JLabel l=new JLabel("Page 3: Account's details");
        l.setFont(new Font("Raleway",Font.BOLD,22));
        l.setBounds(280,40,400,40);
        add(l);
        JLabel account=new JLabel(" Account type :");
        account.setFont(new Font("Raleway",Font.BOLD,22));
        account.setBounds(100,140,200,30);
        add(account);
        r1=new JRadioButton("Saving account :");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,250,20);
        add(r1);
        r2=new JRadioButton("Fixed deposit account :");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,180,300,20);
        add(r2);
        r3=new JRadioButton("current account :");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,220,250,20);
        add(r3);
        r4=new JRadioButton("reccuring deposit account :");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,220,350,20);
        add(r4);
        ButtonGroup groupAccount=new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);
        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4343");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,400,30);
        add(number);
        JLabel carddetail=new JLabel("Your 16 digits card no ");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,330,200,30);
        add(carddetail);

        JLabel pin=new JLabel("Pin Number:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,400,30);
        add(pnumber);
        JLabel pindetail=new JLabel("Your 4 digits card no ");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,400,200,30);
        add(pindetail);

        JLabel service_required=new JLabel("Service Required ");
        service_required.setFont(new Font("Raleway",Font.BOLD,18));
        service_required.setBounds(100,450,200,30);
        add(service_required);

        c1=new Checkbox("ATM CARD :");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,500,200,30);
        add(c1);
        c2=new Checkbox("Internet Banking :");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(350,500,200,30);
        add(c2);
        c3=new Checkbox("Mobile Banking :");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,550,200,30);
        add(c3);
        c4=new Checkbox("Emails and Sms Alerts:");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(350,550,200,30);
        add(c4);
        c5=new Checkbox("Check Book:");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,600,200,30);
        add(c5);
        c6=new Checkbox("E-statement:");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBackground(Color.WHITE);
        c6.setBounds(350,600,200,30);
        add(c6);
        c7=new Checkbox("Hereby declares that above entered details are correct to the best of  my best knowledge");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBackground(Color.WHITE);
        c7.setBounds(350,10,600,30);
        add(c7);
        submit=new JButton("submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,12));
        submit.setBounds(640,600,80,20);
        add(submit);
        cancel=new JButton("cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,12));
        cancel.setBounds(720,600,80,20);
        add(cancel);
        getContentPane().setBackground(Color.WHITE);
        submit.addActionListener(this);
        cancel.addActionListener(this);

        setSize(850,820);
        setLocation(350,350);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="saving account";
            }
            else if(r2.isSelected()){
                accountType="fixed deposit account";
            }
            else if(r3.isSelected()){
                accountType="current account";
            }
            else if(r4.isSelected()){
                accountType="recurring deposit account";
            }
            Random random=new Random();
            String cardNumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            String pinNumber=""+Math.abs((random.nextLong()%9000L)+1000L);
            String facility="";
            if(c1.isEnabled()){
                  facility=facility+"ATM CARD";
            }
            else if(c2.isEnabled()){
                facility=facility+"Internet Banking";
            }
            else if(c3.isEnabled()){
                facility=facility+"Mobile Banking";
            }
            else if(c4.isEnabled()){
                facility=facility+"Emails and Sms Alerts";
            }
            else if(c5.isEnabled()){
                facility=facility+"Check Book";
            }
            else if(c6.isEnabled()){
                facility=facility+"E-statement";
            }
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account's Type is required");
                }
                else{
                    Conn c=new Conn();
                    String query1="insert into signup3 values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";

                    String query2="insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number :"+cardNumber+"\n Pin :"+pinNumber);
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }

            }
            catch(Exception ae){
                System.out.println(ae);

            }



        }
        else if(e.getSource()==cancel){
            //System.exit(0);
            setVisible(false);
            new Main().setVisible(true);

        }

    }
    public static void main(String args[]){
        new SignUp3("").setVisible(true);
    }
}
