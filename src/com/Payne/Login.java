package com.Payne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login implements ActionListener {

    ImageIcon logo100 = new ImageIcon("translogo100.png");
    JFrame frame = new JFrame();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel labelUser = new JLabel();
    JLabel labelPass = new JLabel();
    JButton buttonForgot = new JButton();
    JButton buttonCreate = new JButton();
    JButton buttonLogin = new JButton();
    JTextField textFieldUser = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    //ImageIcon logo50 = new ImageIcon("logo50.png");

    Login(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(logo100.getImage());
        frame.setTitle("PAYNE");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);

        panel1.setBounds(0,0,250,500);
        panel1.setBackground(new Color(26,26,26));
        panel1.setLayout(null);
        panel1.add(label1);
        panel1.add(buttonCreate);
        panel1.add(buttonForgot);

        panel2.setBounds(250,0,550,500);
        panel2.setBackground(new Color(26,34,40));
        panel2.setLayout(null);
        panel2.add(label2);
        panel2.add(labelUser);
        panel2.add(textFieldUser);
        panel2.add(labelPass);
        panel2.add(passwordField);
        panel2.add(buttonLogin);

        label1.setIcon(logo100);
        label1.setText("fast & safe for transaction");
        label1.setForeground(Color.WHITE);
        label1.setBounds(50,25,200,200);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.BOTTOM);

        label2.setText("WELCOME BACK!");
        label2.setFont(new Font("Archivo Black",Font.PLAIN,30));
        label2.setForeground(Color.WHITE);
        label2.setBounds(125,50,300,50);
        //label2.setHorizontalTextPosition(JLabel.CENTER);
        //label2.setVerticalTextPosition(JLabel.BOTTOM);

        labelUser.setText("User Name");
        labelUser.setForeground(Color.WHITE);
        labelUser.setBounds(150,80,300,150);
        textFieldUser.setBounds(150,170,200,30);

        labelPass.setText("Password");
        labelPass.setForeground(Color.WHITE);
        labelPass.setBounds(150,212,300,30);
        passwordField.setBounds(150,244,200,30);

        buttonLogin.setText("LogIn");
        buttonLogin.setFont(new Font(null, Font.BOLD, 18));
        buttonLogin.addActionListener(this);
        buttonLogin.setForeground(Color.WHITE);
        buttonLogin.setBounds(150,290,200,30);
        buttonLogin.setContentAreaFilled(false);
        buttonLogin.setBorderPainted(false);
        buttonLogin.setFocusable(false);
        //buttonLogin.setHorizontalTextPosition(JButton.CENTER);
        //buttonLogin.setVerticalTextPosition(JButton.BOTTOM);

        buttonForgot.setText("Forgot Password");
        buttonForgot.addActionListener(this);
        buttonForgot.setForeground(Color.WHITE);
        buttonForgot.setBounds(50,320,140,20);
        buttonForgot.setContentAreaFilled(false);
        buttonForgot.setBorderPainted(false);
        buttonForgot.setFocusable(false);
        //buttonForgot.setHorizontalTextPosition(JButton.CENTER);
        //buttonForgot.setVerticalTextPosition(JButton.BOTTOM);

        buttonCreate.setText("Create Account");
        buttonCreate.addActionListener(this);
        buttonCreate.setForeground(Color.WHITE);
        buttonCreate.setBounds(50,300,140,20);
        buttonCreate.setContentAreaFilled(false);
        buttonCreate.setBorderPainted(false);
        buttonCreate.setFocusable(false);
        //buttonCreate.setHorizontalTextPosition(JButton.CENTER);
       // buttonCreate.setVerticalTextPosition(JButton.BOTTOM);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonCreate){
            frame.setVisible(false);
            new CreateAccount();
        }
        if(e.getSource()==buttonForgot){
            JOptionPane.showMessageDialog(null,"This Action is not available right now");

        }
        if(e.getSource()==buttonLogin) {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/payne?serverTimezone=UTC","root","secret");

                String username = textFieldUser.getText();
                String password = passwordField.getText();

                Statement stmt = conn.createStatement();

                String sql = "select * from users where username='"+username+"' and password='"+password+"'";

                ResultSet rs = stmt.executeQuery(sql);
                GetUser getUser;
                if(rs.next()) {
                    frame.dispose();
                    getUser=new GetUser(rs.getInt("balance"),rs.getString("username"),rs.getString("email"),rs.getString("phone"));
                    Main homepage = new Main();

                    JLabel labelProfile = new JLabel();
                    JLabel labelUsername = new JLabel();
                    JLabel labelEmail = new JLabel();
                    JLabel labelPhone = new JLabel();

                    JLabel labelBalance = new JLabel();

                    labelBalance.setText("PHP "+getUser.getBalance());
                    labelBalance.setBounds(150,40,400,40);
                    labelBalance.setForeground(new Color(17,103,166));
                    labelBalance.setFont(new Font(null, Font.BOLD, 25));

                    labelProfile.setText("PROFILE");
                    labelProfile.setBounds(5,25,230,40);
                    labelProfile.setForeground(Color.WHITE);
                    labelProfile.setFont(new Font(null, Font.BOLD, 25));

                    labelUsername.setText(getUser.getUsername());
                    labelUsername.setBounds(5,85,230,35);
                    labelUsername.setForeground(Color.WHITE);
                    labelUsername.setFont(new Font(null, Font.BOLD, 18));

                    labelEmail.setText(getUser.getEmail());
                    labelEmail.setBounds(5,140,230,20);
                    labelEmail.setForeground(Color.WHITE);
                    labelEmail.setFont(new Font(null, Font.PLAIN, 13));

                    labelPhone.setText(getUser.getPhone());
                    labelPhone.setBounds(5,175,230,15);
                    labelPhone.setForeground(Color.WHITE);
                    labelPhone.setFont(new Font(null, Font.PLAIN, 13));

                    homepage.panelBalance.add(labelBalance);

                    homepage.panelMenu.add(labelUsername);
                    homepage.panelMenu.add(labelEmail);
                    homepage.panelMenu.add(labelPhone);
                    homepage.panelMenu.add(labelProfile);

                }else{
                    JOptionPane.showMessageDialog(null,"username or password incorrect","Try again",JOptionPane.ERROR_MESSAGE);
                    textFieldUser.setText("");
                    passwordField.setText("");
                }
                stmt.close();
                conn.close();

            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
