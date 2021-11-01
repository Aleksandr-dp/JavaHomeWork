package com.pb.avrakhov.hw5;

import java.time.Year;
import java.util.Objects;

/**
 * Класс Book хранит такую информацию о книге: название, автор книги, год издания.
 */
public class Book {
    private String bookName;
    private String writer;
    private int yearOfPublishing;
    private final String REGEX = "^[a-zA-Zа-яА-ЯЁё\\s-.]+$";
    private final int year = Year.now().getValue();
    private String errors = "";

    /**
     * Конструктор принимает 3 параметра и записывет поля:
     * @param bookName - Название книги (Больше 3-х символов)
     * @param writer - Автор книги (Буквы и больше 3-х символов)
     * @param yearOfPublishing - Год издания (Больше текущего)
     */
    public Book(String bookName, String writer, int yearOfPublishing) {
        setBookName(bookName);
        setWriter(writer);
        setYearOfPublishing(yearOfPublishing);
    }

    public void setBookName(String bookName) {
        if(bookName == null || bookName.length() <= 3) {
            errors += "Наименование книги введено неверно!\n";
        } else {
            this.bookName = bookName;
        }
    }

    public void setWriter(String writer) {
        if(writer == null || writer.length() <= 3 || !writer.matches(REGEX)) {
            errors += "Имя автора введено неверно!\n";
        } else {
            this.writer = writer;
        }
    }

    //868 - Первая точно датированная печатная книга - буддийская «Алмазная сутра» - была издана 11 мая 868 года.
    public void setYearOfPublishing(int yearOfPublishing) {
        if(yearOfPublishing > year || yearOfPublishing < 868) {
            errors += "Год издания введено неверно!";
        } else {
            this.yearOfPublishing = yearOfPublishing;
        }
    }

    public String getBookName() {
        return bookName;
    }

    public String getWriter() {
        return writer;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    /**
     * Проверяем поле errors. Если есть ошибки выводим errors, если нет - информацию о книге
     */
    public void getBookInfo() {
        if (Objects.equals(errors, "")) {
            System.out.println("Название: " + bookName + "; Автор книги: " + writer + "; Год издания: " + yearOfPublishing);
        } else {
            System.out.println(errors);
        }
    }
}
