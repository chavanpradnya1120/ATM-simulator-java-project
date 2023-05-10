package com.company;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinNumber;
    Connection connection;
    FastCash(String pinNumber){
        this.pinNumber=pinNumber;
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("com/company/icons/atm.jpg"));
        Image i2=imageIcon.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel l=new JLabel("please select the withdrawl amount   ");
        l.setBounds(200,200,400,30);
        l.setForeground(Color.white);
        l.setFont(new Font("raleway",Font.BOLD,16));
        image.add(l);
        b1=new JButton("Rs 100");
        b1.setBounds(150,315,150,25);
        image.add(b1);
        b1.addActionListener(this);
        b2=new JButton("Rs 500");
        b2.setBounds(350,315,150,25);
        image.add(b2);
        b2.addActionListener(this);
        b3=new JButton("Rs 1000");
        b3.setBounds(150,350,150,25);
        image.add(b3);
        b3.addActionListener(this);
        b4=new JButton("Rs 2000");
        b4.setBounds(350,350,150,25);
        image.add(b4);
        b4.addActionListener(this);
        b5=new JButton("Rs 5000");
        b5.setBounds(150,385,150,25);
        image.add(b5);
        b5.addActionListener(this);
        b6=new JButton("Rs 10000");
        b6.setBounds(350,385,150,25);
        image.add(b6);
        b6.addActionListener(this);
        b7=new JButton("Back");
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
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
        else {
            String amount1=((JButton)e.getSource()).getText().substring(3);
            System.out.println("amount is "+amount1+" and pin  "+pinNumber);
            System.out.println();
            Conn c=new Conn();
            try{
               // Resultset rs=c.s.executeQuery("select * from bank where pin='"+pinNumber+"'");
                ResultSet rs =c.s.executeQuery("select * from bank where pin='"+pinNumber+"'");
               // String query1 = "SELECT SUM(amount) FROM bank WHERE type = 'Deposit'";
                connection=DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","9421521270");

                Statement stmt = connection.createStatement();
                ResultSet rs1 = stmt.executeQuery("SELECT amount,type FROM bank WHERE type = 'Deposit' or type='withdrawl'");
                int sum=0;
                try {
                    int rowCount = 0;
                    while (rs1.next() && rowCount < 100) {
                        String name = rs1.getString("amount");
                        if(rs1.getString("type").equals("withdrawl"))
                           sum-=Integer.parseInt(name);

                        else
                            sum=sum+Integer.parseInt(name);
                        System.out.println("sum is "+sum+" for the iteration "+rowCount);

                        rowCount++;
                    }
                   /* if (rs1.next()) {

                        System.out.println("Sum of deposit amount: " + sum);
                    } else {
                        System.out.println("No matching rows found.");
                    }*/
                }
                catch (Exception ae){
                    System.out.println(ae);
                }


                int balance=(int)sum;
                if (!rs.next()) {
                    // handle empty ResultSet
                    System.out.println("No rows returned.");
                }


                if(e.getSource()!=b7 && balance< Integer.parseInt(amount1)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query="insert into bank values('"+pinNumber+"','"+date+"','withdrawl', '"+amount1+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"RS "+amount1+" Debited successfully");
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }
            catch (Exception ae){
                System.out.println(ae);
            }

        }

    }
    public static void main(String args[]){
        new FastCash("");

    }
}

