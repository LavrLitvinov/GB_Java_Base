package Lesson8;

import java.awt.*;




import javax.swing.*;

public class  GameXO extends JFrame {


    private static final ImageIcon DEFAULT = new ImageIcon("def.png");
    private static final ImageIcon ICON_X = new ImageIcon("x1.png");
    private static final ImageIcon ICON_O = new ImageIcon("o.png");
    private JButton[][] map;

    public static int[] controlSumRow;
    public static int[] controlSumColumn;


    public static int controlSumMainDiagonal = 0;
    public static int controlSumDiagonal = 0;
    public static int SIZE;
    public static String quest = "";






    public GameXO()  {


        SIZE = Window.rezult[0];

        controlSumRow = new int[SIZE];
        controlSumColumn = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            controlSumRow[i] = 0;
            controlSumColumn[i] = 0;
        }


        setBounds(130,100, 150*SIZE, 150*SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // dispose();
        setResizable(false);
        JPanel panel = new JPanel(new GridLayout(SIZE,SIZE));
        map = new JButton[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = new JButton();
                map[i][j].setIcon(DEFAULT);

                JButton cur = map[i][j];
                panel.add(cur);
                int finalI = i;
                int finalJ = j;
                cur.addActionListener(a -> {
                    cur.setDisabledIcon(ICON_X);
                    cur.setIcon(ICON_X);
                    cur.setEnabled(false);
                    int k = finalI;
                    int e = finalJ;

                    stepStep(k, e, 1);
                    if(checkWin()){
                        // Вытграл человек
                        quest = "Выирыш! Повторим?";
                        new EndGameDialog();
                        System.out.println("HUMAN WIN!");// диалоговое окно
                        dispose();
                        return;
                    }
                    if(checkWinWin()){
                        quest = "Ничья!! Продолжим игру?";
                        new EndGameDialog();
                        System.out.println("WinWin");
                        dispose();
                        return;
                    }
                    // TODO: 05.04.2021 check victory
                    movePC();
                    // TODO: 05.04.2021 check victory
                    if(checkWin()){

                        quest = "Проигрыш! Повторим?";
                        new EndGameDialog();


                        System.out.println("COMP WIN!");// диалоговое окно
                        dispose();
                        return;
                 //
                    }
                    if(checkWinWin()){
                        quest = "Ничья!! Продолжим игру?";
                        new EndGameDialog();

                        dispose();
                        System.out.println("WinWin");
                        return;
                    }
                });
            }
        }
        add(panel);
        setVisible(true);
    }

    public static void stepStep(int x3, int y3, int flag) {
        //  flag = -1, , flag = 1

        controlSumRow[x3] += flag;
        controlSumColumn[y3] += flag;
        if (x3 == y3) {
            controlSumMainDiagonal += flag;
        }
        if (y3 == Math.abs(x3 - SIZE + 1)) {
            controlSumDiagonal += flag;
        }
    }

    private void movePC() {

        int cnt = 0;
        cnt = aiBlock(-1); // выигрышный ход компа (если есть)
        if (cnt == 1) return;
        cnt = aiBlock(1); // блок хода человека
        if (cnt == 1) return;
        aiStep(); // рандомный ход компа
        return;

    }

    public static boolean checkWin() { // проверяем признаки победы
        for (int i = 0; i < SIZE; i++) {
            if (controlSumColumn[i] == SIZE * (-1) || controlSumColumn[i] == SIZE) return true;
            if (controlSumRow[i] == SIZE * (-1) || controlSumRow[i] == SIZE) return true;
            if (controlSumMainDiagonal == SIZE * (-1) || controlSumMainDiagonal == SIZE) return true;
            if (controlSumDiagonal == SIZE * (-1) || controlSumDiagonal == SIZE) return true;
        }
        return false;
    }

    public  boolean checkWinWin() { // проверяем признаки победы
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j].getIcon().equals(DEFAULT)) return false;
            }

        }
        return true;
    }

    private void aiStep(){
        int i = 0;
        int j = 0;
        while (true){
            i = (int)(Math.random()*(SIZE));
            j = (int)(Math.random()*(SIZE));
            if (map[i][j].getIcon().equals(DEFAULT)) {
                map[i][j].setDisabledIcon(ICON_O);
                map[i][j].setIcon(ICON_O);
                map[i][j].setEnabled(false);
                stepStep(i, j, -1);
                break;
            }
        }
        return;

    }








    private void aiStep1(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j].getIcon().equals(DEFAULT)) {
                    map[i][j].setDisabledIcon(ICON_O);
                    map[i][j].setIcon(ICON_O);
                    map[i][j].setEnabled(false);
                    stepStep(i, j, -1);
                    return;
                }
            }
        }
    }


    public static int indexRow(int[] Row, int flug) {
// индекс с минимальным/ максимальным значением контрольной суммы
        int indexOfMax = 0;
        int indexOfMin = 0;
        for (int i = 1; i < Row.length; i++) {
            if (Row[i] > Row[indexOfMax]) {
                indexOfMax = i;
            } else if (Row[i] < Row[indexOfMin]) {
                indexOfMin = i;
            }
        }
        if (flug > 0) {
            return indexOfMax;
        } else {
            return indexOfMin;
        }
    }

    public  int aiBlock(int vAr) {

        // ставим 0 в вытгрышную клетку (если она есть) или блокируем последнее поле человека
        int flag = -1;
        int blockRow = indexRow(controlSumRow, vAr);
        if (controlSumRow[blockRow] == (SIZE - 1) * vAr) {
            for (int j = 0; j < SIZE; j++) {
                if (map[blockRow][j].getIcon().equals(DEFAULT)) {
                    map[blockRow][j].setDisabledIcon(ICON_O);
                    map[blockRow][j].setIcon(ICON_O);
                    map[blockRow][j].setEnabled(false);
                    stepStep(blockRow, j,  -1);
                    return 1;
                }

            }
        } else {
            blockRow = indexRow(controlSumColumn, vAr);
            if (controlSumColumn[blockRow] == (SIZE - 1) * vAr) {
                for (int i = 0; i < SIZE; i++) {
                    if (map[i][blockRow].getIcon().equals(DEFAULT)) {
                        map[i][blockRow].setDisabledIcon(ICON_O);
                        map[i][blockRow].setIcon(ICON_O);
                        map[i][blockRow].setEnabled(false);
                        stepStep(i, blockRow,  -1);
                        return 1;
                    }
                }
            } else {
                if (controlSumMainDiagonal == (SIZE - 1) * vAr) {
                    for (int i = 0; i < SIZE; i++) {
                        if (map[i][i].getIcon().equals(DEFAULT)) {
                            map[i][i].setDisabledIcon(ICON_O);
                            map[i][i].setIcon(ICON_O);
                            map[i][i].setEnabled(false);
                            stepStep(i, i,  -1);
                            return 1;
                        }
                    }
                } else {
                    if (controlSumDiagonal == (SIZE - 1) * vAr) {
                        for (int i = 0; i < SIZE; i++) {
                            int j = Math.abs(i - SIZE + 1);
                            if (map[i][j].getIcon().equals(DEFAULT)) {
                                map[i][j].setDisabledIcon(ICON_O);
                                map[i][j].setIcon(ICON_O);
                                map[i][j].setEnabled(false);
                                stepStep(i, j,  -1);
                                return 1;
                            }
                        }
                    }
                }


            }
        }
        return 0;
    }




//    public static void main(String[] args) {

  //      new GameXO();


 //   }


}
