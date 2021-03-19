package Lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson3fruit {
    public static void main(String[] args) {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String inStr = "";
        String miStery;
        int randVol;
        boolean tR = true;
        
        randVol = (int) (Math.random() * 25);
        miStery = words[randVol];
        // загадали слово из массива
        System.out.println("Отладочная печать - подсказка: загадали " + miStery); // Отладка
        inStr = inPut(inStr);
        // слово загадали, пеовый вариант ответа приняли.

        while (tR) {
            //inPut2(inStr);
            if (eQv(miStery, inStr)) {
                System.out.println("Слово угадано! Это - " + miStery + " !");
                return;
            } else {
                if (miStery.length() >= inStr.length()) {
                    eQv1(miStery, inStr);
                    inStr = inPut2(inStr);
                    if (inStr.equals("*")) {
                        return;
                    }
                } else {
                    eQv1(inStr, miStery);
                    inStr = inPut2(inStr);
                    if (inStr.equals("*")) {
                        return;
                    }
                }

            }

        }


    }

    static String inPut(String inStr1) {
        Scanner sC = new Scanner(System.in);
        System.out.print(" Загадано слово из категории 'овощи-фрукты-ягоды. Отгадывай давай, вводи аглицкий вариант: ");
        inStr1 = sC.nextLine();
        return inStr1;

    }

    static String inPut2(String inStr1) {
        Scanner sC = new Scanner(System.in);
        System.out.print("Еще одна китайская попытка угадать овощ-фрукт-ягоду-орех: ( * - выход )");
        inStr1 = sC.nextLine();
        return inStr1;
    }

    static boolean eQv(String mistery, String inp) {
        if (mistery.equals(inp)) {
            return true;
        } else {
            return false; // Заглушка
        }

    }

    static void eQv1(String mL, String msH) {

        String[] anS = {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"};
        int cnt = 0;
        for (int i = 0; i < msH.length(); i++) {
            if (mL.charAt(i) == msH.charAt(i)) {

                anS[i] = "" + mL.charAt(i);
                cnt = 1;
            }

        }
        if (cnt == 0) {
            System.out.println("И рядом не стояло! Нужно снова что-то набрать! ");
        } else {
            System.out.println("Какме-то буквы совпали! Пробуем снова! ( * - выход ) ");
            for (int i = 0; i < anS.length; i++) {
                System.out.print(anS[i]);
            }
        }

    }


} // скоба класса
