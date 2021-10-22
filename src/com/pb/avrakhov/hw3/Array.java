package com.pb.avrakhov.hw3;

import java.util.Scanner;

/*
Создайте класс Array в пакете hw3. Программа должна позволить пользователю ввести одномерный массив целых чисел
размерностью 10 элементов. Вывести на экран введенный массив. Подсчитать сумму всех элементов массива и вывести ее на
экран. Подсчитать и вывести на экран количество положительных элементов. Произвести сортировку этого массива от меньшего
к большему по алгоритму сортировки пузырьком. (https://en.wikipedia.org/wiki/Bubble_sort) Вывести на экран
отсортированный массив.
 */
public class Array {
    public static void main(String[] args) {
        int[] array = new int[10];          //Заданный массив
        int counter = 0;                    //Счетчик
        int sum = 0;                        //Сумма всех элементов массива
        Scanner in = new Scanner(System.in);

        //Запрашиваем у Пользователя массив
        do {
            System.out.print("Введите " + (counter + 1) + " число: ");
            int userNumber = in.nextInt();
            array[counter] = userNumber;
            counter++;
        } while (counter < 10);

        //Выводим массив
        System.out.println("Вы ввели следующие значения:");
        for (int i : array) {
            System.out.print(i + "  ");
        }

        //Выводим сумму всех элементов массива
        System.out.print("\nСумма всех элементов массива равна: ");
        for (int i : array) {
            sum += i;
        }
        System.out.print(sum);

        //Выводим количество положительных значений
        System.out.print("\nКоличество положительных элементов: ");
        counter = 0;
        for (int i : array) {
            if (i >= 0) {
                counter++;
            }
        }
        System.out.print(counter);

        //Сортировка пузырьком (Bubble sort)
        System.out.println("\nСортированнный массив:");
        for (int i = (array.length - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int i : array) {
            System.out.print(i + "  ");
        }
    }
}
