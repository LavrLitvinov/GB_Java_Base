package Test;

import Lesson8.GameXO;
import Lesson8.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGameDialog1 extends JFrame {


    public EndGameDialog1() {

        setBounds(250, 200, 300, 300);


        Font BigFontTR = new Font("Arial", Font.BOLD, 20);//Тут все про шрифт)

        JTextField text = new JTextField(GameXO1.quest);
        text.setFont(BigFontTR);
        text.setHorizontalAlignment(JTextField.CENTER);


        JPanel panel = new JPanel(new GridLayout(3, 1));
        JButton button1 = new JButton("ПРОДОЛЖИМ!");

        JButton button3 = new JButton("ВЫХОД");
        button1.setFont(BigFontTR);

        button3.setFont(BigFontTR);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Window1();

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


    }

}
