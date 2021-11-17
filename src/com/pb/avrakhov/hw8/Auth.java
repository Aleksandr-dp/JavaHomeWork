package com.pb.avrakhov.hw8;

import java.util.Objects;

/**
 * Создать класс Auth, который содержит поля login и password и методы:
 * - signUp (регистрация на сайте) принимающий login, password, и confirmPassword. Проверяет параметр login, длинна
 * должна быть от 5 до 20 символов. Login должен содержать только латинские буквы и цифры. Если логин не соответствует
 * требованиям нужно выбросить WrongLoginException. Проверяет параметр password, длинна более 5, только латинские буквы
 * и цифры и знак подчеркивания. Также password и confirmPassword должны совпадать. Если password не соответствует
 * требованиям нужно выбросить WrongPasswordException. Если проверки все пройдены успешно записать в свои поля значение
 * login и password.
 * - signIn (вход на сайт) принимающий login и password. Проверяет что login и password соответствуют значениям из полей
 * класса. Если нет - выбрасывает исключение WrongLoginException.
 */
public class Auth {
    private String login;
    private String pw;
    private final String RegExLogin = "^[a-zA-Z\\d]+$";
    private final String RegExPW = "^[a-zA-Z\\d_]+$";

    public Auth(String login, String pw, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        signUp(login, pw, confirmPassword);
    }

    private void signUp(String login, String pw, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if(login == null || login.length() < 5 || login.length() > 20 || !login.matches(RegExLogin)) {
            System.out.println("Регистрация не пройдена!");
            throw new WrongLoginException("Wrong Login!");
        } else {
            this.login = login;
        }

        if(pw == null || pw.length() < 6 || !pw.matches(RegExPW) || !pw.equals(confirmPassword)) {
            System.out.println("Регистрация не пройдена!");
            throw new WrongPasswordException("Wrong Password!");
        } else {
            this.pw = pw;
        }

        System.out.println("Поздравляем! Вы успешно зарегестрировались!");
    }

    public void signIn(String login, String pw) throws WrongLoginException {
        if(login.equals(this.login) && pw.equals(this.pw)) {
            System.out.println("Приветствуем, " + this.login + "!");
        } else {
            System.out.println("Авторизация не пройдена!");
            throw new WrongLoginException("Wrong Login or Password!");
        }
    }

    @Override
    public String toString() {
        return "Auth{" +
                "login='" + login + '\'' +
                ", pw='" + pw + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auth auth = (Auth) o;
        return Objects.equals(login, auth.login) && Objects.equals(pw, auth.pw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, pw);
    }
}
