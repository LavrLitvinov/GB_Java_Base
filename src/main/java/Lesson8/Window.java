package Lesson8;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;




import javax.swing.SwingUtilities;

public class Window extends JFrame {


    public static final int[] rezult = new int[1];

    public Window()  {



        setBounds(250,200,300, 300);
        FlowLayout fl; // -> -> ->
        BorderLayout bl; // N, S, W, E, CENTER
        GridLayout gl; // N x M

        Font BigFontTR = new Font("Arial", Font.BOLD, 20);//Тут все про шрифт)

        JTextField text = new JTextField("На каком поле играем?");
        text.setFont(BigFontTR);
        text.setHorizontalAlignment(JTextField.CENTER);


        JPanel panel = new JPanel(new GridLayout(4,1));
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

                new GameXO();
                dispose();
                return;


            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rezult[0] = 4;
                new GameXO();
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

        //   text.addKeyListener(new KeyAdapter() {
     //       @Override
      //      public void keyReleased(KeyEvent e) {
      //          System.out.println(e.getKeyChar());
     //           if (e.getKeyChar() == 'r') {
     //               button.setText("OLOLO");
     //           }
     //       }
    //    });
        panel.add(text);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
     //   panel.add(new JButton("3 x 3"));
     //   panel.add(new JButton("4 x 4"));
       // panel.add(new JButton("CLICK ME HJHJHJHJH"));
      //  panel.add(new JButton("DON'T CLICK ME"));
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        return;



    }

    public static void main(String[] args) {
    new Window();
    }
}
