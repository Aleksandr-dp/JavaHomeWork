package com.pb.avrakhov.hw2;

import java.util.Scanner;

/*
Создайте класс Calculator в пакете hw2. Создайте две целочисленных переменные. Также предложите пользователю ввести знак
арифметической операции и поместите его в строковую переменную. Пусть калькулятор может только складывать, отнимать,
умножать и делить. Для организации выбора алгоритма вычислительного процесса, используйте переключатель switch.
Выведите на экран результат выполнения арифметической операции. В случае использования операции деления, организуйте
проверку попытки деления на ноль. И если таковая имеется, то отмените выполнение арифметической операции и уведомите об
ошибке пользователя.
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number1, number2;
        String operation;

        System.out.print("Введите первое число: ");
        number1 = in.nextInt();

        System.out.print("Введите операцию: ");
        operation = in.next();

        System.out.print("Введите второе число: ");
        number2 = in.nextInt();

        switch (operation) {
            case "+":
                System.out.print(number1 + " " + operation + " " + number2 + " = " + (number1 + number2));
                break;
            case "-":
                System.out.print(number1 + " " + operation + " " + number2 + " = " + (number1 - number2));
                break;
            case "*":
                System.out.print(number1 + " " + operation + " " + number2 + " = " + (number1 * number2));
                break;
            case "/":
                if(number2 == 0) {
                    System.out.print("Деление на ноль недопустимо!");
                } else {
                    System.out.print(number1 + " " + operation + " " + number2 + " = " + (number1 / number2));
                }
                break;
            default:
                System.out.print("Недопустимое значение!");
                break;
        }
    }
}
