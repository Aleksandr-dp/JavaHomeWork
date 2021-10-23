package com.pb.avrakhov.hw4;

import java.util.Scanner;

/*
Создайте класс CapitalLetter в пакете hw4. Напишите программу, которая принимает строку и переводит первую букву слова
в верхний регистр. Строку должен ввести пользователь. При выполнении задания использовать метод(ы).
Пример работы:
Истина — это то, что выдерживает проверку опытом. Эйнштейн А.
Истина — Это То, Что Выдерживает Проверку Опытом. Эйнштейн А.
 */
public class CapitalLetter {
    //Переводим строку в верхний регистр
    static void toUpperCase(String str) {
        String upperCaseString = "";

        for (String word : str.split(" ")) {
            upperCaseString += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
        }

        upperCaseString = upperCaseString.substring(0, (upperCaseString.length() - 1)); //Удаляем последний пробел

        System.out.println(upperCaseString);
    }

    public static void main(String[] args) {
        String userString;
        Scanner in = new Scanner(System.in);

        System.out.println("Введите строку:");
        userString = in.nextLine();

        toUpperCase(userString);
    }
}
