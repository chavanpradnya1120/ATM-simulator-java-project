package com.company;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MiniStatement extends JFrame {
    String pinNumber;
    Connection connection;
    MiniStatement(String pinNumber){
        this.pinNumber=pinNumber;
        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,100);
        add(mini);
        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(100,20,100,20);
        add(bank);
        JLabel card=new JLabel("card number");
        card.setBounds(20,100,300,20);
        add(card);
        JLabel balance=new JLabel();
        balance.setBounds(20,500,400,30);
        add(balance);


        try{
            Conn c=new Conn();
           //Resultset rs= (Resultset) c.s.executeQuery("select * from login where pin='"+pinNumber+"'" );

            connection= DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","9421521270");

            Statement stmt = connection.createStatement();
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM login " );
            System.out.println(rs1);
            while (rs1.next()){
                card.setText("card number is "+ rs1.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs1.getString("cardNumber").substring(12));

            }
           // ResultSet rs = stmt.executeQuery("SELECT * FROM login WHERE pinNumber='" + pinNumber + "'");


        }
        catch (Exception e){
            System.out.println(e);
        }
        try{
            connection= DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","9421521270");

            Statement stmt = connection.createStatement();
           // ResultSet rs1 = stmt.executeQuery("SELECT * FROM bank " );
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM bank WHERE type = 'Deposit' or type='withdrawl'");
            int bal=0;
            if (!rs1.next()) {
                System.out.println("No records found for pinNumber=" + pinNumber);
            }
            while (rs1.next()){
                mini.setText(mini.getText()+"<html>"+rs1.getString("date")+" "+rs1.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+rs1.getString("amount")+"<br><br><html>  ");
                String name = rs1.getString("amount");
                if(rs1.getString("type").equals("withdrawl"))
                    bal-=Integer.parseInt(name);

                else
                    bal+=Integer.parseInt(name);
                //System.out.println("Your current balance is "+bal);
            }
            balance.setText("Your current balance is "+bal);
        }
        catch (Exception e){
            System.out.println(e);
        }
        setLayout(null);
        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String args[]){
        new MiniStatement("");
    }
}
