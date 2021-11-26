package com.pb.avrakhov.hw10;

import java.util.Arrays;

/**
 * Создать пакет hw10. Реализовать параметризованный класс NumBox, T - параметр типа. Параметром должен быть любой
 * класс-наследник Number (задать необходимое условие при объявлении класса NumBox). При подсчете воспользоваться тем,
 * что у любого из объектов подклассов Number есть методы intValue, doubleValue, floatValue и другие.
 */
public class NumBox<T extends Number> {
    private final T[] numbers;  //массив из объектов класса T, инициализировать массив в конструкторе

    //конструктор принимающий параметр - максимальную длину массива.
    public NumBox(int size) {
        this.numbers = (T[]) new Number[size];
    }

    //метод void add(T num) добавляющий число в массив. В случае если массив полон - выбросить исключение.
    public void add(T num) throws ArrayIsFull {
        Boolean myCase = true;

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == null) {
                numbers[i] = num;
                myCase = false;
                break;
            }
        }

        if(myCase) {
            throw new ArrayIsFull("Array is full!");
        }
    }

    //метод T get(int index) возвращающий число по индексу.
    public T get(int index) {
        return numbers[index];
    }

    //метод int length() возвращает текущее количество элементов.
    public int length() {
        int len = 0;

        for(T i: numbers) {
            if(i != null) {
                len += 1;
            }
        }

        return len;
    }

    //метод double average() - подсчет среднего арифметического среди элементов массива.
    public double average() {
        double av = 0;
        int count = 0;

        for(T i: numbers) {
            if(i != null) {
                av += i.doubleValue();
                count += 1;
            }
        }

        return (av / count);
    }

    //метод double sum() - сумма всех элементов массива.
    public double sum() {
        double sum = 0;

        for(T i: numbers) {
            if(i != null) {
                sum += i.doubleValue();
            }
        }

        return sum;
    }

    //метод T max() - максимальный элемент массива.
    public T max() {
        T[] array = numbers.clone();
        Arrays.toString(array);
        Arrays.sort(array);
        return array[(array.length - 1)];
    }
}
