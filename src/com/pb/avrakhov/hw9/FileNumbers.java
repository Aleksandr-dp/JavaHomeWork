package com.pb.avrakhov.hw9;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

/**
 * В нем создать методы:
 * - createNumbersFile - создает текстовый файл "numbers.txt" заполненный случайными целыми числами от 1 до 99. 10 строк
 * и по 10 чисел в каждой строке. Числа разделять пробелами.
 * - createOddNumbersFile - читает файл "numbers.txt", и создает на основе него новый файл "odd-numbers.txt" в который
 * входят все числа из "numbers.txt" только все четные заменены на 0.
 * В методе main продемонстрировать работу методов createNumbersFile и createOddNumbersFile.
 * По желанию можно добавить логирование работы программы.
 */
public class FileNumbers {
    static final String PATH = "src\\com\\pb\\avrakhov\\hw9\\files\\";
    static String data = "";

    public static void main(String[] args) throws IOException, NumberFormatException {
        createNumbersFile();        //Создаем файл с числами
        createOddNumbersFile();     //Меняем четные на 0
    }

    public static void createNumbersFile() {
        try (Writer writer = new FileWriter(PATH + "numbers.txt")){
            //Создаем строки
            for (int j = 0; j < 10; j++){
                //Заполняем числами
                for (int i = 0; i < 10; i++) {
                    data += (int) (1 + Math.random() * 98) + " ";
                }
                data += "\n";
            }

            writer.write(data);     //Заносим все в файл
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    //Создаем новый файл с нечетными числами
    public static void createNumbersFile(String newData) {
        try (Writer writer = new FileWriter(PATH + "odd-numbers.txt")){
            writer.write(newData);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void createOddNumbersFile() throws NumberFormatException {
        Path path = Paths.get(PATH + "numbers.txt");
        data = "";

        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            for (String string: lines) {
                String[] words = string.split(" ");     //Получаем массив из чисел одной строки

                //Приводим к числу и проверяем на четность
                for (String word: words) {
                    try {
                        int integer = Integer.parseInt(word.trim());

                        if ((integer % 2) > 0) {
                            data += word + " ";
                        } else {
                            data += "0 ";
                        }
                    } catch (NumberFormatException exception) {
                        System.out.println("NumberFormatException: " + exception.getMessage());
                    }
                }

                data += "\n";
            }

            createNumbersFile(data);        //Создаем новый файл
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
