package Lesson7;

public class MainTest {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Брысер",5);
        Plate plate1 = new Plate(100);
        plate1.infoPlate();
       // cat1.eat(plate1);
        //plate1.infoPlate();
        plate1.setFood(plate1.getFood() - cat1.getAppetite());
        plate1.infoPlate();

    }
}
