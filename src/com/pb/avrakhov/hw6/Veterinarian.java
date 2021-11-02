package com.pb.avrakhov.hw6;

/**
 * Создайте класс Veterinarian (Ветеринар), в котором определите метод void treatAnimal(Animal animal). Пусть этот
 * метод печатает на экран food и location пришедшего на прием животного.
 */
public class Veterinarian {
    public void treatAnimal(Animal animal) {
        System.out.println("Food: " + animal.getFood() + "; Location: " + animal.getLocation());
    }
}
