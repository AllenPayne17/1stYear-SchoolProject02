package com.Payne;

import javax.swing.*;
import java.awt.*;

public class Branding {

    JWindow window = new JWindow();
    JPanel panel = new JPanel();
    JProgressBar bar = new JProgressBar();
    ImageIcon image = new ImageIcon("branding.jpg");
    JLabel label = new JLabel();

    Branding(){

        label.setIcon(image);
        label.setVerticalAlignment(JLabel.TOP);

        panel.setBounds(0,0,800,500);
        panel.setLayout(new BorderLayout());
        panel.add(label);

        bar.setValue(0);
        bar.setBounds(0,480,800,20);
        bar.setStringPainted(true);

        window.add(panel);
        window.add(bar);
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setVisible(true);

        fill();
    }
    public void fill(){
        int counter = 0;
        while(counter<=100) {

            bar.setValue(counter);
            try{
                Thread.sleep(100);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(counter==100){
                window.dispose();
                new Login();
                break;
            }else{
                counter+=1;
            }
        }
    }
}
