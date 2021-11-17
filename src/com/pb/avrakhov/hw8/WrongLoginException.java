package com.pb.avrakhov.hw8;

/**
 * WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по
 * умолчанию, второй принимает сообщение и передает его в конструктор класса Exception.
 */
public class WrongLoginException extends Exception {

    public WrongLoginException() {
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
