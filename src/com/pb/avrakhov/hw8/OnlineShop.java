package com.pb.avrakhov.hw8;

import java.util.Scanner;

/**
 * Создать класс OnlineShop с методом main. В main создать один объект класса Auth. Предложить пользователю сперва
 * зарегистрироваться (signUp) потом войти на сайт (signIn). Обработать исключения методов signUp signIn с помощью
 * блоков try-catch.
 */
public class OnlineShop {
    public static void main(String[] args) {
        Auth auth = null;
        String login, pw, cpw;
        Scanner in = new Scanner(System.in);

        System.out.println("Регистрация в Онлайн Магазине. Введите Логин:");
        login = in.nextLine();

        System.out.println("Введите пароль:");
        pw = in.nextLine();

        System.out.println("Повторите пароль:");
        cpw = in.nextLine();

        try {
            auth = new Auth(login, pw, cpw);
        } catch (WrongLoginException | WrongPasswordException exception) {
            exception.getMessage();
            exception.printStackTrace();
        }

        System.out.println("Вход в Онлайн Магазине. Введите Логин:");
        login = in.nextLine();

        System.out.println("Введите пароль:");
        pw = in.nextLine();

        try {
            auth.signIn(login, pw);
        } catch (WrongLoginException exception) {
            exception.getMessage();
            exception.printStackTrace();
        }
    }
}
