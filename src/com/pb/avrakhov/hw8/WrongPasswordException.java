package com.pb.avrakhov.hw8;

/**
 * WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по
 * умолчанию, второй принимает сообщение и передает его в конструктор класса Exception.
 */
public class WrongPasswordException extends Exception {

    public WrongPasswordException() {
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
