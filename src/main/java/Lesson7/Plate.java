package Lesson7;

import java.util.Scanner;

public class Plate {

    private int food;

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public Plate(int food){
        this.food = food;
    }


    public void decriazeFood(int n){
        food -= n;
    }

    public void infoPlate(){
        System.out.println("plate: " + food);
    }

    public void incrizeFood(int n){
        food += n;
    }

    public Plate() {

    }


}
