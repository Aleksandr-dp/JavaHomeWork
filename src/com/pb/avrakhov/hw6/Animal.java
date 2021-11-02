package com.pb.avrakhov.hw6;

/**
 * В пакете hw6 создайте класс Animal и расширяющие его классы Dog, Cat, Horse. Класс Animal содержит переменные food,
 * location и методы makeNoise, eat, sleep. Метод sleep, например, может выводить на консоль "Такое-то животное спит".
 */
public class Animal {
    private String food = "еду";
    private String location = "чем-то";

    //Для Конструктора животных
    public void setFood(String food) {
        this.food = food;
    }

    //Для Конструктора животных
    public void setLocation(String location) {
        this.location = location;
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }

    public void makeNoise() {
        System.out.println("Животное издает звук.");
    }

    public void eat() {
        System.out.println("Животное ест " + food + ".");
    }

    public void sleep(String animal) {
        System.out.println(animal + " спит в " + location + ".");
    }
}
