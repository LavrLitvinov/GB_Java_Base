package Lesson5;

public class Person {
    public static void main(String[] args) {
        PersColegue[] arrPers = new PersColegue[5];
        arrPers[0] = new PersColegue("Водяной Мокрый", "Водяной", "voda@tina.boloto", "+ кудато-там", 86, 411);
        arrPers[1] = new PersColegue("Ведьма Лесная", "Ведьма", "chascha@les.info", "+ V Les!", 87, 4110);
        arrPers[2] = new PersColegue("Kащей Бессмертнов", "Кащей на ставке", "Kaschei@les.info", "+ V Les i Les!", 56, 5610);
        arrPers[3] = new PersColegue("Домовой Избов", "Нянька", "dom_sad@les.info", "+ V Dom!", 98, 4180);
        arrPers[4] = new PersColegue("Изба Хоромная", "Здание Дворцовое", "I_am_house@les.info", "+ V Les Dom", 67, 4910);

        if (arrPers[0].getAge() > 4000) {
            System.out.println("Имя: " + arrPers[0].getName() + "     " + "Должность: " + arrPers[0].getPosition());

        }

    }
}


class PersColegue {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }


    public PersColegue(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }


}
