package com.Payne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CreateAccount implements ActionListener {

    ImageIcon logo100 = new ImageIcon("translogo100.png");
    JFrame frame = new JFrame();
    JLabel labelLogo = new JLabel();
    JLabel labelEmail = new JLabel();
    JLabel labelNumber = new JLabel();
    JLabel labelusername = new JLabel();
    JLabel labelpassword = new JLabel();
    JTextField textFieldEmail = new JFormattedTextField();
    JTextField textFieldNumber = new JFormattedTextField();
    JTextField textFieldUsername = new JFormattedTextField();
    JTextField  textFieldPassword = new JTextField();
    JButton buttonCreate = new JButton();
    JButton buttonBack = new JButton();
    JPanel panelLogo = new JPanel();
    JPanel panelText = new JPanel();
    JPanel panelUserInput = new JPanel();

    CreateAccount(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(logo100.getImage());
        frame.setTitle("Create Account");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(panelLogo);
        frame.add(panelText);
        frame.add(panelUserInput);

        labelLogo.setIcon(logo100);
        labelLogo.setText("Get started with a free account!");
        labelLogo.setForeground(Color.WHITE);
        labelLogo.setBounds(325,0,150,150);
        labelLogo.setHorizontalTextPosition(JLabel.CENTER);
        labelLogo.setVerticalTextPosition(JLabel.BOTTOM);

        labelEmail.setText("Email");
        labelEmail.setForeground(Color.WHITE);
        labelEmail.setBounds(200,50,120,30);

        labelNumber.setText("Phone Number");
        labelNumber.setForeground(Color.WHITE);
        labelNumber.setBounds(200,81,120,30);

        labelusername.setText("Username");
        labelusername.setForeground(Color.WHITE);
        labelusername.setBounds(200,112,120,30);

        labelpassword.setText("Password");
        labelpassword.setForeground(Color.WHITE);
        labelpassword.setBounds(200,143,120,20);

        textFieldEmail.setBounds(40,50,200,20);
        textFieldNumber.setBounds(40,81,200,20);
        textFieldUsername.setBounds(40,112,200,20);
        textFieldPassword.setBounds(40,143,200,20);

        buttonCreate.setText("Create my Wallet");
        buttonCreate.addActionListener(this);
        buttonCreate.setFont(new Font(null, Font.BOLD, 15));
        buttonCreate.setForeground(Color.WHITE);
        buttonCreate.setBounds(40,177,200,20);
        buttonCreate.setContentAreaFilled(false);
        buttonCreate.setBorderPainted(false);
        buttonCreate.setFocusable(false);
        buttonCreate.setHorizontalTextPosition(JButton.CENTER);
        buttonCreate.setVerticalTextPosition(JButton.BOTTOM);

        buttonBack.setText("Back to login");
        buttonBack.addActionListener(this);
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setBounds(0,250,120,20);
        buttonBack.setContentAreaFilled(false);
        buttonBack.setBorderPainted(false);
        buttonBack.setFocusable(false);
        buttonBack.setHorizontalTextPosition(JButton.CENTER);
        buttonBack.setVerticalTextPosition(JButton.BOTTOM);

        panelLogo.setBounds(0,0,800,150);
        panelLogo.setBackground(new Color(26,34,40));
        panelLogo.setLayout(null);
        panelLogo.add(labelLogo);

        panelText.setBounds(0,150,300,350);
        panelText.setBackground(new Color(26,34,40));
        panelText.setLayout(null);
        panelText.add(labelEmail);
        panelText.add(labelNumber);
        panelText.add(labelusername);
        panelText.add(labelpassword);
        panelText.add(buttonBack);

        panelUserInput.setBounds(300,150,500,350);
        panelUserInput.setBackground(new Color(26,34,40));
        panelUserInput.setLayout(null);
        panelUserInput.add(textFieldEmail);
        panelUserInput.add(textFieldNumber);
        panelUserInput.add(textFieldUsername);
        panelUserInput.add(textFieldPassword);
        panelUserInput.add(buttonCreate);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonBack){
            frame.dispose();
            new Login();
        }
        if(e.getSource()==buttonCreate) {
          Validate();
          if(user != null) {
              textFieldEmail.setText("");
              textFieldNumber.setText("");
              textFieldUsername.setText("");
              textFieldPassword.setText("");
              JOptionPane.showMessageDialog(null,"Your Account was successfully added");
          }
        }
    }

    private void  Validate(){
        String email = textFieldEmail.getText();
        String  phone= textFieldNumber.getText();
        String username = textFieldUsername.getText();
        String password = textFieldPassword.getText();

        if(email.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty() ){
            JOptionPane.showMessageDialog(null,"Please enter all fields","try again",JOptionPane.ERROR_MESSAGE);
        return;
        }

        user = addUserToDatabase(email,phone,username,password);
    }

    public User user;
    private User addUserToDatabase(String email,String phone,String username,String password){
        User user = null;

        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/payne?serverTimezone=UTC","root","secret");

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users(email, phone, username, password)" + "VALUE (?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);

            int addedRows = preparedStatement.executeUpdate();
            if(addedRows > 0) {
                user = new User();
                user.email = email;
                user.phone = phone;
                user.username = username;
                user.password = password;
            }
            stmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

}
