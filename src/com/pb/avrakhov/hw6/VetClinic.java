package com.pb.avrakhov.hw6;

import java.lang.reflect.Method;

/**
 * Создайте класс VetClinic в его методе main создайте массив типа Animal, в который запишите животных всех имеющихся
 * у вас типов. В цикле отправляйте животных на прием к ветеринару. Объект класса Veterinarian создайте с помощью рефлексии.
 */
public class VetClinic {
    public static void main(String[] args) throws Exception {
        Animal animal = new Animal();
        Dog dog = new Dog("Собака", "Гав", "Мясо", "Конура");
        Cat cat = new Cat("Кот", "Мяу", "Молоко", "Где попало");
        Horse horse = new Horse("Лошадь", "Иго-го", "Сено", "Конюшня");

        //Массив с животными
        Animal[] animals = new Animal[] {dog, cat, horse};

        System.out.println("food и location пришедшего на прием животного:");

        //Объект класса Veterinarian с помощью рефлексии
        Class<Veterinarian> clazz = Veterinarian.class;
        Method method = clazz.getMethod("treatAnimal", Animal.class);
        for (Animal i: animals) {
            Object o = clazz.newInstance();
            method.invoke(o, i);
        }

        //Класс Животное
        System.out.println("\nТест классов:\n--- Animal ---");
        animal.makeNoise();
        animal.eat();
        animal.sleep("Животное");

        //Класс Собака
        System.out.println("--- Dog ---");
        dog.makeNoise();
        dog.eat();
        dog.sleep(dog.getNameAnimal());

        //Класс Кот
        System.out.println("--- Cat ---");
        cat.makeNoise();
        cat.eat();
        cat.sleep(cat.getNameAnimal());

        //Класс Лошадь
        System.out.println("--- Horse ---");
        horse.makeNoise();
        horse.eat();
        horse.sleep(horse.getNameAnimal());
    }
}
