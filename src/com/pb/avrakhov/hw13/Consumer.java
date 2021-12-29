package com.pb.avrakhov.hw13;

import java.util.LinkedList;

public class Consumer extends Thread {
    private final LinkedList<String> buffer;

    public Consumer(LinkedList<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        synchronized (buffer) {
            while (!buffer.isEmpty()) {
                System.out.println();
                int count = 0;

                while (count < 5) {
                    System.out.println(getName() + ": " + buffer.get(0));
                    buffer.remove(0);
                    count++;
                }

                try {
                    buffer.notify();
                    buffer.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
