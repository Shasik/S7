package main.model;

import java.util.concurrent.LinkedBlockingQueue;

public class Handler {
    private LinkedBlockingQueue<Element> elementsGr1 = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<Element> elementsGr2 = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<Element> elementsGr3 = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<Element> elementsGr4 = new LinkedBlockingQueue<>();

    public Handler() {

    }

    public LinkedBlockingQueue<Element> getElementsGr1() {
        return elementsGr1;
    }

    public LinkedBlockingQueue<Element> getElementsGr2() {
        return elementsGr2;
    }

    public LinkedBlockingQueue<Element> getElementsGr3() {
        return elementsGr3;
    }

    public LinkedBlockingQueue<Element> getElementsGr4() {
        return elementsGr4;
    }

    public void inithandle() {
        ThreadHandler threadHandler1 = new ThreadHandler(elementsGr1);
        ThreadHandler threadHandler2 = new ThreadHandler(elementsGr2);
        ThreadHandler threadHandler3 = new ThreadHandler(elementsGr3);
        ThreadHandler threadHandler4 = new ThreadHandler(elementsGr4);

        threadHandler1.start();
        threadHandler2.start();
        threadHandler3.start();
        threadHandler4.start();
    }
}
