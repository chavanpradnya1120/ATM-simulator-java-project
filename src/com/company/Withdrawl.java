package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.jar.JarFile;

public class Withdrawl extends JFrame implements ActionListener {
    JButton withdraw,back;
    String pinNumber;
    JTextField amount;
    Connection connection;
    Withdrawl (String pinNumber ){
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel l=new JLabel("Please enter amount you want to withdraw ");
        l.setForeground(Color.white);
        l.setBounds(170,320,400,30);
        l.setFont(new Font("system",Font.BOLD,16));
        image.add(l);
        amount =new JTextField();
        amount.setFont(new Font("system",Font.BOLD,16));
        amount.setBounds(170,350,320,30);
        image.add(amount);
        withdraw=new JButton("withdraw");
        withdraw.setBounds(400,480,100,30);
        image.add(withdraw);
        withdraw.addActionListener(this);
        back=new JButton("Back");
        back.setBounds(400,520,100,30);
        back.addActionListener(this);

        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==withdraw){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter amount you want to withdraw");
            }
            else {
                Conn conn=new Conn();
                String query="insert into bank values('"+pinNumber+"','"+date+"','withdrawl','"+number+"')";
                try{
                    connection= DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","9421521270");

                    Statement stmt = connection.createStatement();
                    ResultSet rs1 = stmt.executeQuery("SELECT amount,type FROM bank WHERE type = 'Deposit' or type='withdrawl'");
                    int sum=0;
                    try {

                        while (rs1.next() ) {
                            String name = rs1.getString("amount");
                            if(rs1.getString("type").equals("withdrawl") && sum>=Integer.parseInt(name))
                                sum-=Integer.parseInt(name);

                            else
                                sum=sum+Integer.parseInt(name);
                            System.out.println("sum is "+sum+" for the iteration ");


                        }

                    }
                    catch (Exception ae){
                        System.out.println(ae);
                    }
                    if(sum>Integer.parseInt(number)) {
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, " Rs " + number + " successfully withdraw");
                        setVisible(false);
                        new Transaction(pinNumber).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Sorry,your balance is "+sum);
                        setVisible(false);
                        new Transaction(pinNumber).setVisible(true);
                    }
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

        new Withdrawl ("");
    }
}


