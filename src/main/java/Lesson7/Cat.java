package Lesson7;

public class Cat {

    private String name;
    private int appetite;

    public void setName(String name) {
        this.name = name;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }


    public Cat (String name, int appetite){
        this.appetite = appetite;
        this.name = name;
    }

    public void eat(Plate pl) {
        pl.decriazeFood(appetite);
    }




}

