package com.pb.avrakhov.hw2;

import java.util.Scanner;

/*
Напишите программу определения интервала. Создайте класс Interval в пакете hw2. Предложите пользователю ввести целое
число и сохраните его в переменную с произвольным именем. Программа должна выяснить в какой промежуток попадает
введенное число [0 - 14] [15 - 35] [36 - 50] [51 - 100]. Вывести на экран сообщение с подходящим промежутком. Если
введенное число не попадает в один из имеющихся промежутков, то вывести соответствующее сообщение.
 */
public class Interval {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number;

        System.out.print("Введите число: ");
        number = in.nextInt();

        if (number < 0) {
            System.out.print("Число " + number + " меньше заданого интервала.");
        } else if (number > 100) {
            System.out.print("Число " + number + " больше заданого интервала.");
        } else if (number >= 0 && number <= 14) {
            System.out.print("Число " + number + " в промежутке [0 - 14].");
        } else if (number >= 15 && number <= 35) {
            System.out.print("Число " + number + " в промежутке [15 - 35].");
        } else if (number >= 36 && number <= 50) {
            System.out.print("Число " + number + " в промежутке [36 - 50].");
        } else {
            System.out.print("Число " + number + " в промежутке [51 - 100].");
        }
    }
}
