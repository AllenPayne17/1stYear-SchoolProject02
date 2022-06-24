package com.Payne;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    JFrame frame = new JFrame();
    JLabel labelLogo = new JLabel();
    JLabel labelCashInText = new JLabel();
    JLabel labelCashIn = new JLabel();
    JLabel labelbalanceText = new JLabel();
    JPanel availableBalance = new JPanel();
    JPanel panelBalance = new JPanel();
    JPanel panelButtonBar = new JPanel();
    JPanel panelScreen = new JPanel();
    JPanel panelHistory = new JPanel();
    JPanel panelMenu = new JPanel();
    JButton buttonAddFund = new JButton();
    JButton buttonSend = new JButton();
    JButton buttonReceive = new JButton();
    JButton buttonHistory = new JButton();
    JButton buttonCashin = new JButton();
    JButton buttonHelpCenter = new JButton();
    JButton buttonSettings = new JButton();
    JButton buttonLogout = new JButton();

    JTextField textFieldAmount = new JTextField();

    ImageIcon logo100 = new ImageIcon("logo100.png");
    ImageIcon icon100 = new ImageIcon("icon100.png");


    Main(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(logo100.getImage());
        frame.setTitle("HOMEPAGE");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(panelScreen);
        frame.add(panelMenu);

        labelLogo.setIcon(icon100);
        labelLogo.setBounds(75,0,550,100);

        labelbalanceText.setText("Available Balance");
        labelbalanceText.setForeground(Color.WHITE);
        labelbalanceText.setBounds(150,2,200,16);
        labelbalanceText.setFont(new Font(null,Font.BOLD,15));

        availableBalance.setBounds(0,0,400,18);
        availableBalance.setBackground(new Color(17,103,166));
        availableBalance.setLayout(null);
        availableBalance.add(labelbalanceText);

        panelBalance.setBounds(75,100,400,95);
        panelBalance.setBackground(Color.WHITE);
        panelBalance.setLayout(null);
        panelBalance.add(availableBalance);

        panelButtonBar.setBounds(75,195,400,75);
        panelButtonBar.setBackground(new Color(17,103,166));
        panelButtonBar.setLayout(null);
        panelButtonBar.add(buttonAddFund);
        panelButtonBar.add(buttonSend);
        panelButtonBar.add(buttonReceive);
        panelButtonBar.add(buttonHistory);

        labelCashInText.setText("Add funds via online transfers");
        labelCashInText.setForeground(Color.WHITE);
        labelCashInText.setFont(new Font(null,Font.BOLD,15));

        labelCashInText.setBounds(2,2,400,15);

        labelCashIn.setText("Cash In");
        labelCashIn.setForeground(Color.WHITE);
        labelCashIn.setFont(new Font(null,Font.BOLD,15));
        labelCashIn.setBounds(40,64,90,20);

        textFieldAmount.setBounds(140,64,90,20);

        buttonCashin.setText("Complete Cash in");
        buttonCashin.addActionListener(this);
        buttonCashin.setForeground(Color.WHITE);
        buttonCashin.setBackground(Color.BLACK);
        buttonCashin.setBorderPainted(false);
        buttonCashin.setBounds(115,100,140,20);
        buttonCashin.setFocusable(false);

        panelHistory.setBounds(75,280,400,150);
        panelHistory.setBackground(new Color(17,103,166));
        panelHistory.setLayout(null);
        panelHistory.setVisible(false);
        panelHistory.add(labelCashInText);
        panelHistory.add(labelCashIn);
        panelHistory.add(textFieldAmount);
        panelHistory.add(buttonCashin);

        panelScreen.setBounds(0, 0,550,500);
        panelScreen.setBackground(new Color(26,34,40));
        panelScreen.setLayout(null);
        panelScreen.add(labelLogo);
        panelScreen.add(panelBalance);
        panelScreen.add(panelButtonBar);
        panelScreen.add(panelHistory);

        buttonAddFund.setText("Cash In");
        buttonAddFund.addActionListener(this);
        buttonAddFund.setFont(new Font(null, Font.BOLD, 12));
        buttonAddFund.setForeground(Color.WHITE);
        buttonAddFund.setBackground(Color.BLACK);
        buttonAddFund.setBorderPainted(false);
        buttonAddFund.setBounds(6,22,80,31);
        buttonAddFund.setFocusable(false);
        buttonAddFund.setLayout(null);

        buttonSend.setText("Send");
        buttonSend.addActionListener(this);
        buttonSend.setFont(new Font(null, Font.BOLD, 12));
        buttonSend.setForeground(Color.WHITE);
        buttonSend.setBackground(Color.BLACK);
        buttonSend.setBorderPainted(false);
        buttonSend.setBounds(105,22,80,31);
        buttonSend.setFocusable(false);
        buttonSend.setLayout(null);

        buttonReceive.setText("Receive");
        buttonReceive.addActionListener(this);
        buttonReceive.setFont(new Font(null, Font.BOLD, 12));
        buttonReceive.setForeground(Color.WHITE);
        buttonReceive.setBackground(Color.BLACK);
        buttonReceive.setBorderPainted(false);
        buttonReceive.setBounds(209,22,80,31);
        buttonReceive.setFocusable(false);
        buttonReceive.setLayout(null);

        buttonHistory.setText("History");
        buttonHistory.addActionListener(this);
        buttonHistory.setFont(new Font(null, Font.BOLD, 12));
        buttonHistory.setForeground(Color.WHITE);
        buttonHistory.setBackground(Color.BLACK);
        buttonHistory.setBorderPainted(false);
        buttonHistory.setBounds(313,22,80,31);
        buttonHistory.setFocusable(false);
        buttonHistory.setLayout(null);

        buttonHelpCenter.setText("Help Center");
        buttonHelpCenter.addActionListener(this);
        buttonHelpCenter.setForeground(Color.WHITE);
        buttonHelpCenter.setBounds(5,300,200,20);
        buttonHelpCenter.setContentAreaFilled(false);
        buttonHelpCenter.setBorderPainted(false);
        buttonHelpCenter.setFocusable(false);
        buttonHelpCenter.setLayout(null);

        buttonSettings.setText("Settings");
        buttonSettings.addActionListener(this);
        buttonSettings.setForeground(Color.WHITE);
        buttonSettings.setBounds(5,325,200,20);
        buttonSettings.setContentAreaFilled(false);
        buttonSettings.setBorderPainted(false);
        buttonSettings.setFocusable(false);
        buttonSettings.setLayout(null);

        buttonLogout.setText("Logout");
        buttonLogout.addActionListener(this);
        buttonLogout.setForeground(Color.WHITE);
        buttonLogout.setBounds(5,350,200,20);
        buttonLogout.setContentAreaFilled(false);
        buttonLogout.setBorderPainted(false);
        buttonLogout.setFocusable(false);
        buttonLogout.setLayout(null);


        panelMenu.setBounds(550,0,250,500);
        panelMenu.setBackground(new Color(26,26,26));
        panelMenu.setLayout(null);
        panelMenu.add(buttonHelpCenter);
        panelMenu.add(buttonSettings);
        panelMenu.add(buttonLogout);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonAddFund){
            panelHistory.setVisible(true);
        }
        if(e.getSource()==buttonLogout){
            frame.dispose();
            new Login();
        }
    }

    public static void main(String[] args) {
        new Branding();
    }
}
