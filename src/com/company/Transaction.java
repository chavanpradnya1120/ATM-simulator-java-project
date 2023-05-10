package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinNumber;
    Transaction(String pinNumber){
        this.pinNumber=pinNumber;
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("com/company/icons/atm.jpg"));
        Image i2=imageIcon.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel l=new JLabel("please enter new transaction ");
        l.setBounds(200,200,400,30);
        l.setForeground(Color.white);
        l.setFont(new Font("raleway",Font.BOLD,16));
        image.add(l);
         b1=new JButton("Deposit");
        b1.setBounds(150,315,150,25);
        image.add(b1);
        b1.addActionListener(this);
         b2=new JButton("Cash Withdraw");
        b2.setBounds(350,315,150,25);
        image.add(b2);
        b2.addActionListener(this);
         b3=new JButton("Fast Cash");
        b3.setBounds(150,350,150,25);
        image.add(b3);
        b3.addActionListener(this);
         b4=new JButton("Mini Statement");
        b4.setBounds(350,350,150,25);
        image.add(b4);
        b4.addActionListener(this);
         b5=new JButton("PIN Change");
        b5.setBounds(150,385,150,25);
        image.add(b5);
        b5.addActionListener(this);
        b6=new JButton("Balance Enquiry");
        b6.setBounds(350,385,150,25);
        image.add(b6);
        b6.addActionListener(this);
         b7=new JButton("EXIT");
        b7.setBounds(250,420,150,25);
        image.add(b7);
        b7.addActionListener(this);


       //setUndecorated(true);
       setSize(900,900);
       setLocation(300,0);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
       if(e.getSource()==b7){
           System.exit(0);
       }
       else if(e.getSource()==b1){
           setVisible(false);
           new Deposit(pinNumber).setVisible(true);

       }
       else if(e.getSource()==b2){
           setVisible(false);
           new Withdrawl(pinNumber).setVisible(true);

       }
       else if(e.getSource()==b3){
           setVisible(false);
           new FastCash(pinNumber).setVisible(true);
       }
       else if(e.getSource()==b5){
           setVisible(false);
           new PinChange(pinNumber).setVisible(true);
       }
       else if(e.getSource()==b6){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
       }
       else if(e.getSource()==b4){

          //setVisible(false);
          new MiniStatement(pinNumber).setVisible(true);
       }


    }
    public static void main(String args[]){
        new Transaction("");

    }
}
