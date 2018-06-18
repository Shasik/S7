package main.model;

import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadHandler extends Thread {
    private LinkedBlockingQueue<Element> elements;


    public ThreadHandler(LinkedBlockingQueue<Element> elements) {
        this.elements = elements;
    }

    @Override
    public void run() {
        while (elements.size() != 0) handle(elements);

    }

    private void handle(LinkedBlockingQueue<Element> elements) {
        System.out.println(Objects.requireNonNull(elements.poll()).handle());
    }
}
