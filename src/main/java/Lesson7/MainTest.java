package Lesson7;

import java.util.Scanner;
// Готово!
public class MainTest {
    public static void main(String[] args) {
        int food;
        Scanner sc = new Scanner(System.in);
        int st = 0;

// Набрали 5 драных котов
        HungryCat[] hungryCat = new HungryCat[5];
        hungryCat[0] = new HungryCat("Брысер", 0, false, 0);
        hungryCat[1] = new HungryCat("Драные обои", 0, false, 0);
        hungryCat[2] = new HungryCat("Друг Наташи", 0, false, 0);
        hungryCat[3] = new HungryCat("Битый Горшок", 0, false, 0);
        hungryCat[4] = new HungryCat("Запутаный Клубок", 0, false, 0);

        initialAppetite(hungryCat); // задали аппетит котов случайныь образом до 15 единиц включительно.

        System.out.print("Насыпьте корм в тарелку : > ");
        food = sc.nextInt();
        Plate plate = new Plate(food); //  наполнили тарелку.

        while (true) {
            int i = 0;
            int cnt = 0;
            while (i < 5) {
                if (cnt == 5) break;
                st = (int) (Math.random() * 5); // Подошел первый случайный кот.
              //  System.out.println("st = " + st);
                if (!hungryCat[st].getSatiety()) {  // кот голоден
                    if (hungryCat[st].getAppetite() > plate.getFood()) { // еды нехватает.
                        if (hungryCat[st].getFlag() == 0) {
                            i++;
                            cnt++;
                            hungryCat[st].setFlag(1);
                            continue;
                        } else {
                            continue;
                        }

                    } else {
                        hungryCat[st].setSatiety(true);
                        hungryCat[st].eat(plate);
                        i++;
                        cnt++;
                        continue;
                    }
                }

            }
            int needFood = 0;
            for (HungryCat x : hungryCat) {
                if (x.getSatiety()) {
                    System.out.println(x.getName() + " - сыт и доволен.");
                } else {
                    System.out.println(x.getName() + " -  ссыт в тапки.");
                    System.out.println("Коту хотелось " + x.getAppetite()+ " единиц еды.");
                    needFood += x.getAppetite();
                }
            }
            if (needFood != 0) {
                needFood = needFood - plate.getFood();
                System.out.println("В тарелке осталось " + plate.getFood()+ " единиц еды.");
                System.out.println("Промазнулись на  " + needFood + " единиц еды.");
            }
            return;

        }


    }

    public static void initialAppetite(HungryCat[] Arr) {
        for (int i = 0; i < 5; i++) {
            int app = (int) (Math.random() * 15);
            Arr[i].setAppetite(app);
        } // установили аппетит
    }


}
