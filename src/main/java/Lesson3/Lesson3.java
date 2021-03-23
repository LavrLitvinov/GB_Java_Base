package Lesson3;

import java.util.Scanner;


public class Lesson3 {
    public static void main(String[] args) {
        boolean tR = true;
        int cnt;
        int randVol;
        int aAnsver;
        int conT;
        Scanner aN = new Scanner(System.in);


        while (tR) {
            randVol = (int) (Math.random() * 10) + 1;
            cnt = 0;
            System.out.println("Я загадало целое число от 0 до 10. У тебя есть три попытки его угадать!");
            for (int i = 1; i < 4; i++) {
                cnt++;
                System.out.print(i + "-я попытка: ");

                if (aN.hasNextInt()) {
                    aAnsver = aN.nextInt();
                } else {
                    System.out.println(" Это что-то непотребное! Я обиделось!");
                    return;
                }

                if (aAnsver < randVol) {
                    System.out.println("Загаданное число больше.");
                } else {
                    if (aAnsver > randVol) {
                        System.out.println("Загаданное число меньше.");
                    } else {
                        System.out.println("Угадал!");
                        cnt = 0;
                        break;
                    }
                }
            }
            if (cnt != 0) {
                System.out.println("Все попытки закончились!");
            }
            System.out.print("Если хочешь продолжить - жми 1 !!! А не хочешь - 0! : ");

            if (aN.hasNextInt()) {
                conT = aN.nextInt();
            } else {
                System.out.println(" Это что-то непотребное! Я обиделось!");
                return;
            }
            if (conT == 1) {
                System.out.println("Ура! Продолжаем!");
                tR = true;
            } else {
                System.out.println("До свидания!");
                tR = false;
            }

        }
    }
}