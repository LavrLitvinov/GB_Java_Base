package LessonKrest;

import java.util.Random;
import java.util.Scanner;
public class Krest {
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 4;
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

    public static void main(String[] args){
        run();

    }


    public static void run( ) {
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
            if(controlSumColumn[i] == SIZE*(-1) || controlSumColumn[i] == SIZE) return true;
            if(controlSumRow[i] == SIZE*(-1) || controlSumRow[i] == SIZE) return true;
            if(controlSumMainDiagonal == SIZE*(-1) || controlSumMainDiagonal == SIZE) return true;
            if(controlSumDiagonal == SIZE*(-1) || controlSumDiagonal == SIZE) return true;
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

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[x][y] = DOT_O;
        controlSumRow[x] -= 1;
        controlSumColumn[y] -=1;
        if( x == y ){ controlSumMainDiagonal -= 1; }
        if( y == Math.abs(x - SIZE + 1)){ controlSumDiagonal -= 1; }
        System.out.println(" "+controlSumDiagonal+" "+controlSumMainDiagonal);

    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты в формате X Y > ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[x][y] = DOT_X;
        controlSumRow[x] += 1;
        controlSumColumn[y] +=1;
        if( x == y ){ controlSumMainDiagonal += 1;}
        if( y == Math.abs(x - SIZE + 1)){ controlSumDiagonal += 1; }
        System.out.println("  "+controlSumDiagonal+" "+controlSumMainDiagonal);
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
