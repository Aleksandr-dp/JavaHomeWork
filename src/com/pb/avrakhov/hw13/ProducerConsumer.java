package com.pb.avrakhov.hw13;

import java.util.LinkedList;
import java.util.Random;
import java.util.stream.*;

/**
 * Создать пакет hw13. Написать программу решающую классическую задачу производитель и потребитель. Дано два потока —
 * производитель и потребитель. Два потока разделяют общий буфер данных, размер которого ограничен, например не больше
 * 5 элементов. Производитель генерирует некоторые данные (можно выбрать любые, числа, символы, строки) и помещает их в
 * буфер. Потребитель «потребляет» их из буфера - выводит на печать в консоль и очищает буфер. Если буфер пуст,
 * потребитель должен ждать, пока там появятся данные. Если буфер заполнен полностью, производитель должен ждать, пока
 * потребитель заберёт данные и место освободится. В качестве буфера можно выбрать, например Queue или List, но
 * реализация не должна быть потокобезопасная (например LinkedList).
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        LinkedList<String> data = IntStream.range(0, 20).mapToObj(i -> String.valueOf(randomChar())).collect(Collectors.toCollection(LinkedList::new));

        Producer producer = new Producer(queue, data);
        producer.setName("Producer");
        producer.start();

        Consumer consumer = new Consumer(queue);
        consumer.setName("Consumer");
        consumer.start();
    }

    //Генерация случайных символов
    public static char randomChar() {
        Random r = new Random();
        return (char) (48 + r.nextInt(47));
    }
}
