package Lesson6;

public class Cat extends Animal {
    public static int catCount;


    public Cat() {
        catCount++;
    }

    public static int getcatCount() {
        return catCount;
    }

    @Override
    public void animalRun(int dist) {
        if(dist > 200){
            System.out.println("Я кот! Так далеко собаку гоняй!");
        }
        else {
            System.out.println("Кот убежал на  "+ dist+ " метров!");
        }

    }

    @Override
    public void animalSwim(int dist) {
        System.out.println("Проплыть? Серьезно? ");
        System.out.println("Коты не любят плавать! ");
    }

}
