package com.pb.avrakhov.hw13;

import java.util.LinkedList;

public class Producer extends Thread {
    private final LinkedList<String> buffer;
    private final LinkedList<String> data;

    public Producer(LinkedList<String> buffer, LinkedList<String> data) {
        this.buffer = buffer;
        this.data = data;
    }

    @Override
    public void run() {
        synchronized (buffer) {
            while (!data.isEmpty()) {
                System.out.println();

                while (buffer.size() < 5) {
                    System.out.println(getName() + " - " + data.get(0));
                    buffer.add(data.get(0));
                    data.remove(0);
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
