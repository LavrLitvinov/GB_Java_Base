package Lesson6;
// Надо бы метод сопряжения числительного и окончания написать для красивого вывода.
import java.util.Scanner;

public class AnimalTest {

    public static void main(String[] args) {
        int dista = 0;
        Scanner sc = new Scanner(System.in);
       // Cat cat = new Cat();
      //  Dog dog = new Dog();
        while (true){
            Cat cat = new Cat();
            Dog dog = new Dog();
            System.out.print("На сколько метров закинем палку для собаки? ");
            dista = sc.nextInt();
            dog.animalRun(dista);
            System.out.print("На сколько метров закинем палку в воду для собаки? ");
            dista = sc.nextInt();
            dog.animalSwim(dista);
            System.out.println("Как далеко пошлем кота?");
            dista = sc.nextInt();
            cat.animalRun(dista);
            System.out.println("Сколько метров плыть коту?");
            dista = sc.nextInt();
            cat.animalSwim(dista);
            System.out.println("Котов наплодили: " + cat.catCount);
            System.out.println("В стае псов : " + dog.dogCount);
            System.out.println("Продолжим гонять животных? 1 - да!");
            dista = sc.nextInt();
            if(dista != 1) return;

        }

    }


}
