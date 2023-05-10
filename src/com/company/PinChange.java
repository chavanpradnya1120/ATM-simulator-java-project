package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    String pinNumber;
    JButton back,change;
    JPasswordField pin,repin;
    PinChange(String pinNumber){
        this.pinNumber=pinNumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("com/company/icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setBounds(200,200,200,25);
        image.add(text);
        JLabel pintext=new JLabel("New PIN :");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("system",Font.BOLD,16));
        pintext.setBounds(170,235,100,25);
        image.add(pintext);
        pin=new JPasswordField();
        pin.setFont(new Font("raleway",Font.BOLD,25));
        pin.setBounds(320,235,180,25);
        image.add(pin);
        JLabel repintext=new JLabel("Re-Enter New PIN:");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("system",Font.BOLD,16));
        repintext.setBounds(170,270,220,25);
        image.add(repintext);
        repin=new JPasswordField();
        repin.setFont(new Font("raleway",Font.BOLD,25));
        repin.setBounds(320,270,180,25);
        image.add(repin);
        change=new JButton("CHANGE");
        change.setBounds(380,380,100,30);
        image.add(change);
        change.addActionListener(this);
         back=new JButton("BACK");
        back.setBounds(380,420,100,30);
        image.add(back);
        back.addActionListener(this);

        setVisible(true);
        setSize(900,900);
        setLocation(300,0);

    }
    public void actionPerformed(ActionEvent ae){

      if(ae.getSource()==change){
          try{
              String npin=pin.getText();
              String nrepin=repin.getText();
              if(!npin.equals(nrepin)){
                  JOptionPane.showMessageDialog(null,"Entered PIN does not matched");
                  return;
              }
              if(npin.equals("")){
                  JOptionPane.showMessageDialog(null,"Please Enter PIN ");
                  return;
              }
              if(nrepin.equals("")){
                  JOptionPane.showMessageDialog(null,"Please Enter Re-PIN ");
                  return;
              }
              Conn c=new Conn();
              String query="update bank set pin='"+nrepin+"'where pin='"+pinNumber+"'";
              String query1="update login set pinNumber='"+nrepin+"' where pinNumber='"+pinNumber+"'";
              String query2="update signup3 set pinNumber='"+nrepin+"'where pinNumber='"+pinNumber+"'";
              c.s.executeUpdate(query);
              c.s.executeUpdate(query1);
              c.s.executeUpdate(query2);
              JOptionPane.showMessageDialog(null,"PIN changed successfully");
              setVisible(false);
              new Transaction(pinNumber).setVisible(true);


          }
          catch (Exception e){

          }
      }
      else {
          setVisible(false);
          new Transaction(pinNumber).setVisible(true);
      }


    }
    public static void main(String args[]){

        new PinChange("").setVisible(true);
    }
}
