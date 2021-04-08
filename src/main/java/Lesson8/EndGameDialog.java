package Lesson8;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EndGameDialog extends JFrame {


    public EndGameDialog()  {

        setBounds(400,200,300, 300);
        FlowLayout fl; // -> -> ->
        BorderLayout bl; // N, S, W, E, CENTER
        GridLayout gl; // N x M

        Font BigFontTR = new Font("Arial", Font.BOLD, 20);//Тут все про шрифт)

        JTextField text = new JTextField(GameXO.quest);
        text.setFont(BigFontTR);
        text.setHorizontalAlignment(JTextField.CENTER);


        JPanel panel = new JPanel(new GridLayout(3,1));
        JButton button1 = new JButton("ПРОДОЛЖИМ!");

        JButton button3 = new JButton("ВЫХОД");
        button1.setFont(BigFontTR);

        button3.setFont(BigFontTR);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Window();
                dispose();
                return;

            }
        });


        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                return;

            }
        });


        panel.add(text);
        panel.add(button1);
        panel.add(button3);

        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
     //   dispose();


    }

}
