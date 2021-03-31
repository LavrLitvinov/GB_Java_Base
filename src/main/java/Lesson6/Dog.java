package Lesson6;

public class Dog extends Animal {
    public static int dogCount;

    public Dog (){
        dogCount++;
    }

    @Override
    public void animalRun(int dist) {
        if (dist > 500) {
            System.out.println("Офигеть, как далеко! Сам беги за этой палкой!");
        } else {
            System.out.println("Бобик пробежал " + dist + " метров!");
        }
    }

    @Override
    public void animalSwim(int dist) {
        if(dist > 10){
            System.out.println("Офигеть, как далеко! Я могу утонуть! Сам плыви!");
        }
        else {
            System.out.println("Бобик уплыл на "+ dist+ " метров!");
        }

    }

}