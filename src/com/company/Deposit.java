package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.jar.JarFile;

public class Deposit extends JFrame implements ActionListener {
    JButton deposit,back;
    String pinNumber;
    JTextField amount;
    Deposit(String pinNumber ){
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel l=new JLabel("Please enter amount you want to deposit ");
        l.setForeground(Color.white);
        l.setBounds(170,320,400,30);
        l.setFont(new Font("system",Font.BOLD,16));
        image.add(l);
        amount =new JTextField();
        amount.setFont(new Font("system",Font.BOLD,16));
        amount.setBounds(170,350,320,30);
        image.add(amount);
        deposit=new JButton("Deposit");
        deposit.setBounds(400,480,100,30);
        image.add(deposit);
        deposit.addActionListener(this);
        back=new JButton("Back");
        back.setBounds(400,520,100,30);
        back.addActionListener(this);

        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==deposit){
           String number=amount.getText();
           Date date=new Date();
           if(number.equals("")){
               JOptionPane.showMessageDialog(null,"Please enter amount you want to deposit");
           }
           else {
               Conn conn=new Conn();
               String query="insert into bank values('"+pinNumber+"','"+date+"','Deposit','"+number+"')";
               try{
                   conn.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null,"deposit Rs "+number+" successfully deposited");
                   setVisible(false);
                   new Transaction(pinNumber).setVisible(true);
               }
               catch (Exception ae){
                   System.out.println(ae);
               }

           }
        }
        else if(e.getSource()==back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    public static void main(String args[]){
       new Deposit("");
    }
}
