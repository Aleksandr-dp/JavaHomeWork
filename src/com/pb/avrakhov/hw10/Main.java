package com.pb.avrakhov.hw10;

import java.text.DecimalFormat;

/**
 * Создать класс Main с методом main где протестировать полученный класс на примере NumBox<Float> и NumBox<Integer>.
 */
public class Main {
    public static void main(String[] args) throws ArrayIsFull {
        NumBox<Float> numFloat = new NumBox<>(4);
        NumBox<Integer> numInteger = new NumBox<>(3);
        DecimalFormat df = new DecimalFormat(".##");

        numFloat.add(3.58F);
        numFloat.add(2.1F);
        numFloat.add(15.363F);
        numFloat.add(1.222F);
        //numFloat.add(4.7F); // Exception

        numInteger.add(5);
        numInteger.add(9);
        numInteger.add(42);
        //numInteger.add(5);  // Exception

        System.out.println("Метод T get(int index) возвращающий число по индексу: " + numFloat.get(2) + "; " + numInteger.get(1));
        System.out.println("Метод int length() возвращает текущее количество элементов: " + numFloat.length() + "; " + numInteger.length());
        System.out.println("Метод double average() - подсчет среднего арифметического среди элементов массива: " + df.format(numFloat.average()) + "; " + df.format(numInteger.average()));
        System.out.println("Метод double sum() - сумма всех элементов массива: " + df.format(numFloat.sum()) + "; " + df.format(numInteger.sum()));
        System.out.println("Метод T max() - максимальный элемент массива: " + numFloat.max() + "; " + numInteger.max());
    }
}
