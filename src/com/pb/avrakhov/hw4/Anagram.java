package com.pb.avrakhov.hw4;

import java.util.Arrays;
import java.util.Scanner;

/*
Создайте класс Anagram в пакете hw4. Напишите программу, которая определяет, является ли одна строка анаграммой другой
строки. Обе строки вводит пользователь. Программа должна игнорировать пробелы и знаки препинания. При выполнении задания
использовать метод(ы).
Пример анаграмм:
Аз есмь строка, живу я, мерой остр. -> За семь морей ростка я вижу рост.
Я в мире — сирота. -> Я в Риме — Ариост.
 */
public class Anagram {
    //Убираем знаки препинания и переводим строку в нижний регистр
    static String getLetters(String str) {
        return str.replaceAll("[\\p{P}‘ ]", "").toLowerCase();
    }

    //Преобразуем строку в массив
    static char[] sortString(String str) {
        String original = getLetters(str);
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        return chars;
    }

    public static void main(String[] args) {
        String firstString, secondString;
        char[] firstArray, secondArray;
        Scanner in = new Scanner(System.in);

        System.out.println("Введите первую строку:");
        firstString = in.nextLine();

        System.out.println("Введите вторую строку:");
        secondString = in.nextLine();

        //Получаем массивы из букв
        firstArray = sortString(firstString);
        secondArray = sortString(secondString);

        //Сравниваем массивы
        if (Arrays.equals(firstArray, secondArray)) {
            System.out.println("Строка \u00AB" + firstString + "\u00BB является анаграммой строки \u00AB" + secondString + "\u00BB.");
        } else {
            System.out.println("Строка \u00AB" + firstString + "\u00BB не является анаграммой строки \u00AB" + secondString + "\u00BB.");
        }
    }
}
