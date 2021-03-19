package Lesson2;

import java.util.Arrays;

// rere
public class Lesson2 {
    public static void main(String[] args) {
        int[] arR = {0, 1, 1, 0, 1, 0, 1, 1, 0, 0};
        int[] arR2 = new int[8];
        int[] arR3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] arR4 = new int[8][8];
        int[] arR5 = { 6,7,3,23,-17,56,1234,238,17,79,13,678 };
        int[] arR6 = { 2, 2, 2, 1, 2, 2,10, 1 };
        int[] arR7 = { 1, 16, 165, 15, 78,75,90, 16, 54 };
        int[] arR8 = { 1,2,2,3,3,3,2,2,1,1,4,5,6 };
        int bigC = 0;



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
        System.out.println("Задание 5:");
        int bigB = 0;
        bigC = maxiArr(arR5, bigB);
        System.out.print("Максимальное значение в массиве: ");
        System.out.println(bigC);
        System.out.println("Задание 6: " + " ");

        if( sumCentr(arR6) ){
            System.out.println("Такое место есть!");
        }
        else {
            System.out.println("Такого места нет!");
        }

        if( sumCentr(arR7) ){
            System.out.println("Такое место есть!");
        }
        else {
            System.out.println("Такого места нет!");
        }

        System.out.println("Задание 7: ");
       // String strS = Arrays.toString(arR3);
       // System.out.println(strS);
        printArr(arR8);
        Balls(arR8);

    }

    static void checkNull(int[] arr1) {
        for (int i = 0; i < 10; i++) {
            if (arr1[i] == 0) {
                arr1[i] = 1;
            }
            System.out.printf("%3d", arr1[i] );
        }
        System.out.println();
    }

    static void printArr(int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
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
        for (int i = 0; i < arr3.length; i++) {
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
                arR41[i][i] = 1;
                arR41[i][8 - 1 - i] = 1;
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(" " + arR41[i][j]);
            }
            System.out.println();
        }
    }

    static int maxiArr(int[] B, int bigA){
        bigA = B[0];
        for (int i = 0; i < B.length; i++) {
            if( bigA < B[i] ) {
                bigA = B[i];
           }
        }
        return bigA;
    }

    static boolean sumCentr(int[] aRRR){
        int suma = 0;
        int suma1 = 0;
        for (int i = 0; i < aRRR.length ; i++) {
            suma1 += aRRR[i];
        }
        for (int i = 0; i < aRRR.length; i++) {
          suma += aRRR[i];
          suma1 -= aRRR[i];
          if( suma == suma1 ){
              return true;
          }
        }
        return false;
    }

    static void Balls(int[] ball){
        int i = 0;
        int r = 2;
        while (i < ball.length - 3){
            if(ball[i] == ball[i+1] && ball[i] == ball[i + 2]) {

                while(ball[i] == ball[i+r]) {
                    r += 1;
                }
                for (int j = 0; j < r; j++) {
                    ball = removeElement(ball, i);
                }

                i = 0;
                r = 2;

            } else { i += 1;}

        }
        printArr(ball);

    }
    static int[] removeElement(int[] n, int index) {

        int end = n.length;
        for(int j = index; j < end - 1; j++) {
            n[j] = n[j + 1];
        }
        end--;

        int[] newArr = new int[end];
        for(int k = 0; k < newArr.length; k++) {
            newArr[k] = n[k];
        }

        return newArr;
    }


}