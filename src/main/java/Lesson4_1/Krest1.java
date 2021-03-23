package Lesson4_1;

import java.util.Random;
import java.util.Scanner;

public class Krest1 {

    public static int SIZE = 4;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    // контрольные суммы для столбцов, строк, диагоналей: Комп -1 от суммы, человек +1 к сумме
    public static int[] controlSumRow = new int[SIZE];
    public static int[] controlSumColumn = new int[SIZE];
    public static int controlSumMainDiagonal = 0;
    public static int controlSumDiagonal = 0;

    public static void main(String[] args) {
        run();

    }


    public static void run() {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin()) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin()) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }


        System.out.println("Игра закончена");
    }


    public static boolean checkWin() {
        for (int i = 0; i < SIZE; i++) {
            if (controlSumColumn[i] == SIZE * (-1) || controlSumColumn[i] == SIZE) return true;
            if (controlSumRow[i] == SIZE * (-1) || controlSumRow[i] == SIZE) return true;
            if (controlSumMainDiagonal == SIZE * (-1) || controlSumMainDiagonal == SIZE) return true;
            if (controlSumDiagonal == SIZE * (-1) || controlSumDiagonal == SIZE) return true;
        }
        return false;
    }


    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static int aiBlock(){
        int blockRow = indexRow(controlSumRow);
        if(controlSumRow[blockRow] == SIZE - 1){
            for (int i = 0; i < SIZE; i++) {
                if(isCellValid(controlSumRow[blockRow],i)) {
                    int flag = -1;
                    stepStep(controlSumRow[blockRow],i, DOT_O, flag);
                    return 1
                }
            }
        }
        else{
            blockRow = indexRow(controlSumColumn);
            if(controlSumColumn[blockRow] == SIZE - 1){
                for (int i = 0; i < SIZE; i++) {
                    if(isCellValid(i, controlSumColumn[blockRow])) {
                        int flag = -1;
                        stepStep(i, controlSumColumn[blockRow], DOT_O, flag);
                        return 1
                    }
                }
                else {
                  if(controlSumMainDiagonal == SIZE -1)  
                }
            }

        }








    }

    public static int aiWin(){

    }



    public static void aiTurn() {
        int cnt = 0
        cnt = aiBlock();
        if (aiBlock == 1) return;

        aiWin(x, y);
        aiStep(x, y);
    }

    public static void stepStep(int x3, int y3, char DOT, int flag){
        // комп DOT = 0, flag = -1, чел DOT = X, flag = 1
        System.out.println(" " + DOT + " в точку " + (x3 + 1) + " " + (y3 + 1));
        map[x3][y3] = DOT_O;
        controlSumRow[x3] += flag;
        controlSumColumn[y3] += flag;
        if (x3 == y3) {
            controlSumMainDiagonal += flag;
        }
        if (y3 == Math.abs(x3 - SIZE + 1)) {
            controlSumDiagonal += flag;
        }
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты в формате X Y > ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        int flagHum = 1;
        stepStep(x, y, DOT_X, flagHum);

    }

    public static int indexRow(int[] Row){

        int indexOfMax = 0;
        //int indexOfMin = 0;
        for (int i = 1; i < Row.length; i++)
        {
            if (Row[i] > Row[indexOfMax])
            {
                indexOfMax = i;
            }
          //  else if (array[i] < array[indexOfMin])
          //  {
          //      indexOfMin = i;
          //  }
        }
        return indexOfMax;
    }





    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" ");
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }



}
