package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinNumber;
    JButton back;
    Connection connection;
    BalanceEnquiry(String pinNumber){
        this.pinNumber=pinNumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        back=new JButton("Back");
        back.setBounds(400,420,110,30);
        image.add(back);
        back.addActionListener(this);
        //ResultSet rs =c.s.executeQuery("select * from bank where pin='"+pinNumber+"'");
        // String query1 = "SELECT SUM(amount) FROM bank WHERE type = 'Deposit'";
        int sum = 0;
        try {
            connection = DriverManager.getConnection("jdbc:mysql:///bankmanagement", "root", "9421521270");

            Statement stmt = connection.createStatement();
            ResultSet rs1 = stmt.executeQuery("SELECT amount,type FROM bank WHERE type = 'Deposit' or type='withdrawl'");

            try {

                while (rs1.next() ) {
                    String name = rs1.getString("amount");
                    if (rs1.getString("type").equals("withdrawl"))
                        sum -= Integer.parseInt(name);

                    else
                        sum = sum + Integer.parseInt(name);
                    System.out.println("sum is " + sum + " for the iteration "  );


                }
                   /* if (rs1.next()) {

                        System.out.println("Sum of deposit amount: " + sum);
                    } else {
                        System.out.println("No matching rows found.");
                    }*/
            } catch (Exception ae) {
                System.out.println(ae);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        JLabel text=new JLabel("Your current account balance is "+sum);
        text.setForeground(Color.white);
        text.setBounds(170,200,300,30);
        image.add(text);


          setVisible(true);
          setSize(900,900);
          setLocation(300,0);
    }
    public  void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinNumber).setVisible(true);

    }
    public static void main(String args[]){
        new BalanceEnquiry("");

    }
}
