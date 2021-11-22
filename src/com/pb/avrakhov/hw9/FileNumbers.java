package com.pb.avrakhov.hw9;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.logging.*;

/**
 * В нем создать методы:
 * - createNumbersFile - создает текстовый файл "numbers.txt" заполненный случайными целыми числами от 1 до 99. 10 строк
 * и по 10 чисел в каждой строке. Числа разделять пробелами.
 * - createOddNumbersFile - читает файл "numbers.txt", и создает на основе него новый файл "odd-numbers.txt" в который
 * входят все числа из "numbers.txt" только все четные заменены на 0.
 * В методе main продемонстрировать работу методов createNumbersFile и createOddNumbersFile. По желанию можно добавить
 * логирование работы программы.
 */
public class FileNumbers {
    static final String PATH = "src\\com\\pb\\avrakhov\\hw9\\files\\";
    static String data = "";
    private static final Logger LOGGER = Logger.getLogger(FileNumbers.class.getName());

    public static void main(String[] args) throws IOException, NumberFormatException {
        LogManager logManager = LogManager.getLogManager();
        logManager.readConfiguration(new FileInputStream(Paths.get(PATH + "logging.properties").toFile()));

        createNumbersFile();        //Создаем файл с числами
        createOddNumbersFile();     //Меняем четные на 0
    }

    //Создаем файл с рандомными числами [1; 99]
    public static void createNumbersFile() {
        try (Writer writer = new FileWriter(PATH + "numbers.txt")) {

            LOGGER.log(Level.INFO, "Создаем файл с данными.");

            //Создаем строку
            for (int j = 0; j < 10; j++){
                //Заполняем строку числами
                for (int i = 0; i < 10; i++) {
                    data += (int) (1 + Math.random() * 99) + " ";
                }
                data += "\n";
            }

            //Заносим данны в файл
            writer.write(data);
            System.out.println("The numbers file has been created.");
            LOGGER.log(Level.INFO, "The numbers file has been created.");
        } catch (Exception exception) {
            LOGGER.log(Level.SEVERE, "Error doing createNumbersFile.", exception);
        }
    }

    //Создаем новый файл с нечетными числами
    public static void createNumbersFile(String newData) {
        try (Writer writer = new FileWriter(PATH + "odd-numbers.txt")){
            writer.write(newData);
            System.out.println("\nA new file numbers has been created.");
            LOGGER.log(Level.INFO, "A new file numbers has been created.");
        } catch (Exception exception) {
            LOGGER.log(Level.SEVERE, "Error doing createNumbersFile new.", exception);
        }

        //Выводим новый файл в консоль
        try {
            Path path = Paths.get(PATH + "odd-numbers.txt");
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            showFile(lines);
        } catch (Exception exception) {
            LOGGER.log(Level.SEVERE, "Error console output.", exception);
        }
    }

    //Вывод файла в консоль
    public static void showFile(List<String> lines) {
        for (String string: lines) {
            System.out.println(string);
        }

        LOGGER.log(Level.INFO, "Console output.");
    }

    public static void createOddNumbersFile() throws NumberFormatException {
        Path path = Paths.get(PATH + "numbers.txt");
        data = "";

        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            showFile(lines);    //Выводим файл в консоль

            LOGGER.log(Level.INFO, "Заменяем четные цифры нулями.");

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
                        LOGGER.log(Level.SEVERE, "Error parseInt Integer.", exception);
                    }
                }

                data += "\n";
            }

            createNumbersFile(data);        //Создаем новый файл
        } catch (Exception exception) {
            LOGGER.log(Level.SEVERE, "Error readAllLines.", exception);
        }
    }
}
