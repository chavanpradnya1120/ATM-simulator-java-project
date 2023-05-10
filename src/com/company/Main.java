package com.company;
import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Main extends JFrame implements ActionListener {
    JButton login,clear,signup;
    JTextField cardTextfield;
    JPasswordField pinTextField;

    Main(){


            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/icons/logo.jpg"));
            Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel l=new JLabel(i3);
            add(l);
            l.setBounds(70,10,100,100);
            getContentPane().setBackground(Color.white);
            JLabel text=new JLabel("Welcom to ATM");
            text.setFont(new Font("osward",Font.BOLD,38));
            text.setBounds(200,40,400,40);
            add(text);
        JLabel cardNo=new JLabel("Card No :");
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        cardNo.setBounds(120,120,150,30);
        add(cardNo);
         cardTextfield=new JTextField();
        cardTextfield.setBounds(300,120,230,30);
        cardTextfield.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextfield);

        JLabel pin=new JLabel("PIN No:");

        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,200,150,30);

        add(pin);
         pinTextField=new JPasswordField();
        pinTextField.setBounds(300,200,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        login=new JButton("SIGN IN");
        login.setBounds(300,270,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
         clear=new JButton("CLEAR");
        clear.setBounds(430,270,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
         signup=new JButton("SIGN UP");
        signup.setBounds(300,330,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);


        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800,600);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ac){
       if(ac.getSource()==clear){
            cardTextfield.setText("");
            pinTextField.setText("");
       }
       else if(ac.getSource()==signup){

            setVisible(false);
            new SignUp().setVisible(true);
       }
       else if(ac.getSource()==login){
            Conn c=new Conn();
            String cardNumber=cardTextfield.getText();
            String pinNumber=pinTextField.getText();
            String query="select * from login where cardNumber = '"+cardNumber+"' and pinNumber='"+pinNumber+"'";
            try {
                //Resultset rs=c.s.executeQuery(query);
                java.sql.ResultSet rs = c.s.executeQuery(query);// some code to get the ResultSet
                com.mysql.cj.protocol.Resultset resultset = (com.mysql.cj.protocol.Resultset) rs;
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect card number or pin ");
                }

            }
            catch (Exception e){
                System.out.println(e);
            }
       }
    }
    public static void main(String[] args) {
	// write your code here
        new Main();

    }
}
