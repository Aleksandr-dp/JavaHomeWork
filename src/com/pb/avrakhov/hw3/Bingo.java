package com.pb.avrakhov.hw3;

import java.util.Scanner;

/*
Создайте класс Bingo в пакете hw3. Программа должна загадать целое число в диапазоне от 0 до 100 и предложить
пользователю его отгадать. При вводе числа пользователем, программа проверяет на соответствие с загаданным число и если
числа совпали вывести сообщение о том, что число отгадано. Если числа не совпали, тогда следует вывести надпись о том,
что задуманное число является больше или меньше вводимого. Также программа ведет подсчет попыток, и выводит это
количество после того как число угадали. Предусмотреть возможность досрочного завершения программы, в случае если
пользователь не желает продолжать угадывать число.
 */
public class Bingo {
    public static void main(String[] args) {
        int hiddenNumber = (int) (Math.random() * 101); //Загаданное число
        Scanner in = new Scanner(System.in);
        int counter = 0;                                //Количество попыток (+1)
        int[] array = new int[100];                     //Числа пользователя

        System.out.print("Игра \u00ABBingo\u00BB. Отгадайте число от 0 до 100. Для выхода введите: 111.\n\n"); //Заголовок

        while (true) {
            System.out.print("Введите число от 0 до 100: ");
            int userNumber = in.nextInt();                      //Число пользователя

            //Проверка, если число выходит за заданный диапазон
            if (userNumber < 0 || (userNumber > 100 && userNumber != 111)) {
                System.out.println("Вы ввели не корректное число! (Диапозон от 0 до 100)");
                continue;
            }

            //Выход из Игры
            if (userNumber == 111) {
                System.out.print("Вы не угадали загаданное число " + hiddenNumber + "\n" + "Количество попыток: " + counter);
                break;
            }

            //Проверка, если Пользователь уже загадывал введенное число
            if (counter == 0) {             //Если первая итерация, записываем значение
                array[counter] = userNumber;
            } else {
                //Проверяем по массиву было ли это число ранее
                for (int i = 0; i < counter; i++) {
                    if (array[i] == userNumber) {
                        System.out.println("Вы уже загадывали данное число:");

                        //Вывод массива с попытками
                        for (int j = 0; j < counter; j++) {
                            System.out.print(array[j] + "  ");
                        }

                        System.out.print("\n");
                        counter--;
                        break;
                    } else {
                        array[counter] = userNumber;    //Записываем значение в массив
                    }
                }
            }

            //Проверяем число Пользователя
            if (userNumber == hiddenNumber) {
                System.out.print("Поздравляем! Вы угадали число: " + hiddenNumber + "\n" + "Количество попыток: " + (counter + 1));
                break;
            } else if (userNumber < hiddenNumber) {
                System.out.println("Загаданное число больше " + userNumber);
                counter++;
            } else {
                System.out.println("Загаданное число меньше " + userNumber);
                counter++;
            }
        }
    }
}
