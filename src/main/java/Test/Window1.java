package Test;

import Lesson8.GameXO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window1 extends JFrame {


    protected static final int[] rezult = new int[1];
    public static int yy;

    public Window1() {

        setBounds(250, 200, 300, 300);
        FlowLayout fl; // -> -> ->
        BorderLayout bl; // N, S, W, E, CENTER
        GridLayout gl; // N x M

        Font BigFontTR = new Font("Arial", Font.BOLD, 20);//Тут все про шрифт)

        JTextField text = new JTextField("На каком поле играем?");
        text.setFont(BigFontTR);
        text.setHorizontalAlignment(JTextField.CENTER);


        JPanel panel = new JPanel(new GridLayout(4, 1));
        JButton button1 = new JButton("3 x 3");
        JButton button2 = new JButton("4 x 4");
        JButton button3 = new JButton("ВЫХОД");
        button1.setFont(BigFontTR);
        button2.setFont(BigFontTR);
        button3.setFont(BigFontTR);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rezult[0] = 3;
                yy = 3;

                new GameXO1();
                dispose();
                return;

            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rezult[0] = 4;
                yy = 4;
                new GameXO1();
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
        panel.add(button2);
        panel.add(button3);

        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        return;

    }

    public static void main(String[] args) {
        new Window1();
    }
}
