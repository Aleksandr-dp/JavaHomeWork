package com.pb.avrakhov.hw13;

import java.util.LinkedList;
import java.util.Random;
import java.util.stream.*;

public class ProducerConsumer {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<String>();
        LinkedList<String> data = IntStream.range(0, 20).mapToObj(i -> String.valueOf(randomChar())).collect(Collectors.toCollection(LinkedList::new));

        Producer producer = new Producer(queue, data);
        producer.setName("Producer");
        producer.start();

        Consumer consumer = new Consumer(queue);
        consumer.setName("Consumer");
        consumer.start();
    }

    public static char randomChar() {
        Random r = new Random();
        return (char) (48 + r.nextInt(47));
    }
}
