package Lesson2;

import java.io.PrintStream;
import java.util.Arrays;
import java.lang.String;

public class Lesson2 {
    public static void main(String[] args) {
        int[] arR = {0, 1, 1, 0, 1, 0, 1, 1, 0, 0};
        int[] arR2 = new int[8];
        int[] arR3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] arR4 = new int[8][8];

        System.out.println("Задание 1");
        System.out.print("Исходный массив: ");
        printArr(arR);
        System.out.print("Переработанный : ");
        checkNull(arR);
        System.out.println("Задание 2");
        taskTwo(arR2);
        System.out.println("Задание 3");
        System.out.print("Исходный массив: ");
        printArr(arR3);
        System.out.print("Переработанный : ");
        taskThre(arR3);
        System.out.println("Задание 4");
        sqPrint(arR4);
    }

    static void checkNull(int[] arr1) {
        for (int i = 0; i < 10; i++) {
            if (arr1[i] == 0) {
                arr1[i] = 1;
            }
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
    }

    static void printArr(int[] arr2) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%3d", arr2[i] );
        }
        System.out.println();
    }

    static void taskTwo(int[] arr3) {
        int j = 0;
        for (int i = 0; i < 8; i++) {
            arr3[i] = j;
            j += 3;
            System.out.print(arr3[i] + " ");

        }
        System.out.println();
    }

    static void taskThre(int[] arr3) {
        int j = 0;
        for (int i = 0; i < 10; i++) {
            if (arr3[i] < 6) {
                arr3[i] = arr3[i] * 2;
            }

            System.out.printf("%3d", arr3[i] );
        }
        System.out.println();
    }

    static void sqPrint(int[][] arR41) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i == j){
                    arR41[i][j] = 1;
                }
                System.out.print(arR41[i][j] + " ");
            }
            System.out.println();
        }
    }

    


}