package lesson_1;

import org.w3c.dom.ls.LSOutput;

public class lesson_1 {
// Домашнее задание первого урока
    public static void main(String[] args) {
        // Набиваем исходные величины
        // Задание 3
        float volA = 3.7f;
        float volB = 8.9f;
        float volC = 9.9f;
        float volD =  23.4f;
        // Задание 4
        int intVol1 = 12;
        int intVol2 = 3;
        // Задание 5
        float floatVol5 = -67.6f;
        // Задание 6
        int intVol6 = 78;
        // Задание 7
        String strVol7 = "Медвед";
        // Задание 8
        int yearTest = 1304;
        // Для порядка инициализируем логическую переменную
        boolean dooleanValue = true;

        System.out.println("Задание 3 :"+" a = "+volA + " b = "+volB + " c = "+volC+" d = "+volD+ " Итог:");
        System.out.println(_three(volA, volB, volC, volD));
        System.out.println("Задание 4 : a = " + intVol1 +" b = " + intVol2);
        System.out.println(_four(intVol1, intVol2));
        System.out.println("Задание 5 : a = "+floatVol5);
        _fifth(floatVol5);
        System.out.println("Задание 6 :  a = "+ intVol6);
        System.out.println(_sixth(intVol6));
        System.out.println("Задание 7 :");
        _seventh(strVol7);
        System.out.println("Зфдание 8 : год "+yearTest+" является" );
        _eighth(yearTest);




    }

    static float _three(float a, float b, float c, float d){
        return a * (b + (c / d));
    }

    static boolean _four(int a, int b){
        if (a+b < 10 || a+b > 20){
            return true;
        } else {
            return false;

        }
    }
    static void _fifth(float a) {
        if (a >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }
    static boolean _sixth(int a){
        return a >= 0 ? true : false ;
        }
    static void _seventh(String a){
        System.out.println("Привет, " + a + " !");
    }

    static void _eighth(int a){
        if( a % 400 == 0 || (a % 4 == 0 && a % 100 != 0)){
            System.out.println("високосным");
        } else {
            System.out.println("простым");
        }

    }

}