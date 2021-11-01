package com.pb.avrakhov.hw5;

/**
 * Класс Library используется как демонстрация работы классов Book и Reader. Имеет метод main() в котором создается
 * массивы объектов Book и Reader, по 3 или более элементов в каждом. Выполняются такие действия:
 * - печатаются все книги.
 * - печатаются все читатели.
 * - демонстрируется работа всех вариантов методов takeBook() и returnBook().
 */
public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Буратино", "А.Н. Толстой", 1936);
        Book book2 = new Book("Дон Кихот", "Мигель де Сервантес", 1600);
        Book book3 = new Book("Портрет Дориана Грея", "Оскар Уайльд", 1890);
        Book book4 = new Book("Преступление и наказание", "Достоевский Ф.М.", 1868);

        Reader reader1 = new Reader("Avrakhov A.I.", "N1", "Economic", "30.11.1985", "+380976664230");
        Reader reader2 = new Reader("Ivanov I.I.", "47", "Gumanitariy", "15-10-1991", "0976014230");
        Reader reader3 = new Reader("Сидоров С.С.", "NF5", "Кибернетика", "03.05.1988", "380976764230");
        Reader reader4 = new Reader("Петров П.П.", "N2", "Математики", "01/01/2001", "+380986564230");

        book1.getBookInfo();
        book2.getBookInfo();
        book3.getBookInfo();
        book4.getBookInfo();
        System.out.print("\n");

        reader1.getUserInfo();
        reader2.getUserInfo();
        reader3.getUserInfo();
        reader4.getUserInfo();
        System.out.print("\n");

        reader2.takeBook(7);
        reader1.takeBook("Буратино", "Словарь", "Дон Кихот");
        reader3.takeBook(book1, book2, book4);
        System.out.print("\n");

        reader4.returnBook(12);
        reader1.returnBook("Дон Кихот", "Портрет Дориана Грея", "Золотой теленок");
        reader2.returnBook(book1, book3);
    }
}
