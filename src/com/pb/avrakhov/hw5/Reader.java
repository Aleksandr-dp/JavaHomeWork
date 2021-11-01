package com.pb.avrakhov.hw5;

import java.util.Objects;

/**
 * Класс Reader хранит такую информацию о пользователе библиотеки: ФИО, номер читательского билета, факультет, дата
 * рождения, телефон. Типы полей выбирать на свое усмотрение.
 *
 * Имеет перегруженные методы takeBook(), returnBook():
 * - takeBook, который будет принимать количество взятых книг. Выводит на консоль сообщение: "Петров В. В. взял 3 книги".
 * - takeBook, который будет принимать переменное количество названий книг. Выводит на консоль сообщение: "Петров В. В.
 * взял книги: Приключения, Словарь, Энциклопедия".
 * - takeBook, который будет принимать переменное количество объектов класса Book. Выводит на консоль сообщение: "Петров В. В.
 * взял книги: Приключения (Иванов И. И. 2000 г.), Словарь (Сидоров А. В 1980 г.), Энциклопедия (Гусев К. В. 2010 г.)".
 *
 * Аналогичным образом перегрузить метод returnBook().
 * Должно быть 3 метода returnBook() которые выводит на консоль сообщения:
 * - "Петров В. В. вернул 3 книги"
 * - "Петров В. В. вернул книги: Приключения, Словарь, Энциклопедия".
 * - "Петров В. В. вернул книги: Приключения (Иванов И. И. 2000 г.), Словарь (Сидоров А. В 1980 г.), Энциклопедия (Гусев К. В. 2010 г.)".
 */
public class Reader {
    private String userName;
    private String libraryCard;
    private String faculty;
    private String dateOfBirth;
    private String phone;
    private final String REDATE = "\\d{2}\\W\\d{2}\\W\\d{4}";
    private final String REPHONE = "^[+0-9]+$";
    private String errors = "";

    /**
     * Конструктор принимает 5 параметров и записывет поля:
     * @param userName - ФИО читателя (Больше 3-х символов)
     * @param libraryCard - Номер читательского билета (Больше 0)
     * @param faculty - Факультет (Больше 3-х символов)
     * @param dateOfBirth - Дата рождения (ДД ММ ГГГГ, пробелы - любые символы)
     * @param phone - Телефон (Не меньше 10 цифр, включая +)
     */
    public Reader(String userName, String libraryCard, String faculty, String dateOfBirth, String phone) {
        setUserName(userName);
        setLibraryCard(libraryCard);
        setFaculty(faculty);
        setDateOfBirth(dateOfBirth);
        setPhone(phone);
    }

    public void setUserName(String userName) {
        if(userName == null || userName.length() <= 3) {
            errors += "ФИО читателя введено неверно!\n";
        } else {
            this.userName = userName;
        }
    }

    public void setLibraryCard(String libraryCard) {
        if(libraryCard == null || libraryCard.length() == 0) {
            errors += "Номер читательского билета введен неверно!\n";
        } else {
            this.libraryCard = libraryCard;
        }
    }

    public void setFaculty(String faculty) {
        if(faculty == null || faculty.length() <= 3) {
            errors += "Факультет введен неверно!\n";
        } else {
            this.faculty = faculty;
        }
    }

    public void setDateOfBirth(String dateOfBirth) {
        if(dateOfBirth == null || dateOfBirth.length() != 10 || !dateOfBirth.matches(REDATE)) {
            errors += "Дата рождения введена неверно (ДД ММ ГГГГ)!\n";
        } else {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public void setPhone(String phone) {
        if(phone == null || phone.length() < 10 || !phone.matches(REPHONE)) {
            errors += "Телефон введен неверно!";
        } else {
            this.phone = phone;
        }
    }

    /**
     * Проверяем поле errors. Если есть ошибки возвращаем errors, если нет - информацию о Читателе
     */
    public void getUserInfo() {
        if (Objects.equals(errors, "")) {
            System.out.println("ФИО: " + userName + "; Номер билета: " + libraryCard + "; Факультет: " + faculty +
                               "; Дата рождения: " + dateOfBirth + "; Телефон: " + phone);
        } else {
            System.out.println(errors);
        }
    }

    /**
     * Принимает количество взятых книг. Выводит на консоль сообщение: "Петров В. В. взял 3 книги".
     */
    public void takeBook(int booksCount) {
        if (booksCount > 0) {
            System.out.println(userName + " взял " + booksCount + " книг.");
        } else {
            System.out.println("Вы ввели некоректное число!");
        }
    }

    /**
     * Принимает переменное количество названий книг. Выводит на консоль сообщение: "Петров В. В. взял книги: Приключения,
     * Словарь, Энциклопедия".
     */
    public void takeBook(String... booksName) {
        StringBuilder allNames = new StringBuilder();

        for(String str: booksName) {
            allNames.append(str).append(", ");
        }

        System.out.println(userName + " взял книги: " + allNames.substring(0, (allNames.length() - 2)) + ".");
    }

    /**
     * Принимает переменное количество объектов класса Book. Выводит на консоль сообщение: "Петров В. В. взял книги:
     * Приключения (Иванов И. И. 2000 г.), Словарь (Сидоров А. В 1980 г.), Энциклопедия (Гусев К. В. 2010 г.)".
     */
    public void takeBook(Book... book) {
        StringBuilder info = new StringBuilder();

        for(Book i: book) {
            info.append(i.getBookName()).append(" (").append(i.getWriter()).append(" ").append(i.getYearOfPublishing()).append(" г.), ");
        }

        System.out.print(userName + " взял книги: " + info.substring(0, (info.length() - 2)) + ".\n");
    }

    /**
     * Принимает количество возвращеннных книг. Выводит на консоль сообщение: "Петров В. В. вернул 3 книги".
     */
    public void returnBook(int booksCount) {
        if (booksCount > 0) {
            System.out.println(userName + " вернул " + booksCount + " книг.");
        } else {
            System.out.println("Вы ввели некоректное число!");
        }
    }

    /**
     * Принимает переменное количество названий книг. Выводит на консоль сообщение: "Петров В. В. вернул книги: Приключения,
     * Словарь, Энциклопедия".
     */
    public void returnBook(String... booksName) {
        StringBuilder allNames = new StringBuilder();

        for(String str: booksName) {
            allNames.append(str).append(", ");
        }

        System.out.println(userName + " вернул книги: " + allNames.substring(0, (allNames.length() - 2)) + ".");
    }

    /**
     * Принимает переменное количество объектов класса Book. Выводит на консоль сообщение: "Петров В. В. вернул книги:
     * Приключения (Иванов И. И. 2000 г.), Словарь (Сидоров А. В 1980 г.), Энциклопедия (Гусев К. В. 2010 г.)".
     */
    public void returnBook(Book... book) {
        StringBuilder info = new StringBuilder();

        for(Book i: book) {
            info.append(i.getBookName()).append(" (").append(i.getWriter()).append(" ").append(i.getYearOfPublishing()).append(" г.), ");
        }

        System.out.print(userName + " вернул книги: " + info.substring(0, (info.length() - 2)) + ".");
    }
}
