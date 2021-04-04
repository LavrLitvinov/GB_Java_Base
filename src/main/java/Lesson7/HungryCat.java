package Lesson7;

public class HungryCat {

    private String name;
    private int appetite;
    private boolean satiety;
    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

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


    public HungryCat(String name, int appetite, boolean satiety, int flag){
        this.appetite = appetite;
        this.name = name;
        this.satiety = satiety;
        this.flag = flag;
    }

    public void eat(Plate pl) {
        pl.decriazeFood(appetite);
    }




}

